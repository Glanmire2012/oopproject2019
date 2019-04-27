package tabs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import controller.Controller;
import javafx.scene.control.ScrollPane;
import list.ItemView;
import list.ObjectList;
import list.Procedure;
import list.ProcedureList;
import panes.MyGridPane;

public class DisplayProceduresTab extends ScrollPane implements Serializable {
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
	public DisplayProceduresTab() {
		this.instance = Controller.getInstance();
		this.procedureList = instance.getProcedureList();
		proGrid = new MyGridPane();
		proGrid.getChildren().clear();
		buildArrayLists();
		try {
			size = procedureList.getSize();
			for ( int i = 0; i < size; i++ ) {
				procedureView = new ItemView((Procedure)procedureList.get(i));
				procedureView.setIndex(i);
				procedureView.procedureGrid();proGrid.setConstraints(procedureView, 0, i);
				proGrid.getChildren().add(procedureView);
			}
			
		}
		catch(NullPointerException e){
			System.out.println("Null at procedure");
			setupProcedures();
		}
		if (size <=0 ) {
			System.out.println("zero at procedure");
			setupProcedures();
		}
		this.setContent(proGrid);
	}
	public void buildArrayLists() {
		procedures = new ArrayList<String>();
		description = new ArrayList<String>();
		prices = new ArrayList<Double>();
		Collections.addAll(procedures,"Scale and Polish","Examination, Diagnosis, Treatment Plan & Scale & Polish","Examination, Diagnosis, Treatment Plan & Scale & Polish and X-rays","X-ray (small)","Prescription","Hygiene Visit","White Fillings","Silver Fillings");
		Collections.addAll(description,"Scale and Polish","Examination, Diagnosis, Treatment Plan & Scale & Polish","Examination, Diagnosis, Treatment Plan & Scale & Polish and X-rays","Find Cavities, Look at tooth roots, Check bone health,General Dental health check","Prescription","Regular or deep cleaning, Advice on oral health","White Fillings","Silver Fillings");
		Collections.addAll(prices, 60.00, 70.00, 80.00, 10.00, 40.00, 65.00, 90.00, 70.00);
	}
	public void setupProcedures() {
		int listSize = procedures.size();
		for (int i = 0; i < listSize; i++) {
			Procedure item = new Procedure(procedures.get(i), description.get(i), prices.get(i));
			instance.procedureList.addProcedure(item);
		}
		instance.update(procedureList);
		
	}
}
