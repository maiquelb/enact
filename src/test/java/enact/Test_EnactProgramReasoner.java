package enact;

import jason.asSyntax.Literal;
import jason.asSyntax.LogicalFormula;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.jupiter.api.Test;

import enact.interpreter.EnactReasoner;
import enact.lang.parser.enactLexer;
import enact.lang.parser.enactListenerImpl;
import enact.lang.parser.enactParser;
import enact.lang.semantics.EnactProgram;
import enact.lang.semantics.EnactProgramReasoner;
import enact.lang.semantics.EnactRule;

class Test_EnactProgramReasoner {

	@Test
	void testAddEnactRule() {
//		ConcurrentLinkedQueue<LogicalFormula> YQueue = new ConcurrentLinkedQueue<LogicalFormula>();
//		EnactReasoner reasoner = new EnactReasoner(YQueue);
//		EnactProgramReasoner program = new EnactProgramReasoner(reasoner.getReasoner());
//		loadEnactProgram(program);
//		
//
//		reasoner.start();
//		
//		
//		
//		 try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	private void loadEnactProgram(EnactProgram program) {
		InputStream is = null;
		try {
			is = new FileInputStream("demo.enact");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ANTLRInputStream input = null;
		try {
			input = new ANTLRInputStream(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        enactLexer constLexer = new enactLexer(input);        
        CommonTokenStream tokens = new CommonTokenStream(constLexer);
        enactParser constParser = new enactParser(tokens);
        ParseTree tree = constParser.enact_program();
        ParseTreeWalker walker = new ParseTreeWalker(); // create standard walker
        enactListenerImpl constExtractor = new enactListenerImpl(program);
        walker.walk(constExtractor, tree); // initiate walk of tree with listener
        
        
        
	}
	
}
