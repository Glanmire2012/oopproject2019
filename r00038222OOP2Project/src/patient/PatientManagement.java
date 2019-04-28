package patient;

import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import screensanddisplay.MyTabPane;
import tabs.SearchTab;
import tabs.ShowAllTab;
import tabs.NewPatientTab;

public class PatientManagement extends MyTabPane {
	public PatientManagement() {
	
	BorderPane border = new BorderPane();
	Tab NewPatients = new Tab("New Patient");
	Tab Search = new Tab("Search");
	Tab ShowAll = new Tab("Show All");
	
	NewPatientTab newPat = new NewPatientTab();
	SearchTab search = new SearchTab();
	ShowAllTab showAll = new ShowAllTab();
	NewPatients.setContent(newPat);
	Search.setContent(search);
	ShowAll.setContent(showAll);

	this.getTabs().add(ShowAll);
	this.getTabs().add(Search);
	this.getTabs().add(NewPatients);
	
	// bind to take available space
	border.prefHeightProperty().bind(this.heightProperty());
	border.prefWidthProperty().bind(this.widthProperty());

	//border.setTop(this);

	}
}
