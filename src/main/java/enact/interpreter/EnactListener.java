package enact.interpreter;

import java.util.Collection;
import java.util.List;

import jason.asSyntax.Literal;

public interface EnactListener {

	public void addEnactEffect(Collection<Literal> effect);
	
	public void removeEnactEffect(Collection<Literal> effect);
	
}
