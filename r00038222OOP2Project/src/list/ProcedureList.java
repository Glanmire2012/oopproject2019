package list;

import objects.Procedure;

public class ProcedureList extends ObjectList{
	/**
	 * 
	 */
	private static final long serialVersionUID = -790648892469700130L;
	public Procedure procedure; 
	public int p;
	
	public ProcedureList addProcedure(Procedure procedure) {
		this.procedure = procedure;
		System.out.println("created procedure");
		this.add(procedure);	
		return null;
	}	
	public ProcedureList removeProcedure(int p) {
		this.p = p;
		this.remove(p);
		return null;
	}
}
