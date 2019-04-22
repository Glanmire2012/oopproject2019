package panes;

import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import tabs.SearchTab;
import tabs.ShowAll;
import tabs.newPatientTab;

public class patientManagement extends MyTabPane {
	public patientManagement() {
	
	BorderPane border = new BorderPane();
	Tab NewPatients = new Tab("New Patient");
	Tab Search = new Tab("Search");
	Tab ShowAll = new Tab("Show All");
	
	newPatientTab newPat = new newPatientTab();
	SearchTab search = new SearchTab();
	ShowAll showAll = new ShowAll();
	NewPatients.setContent(newPat);
	Search.setContent(search);
	ShowAll.setContent(showAll);


	this.getTabs().add(NewPatients);
	this.getTabs().add(Search);
	this.getTabs().add(ShowAll);
	
	// bind to take available space
	border.prefHeightProperty().bind(this.heightProperty());
	border.prefWidthProperty().bind(this.widthProperty());

	//border.setTop(this);

	}
}
