package list;

import java.io.Serializable;

import javafx.scene.control.Button;
import javafx.scene.text.Text;
import objects.Procedure;
import procedures.UpdateProcedures;
import screensanddisplay.MyGridPane;

public class ItemView extends MyGridPane implements Serializable  {

	private static final long serialVersionUID = 1L;
	Procedure procedure;
	int index;//index of the procedure in the procedure list. 
public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	//	public ItemView(int time) {
//		this.time = time;
//	}
	public ItemView(Procedure procedure) {
		this.procedure = procedure;
		procedureGrid();
	}
//	@SuppressWarnings("static-access")
//	public void appointmentGrid() { // Creates a frame for
//		Text timeLabel = new Text("AVAILABLE");this.setConstraints(timeLabel,0,0);
//		Text timeText = new Text("" + time + "");this.setConstraints(timeLabel,0,1);
//		this.prefWidthProperty().bind(this.widthProperty());
//		this.getChildren().addAll(timeLabel, timeText);
//	}
	@SuppressWarnings("static-access")
	public void procedureGrid() {// Show procedure information
		Text procedureLabel = new Text("Treatment : ");this.setConstraints(procedureLabel,0,0);
		Text procedureText = new Text(procedure.getProcedureName());this.setConstraints(procedureText,1,0);
		Text descriptionLabel = new Text("Description : ");this.setConstraints(descriptionLabel,0,1);
		Text descriptionText = new Text(procedure.getProcedureDescription());this.setConstraints(descriptionText,1,1);
		Text priceLabel = new Text("Price : ");this.setConstraints(priceLabel,0,2);
		Text priceText = new Text(""+procedure.getPrice()+"");this.setConstraints(priceText,1,2);
		Button edit = new Button("Edit");this.setConstraints(edit,0,3);
		UpdateProcedures update = new UpdateProcedures(index);
		edit.setOnAction(e -> update.edit());
		this.prefWidthProperty().bind(this.widthProperty());
		this.getChildren().addAll(procedureLabel, procedureText, descriptionLabel, descriptionText, priceLabel, priceText, edit);
	}
	

}
