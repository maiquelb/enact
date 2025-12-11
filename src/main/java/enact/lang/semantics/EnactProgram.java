package enact.lang.semantics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Observable;

public class EnactProgram extends Observable {

	private Collection<EnactRule> rules = Collections.synchronizedList(new ArrayList<EnactRule>());

	public EnactProgram() {
		//this.rules = Collections.synchronizedList(new ArrayList<EnactRule>());
	}

	public Collection<EnactRule> getRules() {
		return rules;
	}

	public EnactRule addEnactRule(EnactRule enactRule) throws Exception {
		synchronized(this.getRules()) {
			this.rules.add(enactRule);}
		//		notifyObservers(this);
		return enactRule;
	}

	@Override
	public String toString() {
		String s = "";
		Iterator<EnactRule> it = this.getRules().iterator();
		while(it.hasNext())
			s = s.concat(it.next().toString()).concat(".\n");		
		return s;
	}

}
