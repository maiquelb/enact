package enact.interpreter;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

import jason.RevisionFailedException;
import jason.asSemantics.Unifier;
import jason.asSyntax.Literal;
import jason.asSyntax.LogicalFormula;
import jason.asSyntax.parser.ParseException;

import sai.util.reasoner.BasicReasonerHttpGUI;
import sai.util.reasoner.IReasoner;
import sai.util.reasoner.jason.JasonReasoner;

public class EnactReasoner extends Thread {

	private JasonReasoner reasoner;
	private AbstractQueue<Literal> queue;
	private int globalCicle = 0;
	private CopyOnWriteArrayList<EnactListener> enactListeners = new CopyOnWriteArrayList<EnactListener>();

	public EnactReasoner(AbstractQueue<Literal> queue) {
		super();
		this.queue = queue;
		this.reasoner = new JasonReasoner(BasicReasonerHttpGUI.get(8999));
		try {
			this.reasoner.assertValue("enact__effect(Effect):-sai__enact__rule(Sai__Y,Effect)&Sai__Y");
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

	@Override
	public void run() {
		try {
			while (true) {				globalCicle++;
			Literal s = queue.poll();
			if (s != null) {
				this.reasoner.retract("_[inst_fact]");
				reasoner.assertValue(s.toString());
				Collection<Literal>  effects = calculate();
				if(effects.size()>0)
						for(EnactListener l : this.enactListeners) {
							l.addEnactEffect(effects);
							sleep(10);	
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


	/**
	 * Calculate new enactments.
	 * @throws Exception 
	 * @return a Collection of enactments
	 */
	private synchronized Collection<Literal> calculate() throws Exception {
		ArrayList<Literal> effectsList = new ArrayList<Literal>();
		Iterator<Unifier> newEffects = this.reasoner.findall("enact__effect(Effect)"); //check new effects
		while(newEffects.hasNext()) 
			effectsList.add((Literal) newEffects.next().get("Effect"));
		globalCicle++;
		return effectsList;

	}


	public void addEnactListener(EnactListener listener) {
		synchronized (enactListeners) {
			enactListeners.add(listener);
		}
	}

}
