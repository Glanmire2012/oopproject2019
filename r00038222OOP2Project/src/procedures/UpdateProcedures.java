package procedures;

import controller.Controller;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import list.ProcedureList;
import objects.Procedure;
import screensanddisplay.MyGridPane;

public class UpdateProcedures extends MyGridPane{
	
	ProcedureList procedures;
	Controller instance;
	Procedure toBeEdited;
	public int i;
	int size;
	public UpdateProcedures(int i) {
		this.instance = Controller.getInstance();
		this.procedures = instance.getProcedureList();
		this.i = i;
	}
	@SuppressWarnings("static-access")
	public void edit() {
		toBeEdited = (Procedure) procedures.get(i);
		Text procedureLabel = new Text("Procedure Name : ");this.setConstraints(procedureLabel,0,0);
		TextField procedureText = new TextField(toBeEdited.getProcedureName());this.setConstraints(procedureText,1,0);
	}
}
