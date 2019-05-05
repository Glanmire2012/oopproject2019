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

public class ProcedureManagement extends GridPane implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProcedureManagement() {

		ScrollPane scroll = new ScrollPane();
		DisplayProcedures disProc = new DisplayProcedures();

		this.getChildren().clear();

		scroll.setContent(disProc);
		this.setConstraints(scroll, 0, 1);
		this.getChildren().addAll(scroll);

		// bind to take available space
		this.prefWidthProperty().bind(this.widthProperty());
		this.prefHeightProperty().bind(this.heightProperty());
		this.prefWidthProperty().bind(this.widthProperty());

	}

}
