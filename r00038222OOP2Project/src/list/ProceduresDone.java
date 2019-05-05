package list;

import objects.Procedure;

public class ProceduresDone extends ObjectList {

	private static final long serialVersionUID = 1L;

	public Procedure procedure;
	public int p;

	public ProceduresDone addProcedure(Procedure procedure) {
		this.procedure = procedure;
		this.add(procedure);
		return null;
	}

	public ProceduresDone removeProcedure(int p) {
		this.p = p;
		this.remove(p);
		return null;
	}
}
