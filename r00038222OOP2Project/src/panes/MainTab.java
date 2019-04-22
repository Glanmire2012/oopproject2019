package panes;

import Appointments.AppointmentTab;
import dataentry.Welcome;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;

public class MainTab extends MyTabPane {
	public MainTab() {	
		BorderPane border = new BorderPane();
		Tab Patients = new Tab("Patient Management");
		Tab Welcome = new Tab("CIT Dental");
		Tab Procedures = new Tab("Procedures");
		Tab Appointments = new Tab("Appointments");
		patientManagement patMan = new patientManagement();
		AppointmentTab appoint = new AppointmentTab();

		Patients.setContent(patMan);
		Appointments.setContent(appoint);
		Welcome welcome = new Welcome();
		Welcome.setContent(welcome);
		this.getTabs().add(Welcome);
		this.getTabs().add(Procedures);
		this.getTabs().add(Patients);
		this.getTabs().add(Appointments);
		
		// bind to take available space
		border.prefHeightProperty().bind(this.heightProperty());
		border.prefWidthProperty().bind(this.widthProperty());

		//border.setTop(this);
	}
}

