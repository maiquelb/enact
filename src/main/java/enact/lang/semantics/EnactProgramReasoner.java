package enact.lang.semantics;


import sai.util.reasoner.IReasoner;

public class EnactProgramReasoner extends EnactProgram {
	
	private IReasoner reasoner;

	public EnactProgramReasoner(IReasoner reasoner) {
		super();
		this.reasoner = reasoner;
	}
	
	public IReasoner getReasoner(){
		return this.reasoner;
	}

	@Override
	public EnactRule addEnactRule(EnactRule enactRule) throws Exception {
		synchronized(this.getRules()) {
		this.reasoner.assertValue("sai__enact__rule(" + enactRule.getY() + "," + enactRule.getEffect() + ")");
		return super.addEnactRule(enactRule);
		}
	}

	
		
	

}
