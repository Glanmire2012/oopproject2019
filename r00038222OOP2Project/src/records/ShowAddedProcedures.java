package records;

import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import list.ProceduresDone;
import objects.Appointment;
import objects.Procedure;

public class ShowAddedProcedures extends GridPane{
	Appointment appointment;
	ProceduresDone procedures;
	double totalPrice;
	
	public ShowAddedProcedures(ProceduresDone procedures, Appointment appointment) {
		super();
		this.procedures = procedures;
		displayGrid();
	}
	
	@SuppressWarnings("static-access")
	public void displayGrid() {
		try {
			int size = procedures.getSize();
			for ( int i =0; i < size; i++) {
				Procedure pro = (Procedure) procedures.get(i);
				Text procedureText = new Text(pro.getProcedureName());this.setConstraints(procedureText, 0, i);
				Text priceText = new Text("Cost €"+pro.getPrice()+"");this.setConstraints(priceText, 1, i);
				System.out.println("adding");
				this.getChildren().addAll(procedureText,priceText);
				this.totalPrice = totalPrice+pro.getPrice();
			}
		}
		catch(NullPointerException n) {
			Text noProcedures = new Text("No procedures have been added to this appointment");
			this.setConstraints(noProcedures, 0,0);
		}
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
}
