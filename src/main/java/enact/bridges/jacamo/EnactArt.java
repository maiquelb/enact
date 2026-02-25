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
import cartago.OpFeedbackParam;
import enact.interpreter.EnactListener;
import enact.interpreter.EnactReasoner;
import enact.lang.parser.enactLexer;
import enact.lang.parser.enactListenerImpl;
import enact.lang.parser.enactParser;
import enact.lang.semantics.EnactProgramReasoner;

import static enact.util.Util.loadEnactProgram;

import jason.asSyntax.Atom;
import jason.asSyntax.Literal;
import jason.asSyntax.Pred;
import jason.asSyntax.Structure;
import jason.asSyntax.parser.ParseException;
import jason.asSyntax.parser.TokenMgrError;
import npl.NPLInterpreter.EventType;
import npl.NormInstance;
import npl.NormativeListener;
import sai.main.institution.ConstitutiveListener;
import sai.main.institution.SaiEngine;
import sai.main.lang.semantics.statusFunction.AgentStatusFunction;
import sai.main.lang.semantics.statusFunction.EventStatusFunction;
import sai.main.lang.semantics.statusFunction.StateStatusFunction;

import static jason.asSyntax.ASSyntax.parseLiteral;
import static jason.asSyntax.ASSyntax.createAtom;

public class EnactArt extends Artifact implements ConstitutiveListener, NormativeListener{

	private static final Literal INST_FACT_ANNOT = createAtom("inst_fact");

	private ConcurrentLinkedQueue<Literal> YQueue = new ConcurrentLinkedQueue<Literal>();
	private EnactReasoner reasoner = new EnactReasoner(YQueue);
	private EnactProgramReasoner program = new EnactProgramReasoner(reasoner.getReasoner());
	
	void init(String enactProgram) {
		if(loadEnactProgram(enactProgram, this.program))
			this.reasoner.start();
	}




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


	/* Return the artifact itself as a NormativeListener */
	@OPERATION 
	public void getNormativeListener(OpFeedbackParam<NormativeListener> listener){
		listener.set(this);
	}	

	@Override
	public void created(NormInstance o) {	
		try {
			Pred p = new Pred(o.getFunctor());
			p.addTerms(o.getTerms());
			p.addAnnot(INST_FACT_ANNOT);
			p.addAnnot(o.getAnnot("created"));
			YQueue.add(p);			
		} catch (TokenMgrError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public void failure(Structure f) {		
		try {
			Literal l = f;
			l.addAnnot(parseLiteral("inst_fact"));
			YQueue.add(l);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TokenMgrError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}


	@Override
	public void fulfilled(NormInstance o) {
		Pred p = new Pred(o.getFunctor());
		p.addTerms(o.getTerms());
		p.addAnnot(INST_FACT_ANNOT);
		p.addAnnot(o.getAnnot("fulfilled"));
		YQueue.add(p);
	}


	@Override
	public void inactive(NormInstance o) {
		Pred p = new Pred(o.getFunctor());
		p.addTerms(o.getTerms());
		p.addAnnot(INST_FACT_ANNOT);
		p.addAnnot(o.getAnnot("inactive"));
		YQueue.add(p);
	}



	@Override
	public void unfulfilled(NormInstance o) {
		Pred p = new Pred(o.getFunctor());
		p.addTerms(o.getTerms());
		p.addAnnot(INST_FACT_ANNOT);
		p.addAnnot(o.getAnnot("unfulfilled"));
		YQueue.add(p);		
	}




	@Override
	public void sanction(String normId, EventType event, Literal sanction) {
		addNormativeFact(sanction);
	}


	

	public boolean addNormativeFact(Literal o, String functor) {
		Pred p = new Pred(functor);
		p.addTerm(o);
		return addNormativeFact(p);
	}
	
	public boolean addNormativeFact(Literal o) {
		try {
			o.addAnnot(INST_FACT_ANNOT);
			YQueue.add(o);
			return true;
		} catch (TokenMgrError e) {
			e.printStackTrace();
			return false;
		}		
	}


}
