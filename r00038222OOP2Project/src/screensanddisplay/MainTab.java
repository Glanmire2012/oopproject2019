package screensanddisplay;

import Appointments.AppoinmentManagement;
import Appointments.DisplayAppoinments;
import dataentry.Welcome;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import patient.PatientManagement;
import procedures.ProcedureManagement;

public class MainTab extends MyTabPane {
	public MainTab() {	
		BorderPane border = new BorderPane();
		Tab Patients = new Tab("Patient Management");
		Tab Welcome = new Tab("CIT Dental");
		Tab Procedures = new Tab("Procedures");
		Tab Appointments = new Tab("Appointments");
		PatientManagement patMan = new PatientManagement();
		ProcedureManagement proMan = new ProcedureManagement();
		AppoinmentManagement appoint = new AppoinmentManagement();

		Patients.setContent(patMan);
		Procedures.setContent(proMan);
		Appointments.setContent(appoint);
		Welcome welcome = new Welcome();
		Welcome.setContent(welcome);
		this.getTabs().add(Welcome);
		this.getTabs().add(Patients);
		this.getTabs().add(Appointments);
		this.getTabs().add(Procedures);
		// bind to take available space
		border.prefHeightProperty().bind(this.heightProperty());
		border.prefWidthProperty().bind(this.widthProperty());

		//border.setTop(this);
	}
}

