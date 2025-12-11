/**
 * This artifact implements a simple EnactListener for debugging of the enact processing in running MAS 
 * 
 */

package enact.bridges.jacamo;

import java.util.Collection;

import cartago.Artifact;
import cartago.OPERATION;
import cartago.OpFeedbackParam;
import enact.interpreter.EnactListener;
import jason.asSyntax.Literal;

public class EnactListenerArt extends Artifact implements EnactListener{

	@Override
	public void addEnactEffect(Collection<Literal> effect) {
		log("add enact effect: " + effect.toString());		
	}
	
	 @OPERATION 
	    public void getEnactListener(OpFeedbackParam<EnactListener> engine){
	        engine.set(this);
	    }

	@Override
	public void removeEnactEffect(Collection<Literal> effect) {
		log("add enact effect: " + effect.toString());
		
	}

}
