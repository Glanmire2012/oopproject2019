package tabs;

import controller.Controller;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import list.Procedure;
import list.ProcedureList;
import panes.MyGridPane;

public class UpdateProceduresTab extends MyGridPane{
	ComboBox<?> combo = new ComboBox();
	ProcedureList procedures;
	Controller instance;
	int size;
	public UpdateProceduresTab() {
		instance = Controller.getInstance();
		procedures = instance.getProcedureList();
		size = procedures.getSize();
		for ( int i = 0; i < size; i++) {
			Node proc = (Node) procedures.get(i);
			combo.getChildrenUnmodifiable().add(proc);
		}
		this.setConstraints(combo,0,0);
	}
}
