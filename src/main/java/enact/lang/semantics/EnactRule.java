package enact.lang.semantics;

import jason.asSyntax.LogicalFormula;
import jason.asSyntax.Literal;

public class EnactRule {

	private LogicalFormula Y;
	private Literal effect;
	
	public LogicalFormula getY() {
		return Y;
	}
	public void setY(LogicalFormula y) {
		Y = y;
	}
	public Literal getEffect() {
		return effect;
	}
	public void setEffect(Literal effect) {
		this.effect = effect;
	}
	@Override
	public String toString() {
		return  Y + " enact-as " + effect ;
	}
	
	
	
	
	
}
