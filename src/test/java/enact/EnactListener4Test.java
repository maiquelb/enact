package enact;

import java.util.ArrayList;
import java.util.Collection;

import enact.interpreter.EnactListener;
import jason.asSyntax.Literal;

public class EnactListener4Test implements EnactListener {

	private int counter = 0;
	private ArrayList<Literal> effects = new ArrayList<Literal>();


	@Override// TODO Auto-generated method stuberride
	public void addEnactEffect(Collection<Literal> effect) {
		for(Literal l:effect) {			
			effects.add(l);
			//System.out.println("[EnactListener4Test] added " + l + " - " + this.getEffects().size() );
			counter++;
		}

	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}


	public Collection<Literal> getEffects(){
		return this.effects;
	}

	@Override
	public void removeEnactEffect(Collection<Literal> effect) {		
		for(Literal l:effect) {
			this.effects.remove(l);
			//System.out.println("[EnactListener4Test] removed " + l);
		}
		this.counter++;		
	}

}
