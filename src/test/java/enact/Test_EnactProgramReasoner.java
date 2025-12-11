package enact;

import jason.asSyntax.Literal;
import jason.asSyntax.parser.ParseException;
import jason.asSyntax.parser.TokenMgrError;

import static jason.asSyntax.ASSyntax.parseLiteral;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import enact.interpreter.EnactReasoner;
import enact.lang.semantics.EnactProgramReasoner;

import static enact.util.Util.loadEnactProgram;

public class Test_EnactProgramReasoner {

	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();

	@Test
	public void testLoadProgram() {
		File file = writeTestProgram();

		assertNotNull(file);

		ConcurrentLinkedQueue<Literal> YQueue = new ConcurrentLinkedQueue<>();
		EnactReasoner reasoner = new EnactReasoner(YQueue);
		EnactProgramReasoner program = new EnactProgramReasoner(reasoner.getReasoner());

		String expected = "((x(y) & v(W)) | (a(b,W) & not (t))) enact-as test(W).\n" +
				"v(Y) enact-as b(Y).\n"+
				"w(Y) enact-as b(Y).\n";

		if (loadEnactProgram(file.getAbsolutePath(), program)) {
			assertEquals(program.toString().replace("\r\n", "\n"), expected);
		}
		else
			assertTrue(false);

	}

	/*
	 * Test the production of new effects 
	 */
	@Test
	public void test_add_new_effects() throws ParseException, TokenMgrError {
		File file = writeTestProgram();
		EnactListener4Test listener = new EnactListener4Test();
		ConcurrentLinkedQueue<Literal> YQueue = new ConcurrentLinkedQueue<>();
		EnactReasoner reasoner = new EnactReasoner(YQueue);
		EnactProgramReasoner program = new EnactProgramReasoner(reasoner.getReasoner());
		reasoner.addEnactListener(listener);
		loadEnactProgram(file.getAbsolutePath(), program);
		reasoner.start();

		YQueue.add(parseLiteral("v(3)"));

		int i=0;
		while(i<1000 && listener.getCounter()==0) { 
			i++;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		assertEquals(listener.getEffects().size(), 1); //check whether 1 effect has been produced

		listener.setCounter(0);



		YQueue.add(parseLiteral("x(y)"));

		i=0;
		listener.setCounter(0);
		while(i<1000000 && listener.getCounter()==0) { 
			i++;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		
		assertEquals(listener.getEffects().size(), 2); //check whether a second effect has been produced



		//*** Remove a fact - must delete an effect        
		try {
			reasoner.retract("v(3)");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		i=0;
		listener.setCounter(0);
		while(i<10000000 && listener.getCounter()==0) { 
			i++;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}        
		}

		assertFalse(reasoner.getEnactEffects().contains(parseLiteral("b(3)")));
		assertEquals(listener.getEffects().size(), 0);

			
		YQueue.add(parseLiteral("v(3)"));
		i=0;
		listener.setCounter(0);
		while(i<1000 && listener.getCounter()==0) { 
			i++;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		assertEquals(listener.getEffects().size(), 2); 
		

		//add a new fact that enact an effect that already exists - nothing must happen
		YQueue.add(parseLiteral("w(3)"));
		i=0;
		listener.setCounter(0);
		while(i<1000 && listener.getCounter()==0) { 
			i++;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		assertEquals(listener.getEffects().size(), 2); 


		//*** Remove a fact whose enactment is also enacted by another valid fact - the enactment must not be dropped        
		try {
			reasoner.retract("w(3)");
		} catch (Exception e) {
			e.printStackTrace();
		}
		i=0;
		listener.setCounter(0);
		while(i<1000 && listener.getCounter()==0) { 
			i++;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}        
		}
		assertEquals(listener.getEffects().size(), 2);

	}

	private File writeTestProgram() {
		File file = null;
		try {
			file = tempFolder.newFile("test.enact");  

			try (FileWriter fw = new FileWriter(file)) {
				fw.write(
						"x(y) & v(W) | a(b,W) & not(t) enact-as test(W).\n" +
								"v(Y) enact-as b(Y).\n" +
								"w(Y) enact-as b(Y)."
						);
			}

		} catch (IOException e) {
			e.printStackTrace();
			fail("Erro ao criar arquivo temporário");
		}
		return file;
	}
}
