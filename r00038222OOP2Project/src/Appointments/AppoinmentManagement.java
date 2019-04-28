package Appointments;

import java.io.Serializable;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

public class AppoinmentManagement extends GridPane implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("static-access")
	public AppoinmentManagement() {
		super();
		ColumnConstraints column = new ColumnConstraints();
		column.setPercentWidth(100);
		this.getColumnConstraints().add(column);
		ScrollPane scroll = new ScrollPane();
		DisplayAppoinments disApp = new DisplayAppoinments();
		//UpdateProceduresTab upProc = new UpdateProceduresTab();
		this.getChildren().clear();
		Button add = new Button("n");this.setConstraints(add,0,0);
		scroll.setContent(disApp);this.setConstraints(scroll,0,1);
		this.getChildren().addAll(scroll, add);
		//this.getTabs().add(updateProcedures);
		
		
		// bind to take available space
		this.minWidthProperty().bind(this.widthProperty());
		this.prefHeightProperty().bind(this.heightProperty());
		this.prefWidthProperty().bind(this.widthProperty());
	}
	
}
