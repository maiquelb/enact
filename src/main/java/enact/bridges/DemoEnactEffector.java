/**
 * This class is a simple demo of an enact listener, which receives enact results from the EnactReasoner.
 */

package enact.bridges;

import java.util.Collection;

import enact.interpreter.EnactListener;
import jason.asSyntax.Literal;

public class DemoEnactEffector implements EnactListener {

	@Override
	public void addEnactEffect(Collection<Literal> effect) {
		System.out.println("[DemoEnactEffector] adding effects " + effect);

	}

	@Override
	public void removeEnactEffect(Collection<Literal> effect) {
		System.out.println("[DemoEnactEffector] removing effects " + effect);
		
	}

}
