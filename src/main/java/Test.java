
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Iterator;
//
//import org.antlr.v4.runtime.*;
//import org.antlr.v4.runtime.tree.*;
//
//import enact.lang.parser.*;
//import enact.lang.semantics.EnactProgram;
//import enact.lang.semantics.EnactRule;
import jason.asSyntax.Literal;
import jason.asSyntax.LogicalFormula;
import jason.asSyntax.parser.ParseException;
import jason.asSyntax.parser.TokenMgrError;

import static jason.asSyntax.ASSyntax.parseFormula;
import static jason.asSyntax.ASSyntax.parseLiteral;

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

import enact.bridges.DemoEnactEffector;
import enact.interpreter.EnactReasoner;
import enact.lang.parser.enactLexer;
import enact.lang.parser.enactListenerImpl;
import enact.lang.parser.enactParser;
import enact.lang.semantics.EnactProgram;
import enact.lang.semantics.EnactProgramReasoner;
import enact.lang.semantics.EnactRule;

public class Test {

	public static void main(String[] args) {


		//		try {
		//			System.out.println(parseFormula("x(y)"));
		//		} catch (ParseException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		} catch (TokenMgrError e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}

		// TODO Auto-generated method stub
		//		String input = "a(X) enact-as b(Y).";
		//        enactLexer lexer = new enactLexer(CharStreams.fromString(input));
		//        CommonTokenStream tokens = new CommonTokenStream(lexer);
		//        enactParser parser = new enactParser(tokens);
		//
		//        ParseTree tree = parser.enact_program();
		//        System.out.println(tree.toStringTree(parser));

		//		EnactProgram program = new EnactProgram();
		//		
		//		InputStream is = null;
		//		try {
		//			is = new FileInputStream("demo.enact");
		//		} catch (FileNotFoundException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}
		//        ANTLRInputStream input = null;
		//		try {
		//			input = new ANTLRInputStream(is);
		//		} catch (IOException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}
		//        enactLexer constLexer = new enactLexer(input);        
		//        CommonTokenStream tokens = new CommonTokenStream(constLexer);
		//        enactParser constParser = new enactParser(tokens);
		//        ParseTree tree = constParser.enact_program();
		//        ParseTreeWalker walker = new ParseTreeWalker(); // create standard walker
		//        enactListenerImpl constExtractor = new enactListenerImpl(program);
		//        walker.walk(constExtractor, tree); // initiate walk of tree with listener
		//        
		//        
		//        Iterator<EnactRule> it = program.getRules().iterator();
		//        while(it.hasNext())
		//        	System.out.println("* RULE: " + it.next());
		//


		ConcurrentLinkedQueue<Literal> YQueue = new ConcurrentLinkedQueue<Literal>();
		EnactReasoner reasoner = new EnactReasoner(YQueue);
		EnactProgramReasoner program = new EnactProgramReasoner(reasoner.getReasoner());
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



		DemoEnactEffector effector = new DemoEnactEffector();
		reasoner.addEnactListener(effector);

		try {			
			reasoner.getReasoner().assertValue("x(y)");
			//reasoner.getReasoner().assertValue("v(99)");
			//reasoner.getReasoner().assertValue("a(b,99)");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		reasoner.start();




		int i = 100;
		while(i>0) {

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("---------");

			try {
				YQueue.add(parseLiteral("v("+i--+")[inst_fact]"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
