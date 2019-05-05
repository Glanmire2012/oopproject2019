package procedures;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import controller.Controller;
import javafx.scene.control.ScrollPane;
import list.ItemView;
import list.ObjectList;
import list.ProcedureList;
import objects.Procedure;
import screensanddisplay.MyGridPane;

public class DisplayProcedures extends ScrollPane implements Serializable {
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

	@SuppressWarnings("static-access")
	public DisplayProcedures() {
		this.instance = Controller.getInstance();
		this.procedureList = instance.getProcedureList();

		this.proGrid = new MyGridPane();
		this.proGrid.getChildren().clear();
		buildArrayLists();
		try {
			size = procedureList.getSize();
			for (int i = 0; i < size; i++) {
				this.procedureView = new ItemView((Procedure) procedureList.get(i));
				this.procedureView.setIndex(i);
				this.procedureView.procedureGrid();
				this.proGrid.setConstraints(procedureView, 0, i);
				this.proGrid.getChildren().add(procedureView);
			}

		} catch (NullPointerException e) {

			setupProcedures();
		}
		if (size <= 0) {

			setupProcedures();
		}
		this.setContent(proGrid);
	}

	public void buildArrayLists() {
		this.procedures = new ArrayList<String>();
		this.description = new ArrayList<String>();
		this.prices = new ArrayList<Double>();
		Collections.addAll(procedures, "Scale and Polish", "Examination, Diagnosis, Treatment Plan & Scale & Polish",
				"Examination, Diagnosis, Treatment Plan & Scale & Polish and X-rays", "X-ray (small)", "Prescription",
				"Hygiene Visit", "White Fillings", "Silver Fillings");
		Collections.addAll(description, "Scale and Polish", "Examination, Diagnosis, Treatment Plan & Scale & Polish",
				"Examination, Diagnosis, Treatment Plan & Scale & Polish and X-rays",
				"Find Cavities, Look at tooth roots, Check bone health,General Dental health check", "Prescription",
				"Regular or deep cleaning, Advice on oral health", "White Fillings", "Silver Fillings");
		Collections.addAll(prices, 60.00, 70.00, 80.00, 10.00, 40.00, 65.00, 90.00, 70.00);
	}

	public void setupProcedures() {
		try {
			int listSize = procedures.size();

			for (int i = 0; i < listSize; i++) {
				Procedure item = new Procedure(procedures.get(i), description.get(i), prices.get(i));

				this.procedureList.addProcedure(item);
			}
			this.instance.update(procedureList);

		} catch (NullPointerException n) {
			// n.printStackTrace();
		}
	}

	public void firstRun() {
		buildArrayLists();
		setupProcedures();
	}
}
