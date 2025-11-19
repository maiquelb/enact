package enact.bridges.jacamo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import cartago.Artifact;
import cartago.OPERATION;
import enact.interpreter.EnactListener;
import enact.interpreter.EnactReasoner;
import enact.lang.parser.enactLexer;
import enact.lang.parser.enactListenerImpl;
import enact.lang.parser.enactParser;
import enact.lang.semantics.EnactProgramReasoner;
import jason.asSyntax.Atom;
import jason.asSyntax.Literal;
import jason.asSyntax.Pred;
import jason.asSyntax.parser.ParseException;
import jason.asSyntax.parser.TokenMgrError;
import sai.main.institution.ConstitutiveListener;
import sai.main.institution.SaiEngine;
import sai.main.lang.semantics.statusFunction.AgentStatusFunction;
import sai.main.lang.semantics.statusFunction.EventStatusFunction;
import sai.main.lang.semantics.statusFunction.StateStatusFunction;

import static jason.asSyntax.ASSyntax.parseLiteral;

public class EnactArt extends Artifact implements ConstitutiveListener{
	
	
	private ConcurrentLinkedQueue<Literal> YQueue = new ConcurrentLinkedQueue<Literal>();
	private EnactReasoner reasoner = new EnactReasoner(YQueue);
	private EnactProgramReasoner program = new EnactProgramReasoner(reasoner.getReasoner());
	
	void init(String enactProgram) {
		loadEnactProgram(enactProgram);
	}

	
	private boolean loadEnactProgram(String filename) {
		InputStream is = null;
		ANTLRInputStream input = null;
		try {
			is = new FileInputStream(filename);
			input = new ANTLRInputStream(is);
			enactLexer constLexer = new enactLexer(input);        
			CommonTokenStream tokens = new CommonTokenStream(constLexer);
			enactParser constParser = new enactParser(tokens);
			ParseTree tree = constParser.enact_program();
			ParseTreeWalker walker = new ParseTreeWalker(); // create standard walker
			enactListenerImpl constExtractor = new enactListenerImpl(program);
			walker.walk(constExtractor, tree); // initiate walk of tree with listener
			reasoner.start();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
//	@Override
//	public void addEnactEffect(Collection<Literal> effect) {
//		log(effect.toString());		
//	}

	
	/**
	 * Add some source of institutional fact (e.g. SAI engine, NPL engine etc)
	 */
	@OPERATION
	public void addInstitutionalFactSource(Object source) {
		if(source instanceof SaiEngine) {
			((SaiEngine) source).addConstitutiveListener(this);
		}
	}
	
	
	/**
	 * Add a listener to the embedded enact-reasoner
	 * @param listener
	 */
	@OPERATION
	public void addEnactListener(EnactListener listener) {
		this.reasoner.addEnactListener(listener);
	}

	@Override
	public void addStateAssignment(String assignee, StateStatusFunction sf) {
		try {
			YQueue.add(parseLiteral("sai__is("+assignee+","+sf+")[inst_fact]")); //add the constited elements in the form sai__is(X, Y)
			Pred stateFact = sf.getState();
			stateFact.addAnnot(parseLiteral("inst_fact"));
			YQueue.add(stateFact); //add the constituted state-SF as a fact (e.g. play(Ag,Role,Group))
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TokenMgrError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void addAgentAssignment(String assignee, AgentStatusFunction sf) {
//		System.out.println("adding agent assignment: " + assignee + "count-as " + sf );		
		try {
			YQueue.add(parseLiteral("sai___is("+assignee+","+sf+")[inst_fact]"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TokenMgrError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addEventAssignment(String assignee, EventStatusFunction sf, Atom agent) {
//		System.out.println("adding event assignment: " + assignee + "count-as " + sf );
		try {
			YQueue.add(parseLiteral("sai___is("+assignee+","+sf+")[inst_fact]"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TokenMgrError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void removeStateAssignment(String assignee, StateStatusFunction sf) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAgentAssignment(String assignee, AgentStatusFunction sf) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeEventAssignment(String assignee, EventStatusFunction sf, AgentStatusFunction agent) {
		// TODO Auto-generated method stub
		
	}
	

}
