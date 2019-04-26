package panes;

import controller.Controller;
import list.Procedure;
import list.ProcedureList;

public class ProcedureManagement {
	Controller instance;
	ProcedureList procedureList;
	int size;
	public ProcedureManagement() {
		this.instance = Controller.getInstance();
		this.procedureList = instance.getProcedureList();
		try {
			size = procedureList.getSize();
		}
		catch(NullPointerException e){
			setupProcedures();
		}
		if (size <=0 ) {
			setupProcedures();
		}
	}
	
	public void setupProcedures() {
		
		Procedure one = new Procedure()
	}
	
	
}
