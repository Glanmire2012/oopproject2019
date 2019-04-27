package procedures;

import java.io.Serializable;
import java.util.ArrayList;

import controller.Controller;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import list.ItemView;
import list.ObjectList;
import list.ProcedureList;
import objects.Procedure;
import screensanddisplay.MyGridPane;

public class ProcedureManagement extends GridPane implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Controller instance;
	ProcedureList procedureList;
	Procedure procedure;
	ItemView procedureView;
	ObjectList forDisplay;
	MyGridPane proGrid;
	ArrayList<String> procedures;
	ArrayList<Double> prices;
	ArrayList<String> description;
	int size;
	public ProcedureManagement() {
	
		
		ScrollPane scroll = new ScrollPane();
		DisplayProcedures disProc = new DisplayProcedures();
		//UpdateProceduresTab upProc = new UpdateProceduresTab();
		this.getChildren().clear();
		Button add = new Button("Add Procedure");this.setConstraints(add,0,0);
		scroll.setContent(disProc);this.setConstraints(scroll,0,1);
		this.getChildren().addAll(scroll, add);
		//this.getTabs().add(updateProcedures);
		
		
		// bind to take available space
		this.prefWidthProperty().bind(this.widthProperty());
		this.prefHeightProperty().bind(this.heightProperty());
		this.prefWidthProperty().bind(this.widthProperty());

		//border.setTop(this);
	}

}
