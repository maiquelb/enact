package enact.lang.parser;

import jason.asSyntax.parser.ParseException;
import jason.asSyntax.parser.TokenMgrError;

import static jason.asSyntax.ASSyntax.parseFormula;
import static jason.asSyntax.ASSyntax.parseLiteral;

import enact.lang.semantics.EnactProgram;
import enact.lang.semantics.EnactRule;

public class enactListenerImpl extends enactBaseListener {
	
	private EnactProgram program;

	public enactListenerImpl(EnactProgram program) {
		super();
		this.program = program;
	}

	
	@Override 
	public void exitEnact_rule(enactParser.Enact_ruleContext ctx) {
		EnactRule rule = new EnactRule();
		try {			
			rule.setY(parseFormula(ctx.y().getText().toString()));
			rule.setEffect(parseLiteral(ctx.enact_effect().getText()));
			this.program.addEnactRule(rule);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TokenMgrError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
