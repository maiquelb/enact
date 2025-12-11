package enact.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import enact.interpreter.EnactReasoner;
import enact.lang.parser.enactLexer;
import enact.lang.parser.enactListenerImpl;
import enact.lang.parser.enactParser;
import enact.lang.semantics.EnactProgramReasoner;

public class Util {

	public static boolean loadEnactProgram(String fileName, EnactProgramReasoner program ) {
		InputStream is = null;
		ANTLRInputStream input = null;
		try {
			is = new FileInputStream(fileName);
			input = new ANTLRInputStream(is);
			enactLexer constLexer = new enactLexer(input);        
			CommonTokenStream tokens = new CommonTokenStream(constLexer);
			enactParser constParser = new enactParser(tokens);
			ParseTree tree = constParser.enact_program();
			ParseTreeWalker walker = new ParseTreeWalker(); // create standard walker
			enactListenerImpl constExtractor = new enactListenerImpl(program);
			walker.walk(constExtractor, tree); // initiate walk of tree with listener
//			reasoner.start();
			
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
	
}
