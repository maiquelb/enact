package enact.interpreter;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import jason.RevisionFailedException;
import jason.asSemantics.Unifier;
import jason.asSyntax.Literal;
import jason.asSyntax.LogicalFormula;
import jason.asSyntax.parser.ParseException;

import sai.util.reasoner.BasicReasonerHttpGUI;
import sai.util.reasoner.IReasoner;
import sai.util.reasoner.jason.JasonReasoner;

import static jason.asSyntax.ASSyntax.createAtom;

public class EnactReasoner extends Thread {

	public record EnactFact(Literal y, Literal x) {};

	private static final Literal RETRACT_FACT = createAtom("enact___retract");  

	private JasonReasoner reasoner;
	private AbstractQueue<Literal> queue;
	private int globalCicle = 0;
	private CopyOnWriteArrayList<EnactListener> enactListeners = new CopyOnWriteArrayList<EnactListener>();
	private Set<Literal> enactEffects = new HashSet<Literal>(); //a set of enact effects
	private HashMap<LogicalFormula, ArrayList<Literal>> enactFacts = new HashMap<LogicalFormula, ArrayList<Literal>>();	

	public EnactReasoner(AbstractQueue<Literal> queue) {
		super();
		this.queue = queue;
		this.reasoner = new JasonReasoner(BasicReasonerHttpGUI.get(8004));
		try {
			this.reasoner.assertValue("enact__effect(Sai__Y,Effect):-sai__enact__rule(Sai__Y,Effect)&Sai__Y");
		} catch (RevisionFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public IReasoner getReasoner() {
		return this.reasoner;
	}

	//check whether the effect can be removed 
	private boolean canRemove(Literal effect) {
		try {
			for(Map.Entry<LogicalFormula, ArrayList<Literal>> fact : enactFacts.entrySet()) //get the list of effects of each "Y
				for(Literal l: fact.getValue()) { //for each effect in the list					
					if(l.equals(effect) && this.reasoner.check(fact.getKey().toString())) 
						return false;
				}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public void run() {
		ArrayList<Literal> toDelete = new ArrayList<Literal>();
		//		ArrayList<LogicalFormula> toDeleteFacts = new ArrayList<LogicalFormula>();
		try {
			while (true) {				
				globalCicle++;
				Literal s = queue.poll();
				if (s != null) { //if the institutional state changes
					reasoner.assertValue(s.toString());
					//look for facts to remove
					for(Map.Entry<LogicalFormula, ArrayList<Literal>> fact : enactFacts.entrySet()){ //for each pair (y,X) where X is a set of enact effects												
						if(!this.reasoner.check(fact.getKey().toString())) 	 
							for(Literal l: fact.getValue()) { //... for each effect in the set X
								if(canRemove(l)){ //if the effect is not effect of another valid fact
									this.enactEffects.remove(l); //remove the corresponding effect
									toDelete.add(l); //add to the list of facts to remove (to be sent to the listeners)
								}
							}

					}
					if(toDelete.size()>0) {
						for(EnactListener l : this.enactListeners) { 
							l.removeEnactEffect(toDelete);
						}
						toDelete.clear();
					}



					//calculate new facts
					Collection<EnactFact>  effects = calculate(); //get a set of effects
					Collection<Literal> effectsFinal = new ArrayList<Literal>(); //effectsFinal is the set of new effects added in the current round
					for(EnactFact l : effects) {						
						addEnactFact(l.y, l.x); // add the effect x to the set of effects of y

						if(!enactEffects.contains(l.x)) { 
							enactEffects.add(l.x); //add the effect x to the current enact state
							effectsFinal.add(l.x); //add the effect x to the set of new effects added in the current round 
						}
					}
					if(effectsFinal.size()>0) {
						for(EnactListener l : this.enactListeners) {
							l.addEnactEffect(effectsFinal);
						}
					}
				} else {
					sleep(100);
				}
			}
		} catch (Throwable t) {
			System.err.println("[EnactReasoner] Thread encerrada por exceção:");
			t.printStackTrace();
		} finally {
			System.out.println("[EnactReasoner] Thread finalizada.");
		}


	}


	private boolean addEnactFact(LogicalFormula y, Literal x) {
		if(enactFacts.get(y)!=null)
			enactFacts.get(y).add(x);
		else {
			ArrayList<Literal> l = new ArrayList<Literal>();
			l.add(x);
			enactFacts.put(y, l);		
		}
		return true;
	}

	/**
	 * Calculate new enactments.
	 * @throws Exception 
	 * @return a Collection of enactments
	 */
	private synchronized Collection<EnactFact> calculate() throws Exception {
		ArrayList<EnactFact> effectsList = new ArrayList<EnactFact>();
		Iterator<Unifier> newEffects = this.reasoner.findall("enact__effect(Sai__Y,Effect)"); //check new effects
		while(newEffects.hasNext()) { 
			Unifier un = newEffects.next();
			effectsList.add(new EnactFact((Literal)un.get("Sai__Y"), (Literal)un.get("Effect")));
		}
		globalCicle++;
		return effectsList;

	}


	public void addEnactListener(EnactListener listener) {
		synchronized (enactListeners) {
			enactListeners.add(listener);
		}
	}


	/**
	 * Remove the fact f and create a fact enact___retract (that triggers a new evaluation cycle)
	 * @param f
	 */
	public void retract(String f) {
		try {
			this.reasoner.retract(f);
			this.queue.add(RETRACT_FACT);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Set<Literal> getEnactEffects(){
		return this.enactEffects;
	}

}
