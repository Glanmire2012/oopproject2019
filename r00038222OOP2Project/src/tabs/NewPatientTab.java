package tabs;

import java.time.LocalDate;

import controller.Controller;
import dataentry.EnterPatient;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import list.PatientList;
import screensanddisplay.MyGridPane;

public class NewPatientTab extends MyGridPane {
	TextField fNameInput;
	TextField sNameInput;
	TextField AddressL1;
	TextField AddressL2;
	TextField AddressL3;
	TextField City;
	TextField County;
	TextField Phone;
	Controller instance;
	DatePicker dob;
	LocalDate localDob;
	PatientList patientList = new PatientList();

	public NewPatientTab() {

		// First name label and entry
		Label fNameLabel = new Label("First Name:");
		GridPane.setConstraints(fNameLabel, 0, 0);
		fNameInput = new TextField();
		GridPane.setConstraints(fNameInput, 1, 0);

		// Second Name Label and entry
		Label sNameLabel = new Label("Surname:");
		GridPane.setConstraints(sNameLabel, 2, 0);
		sNameInput = new TextField();
		GridPane.setConstraints(sNameInput, 3, 0);

		Label addressL1 = new Label("House No/Name:");
		GridPane.setConstraints(addressL1, 0, 1);
		AddressL1 = new TextField();
		GridPane.setConstraints(AddressL1, 1, 1);

		Label phoneLabel = new Label("Phone:");
		GridPane.setConstraints(phoneLabel, 2, 1);
		Phone = new TextField();
		GridPane.setConstraints(Phone, 3, 1);

		Label addressL2 = new Label("Street:");
		GridPane.setConstraints(addressL2, 0, 2);
		AddressL2 = new TextField();
		GridPane.setConstraints(AddressL2, 1, 2, 3, 1);

		Label addressL3 = new Label("Street:");
		GridPane.setConstraints(addressL3, 0, 3);
		AddressL3 = new TextField();
		GridPane.setConstraints(AddressL3, 1, 3, 3, 1);

		Label city = new Label("City");
		GridPane.setConstraints(city, 0, 4);
		City = new TextField();
		GridPane.setConstraints(City, 1, 4);

		Label county = new Label("County");
		GridPane.setConstraints(county, 2, 4);
		County = new TextField();
		GridPane.setConstraints(County, 3, 4);

		Label dobLabel = new Label("Date of Birth:");
		GridPane.setConstraints(dobLabel, 0, 5);
		dob = new DatePicker();
		GridPane.setConstraints(dob, 1, 5);

		EnterPatient data = new EnterPatient();
		Button enter = new Button("Enter");
		enter.setOnAction(e -> data.enterPatient(fNameInput, sNameInput, AddressL1, AddressL2, AddressL3, City, County,
				Phone, dob));
		GridPane.setConstraints(enter, 0, 6);

		// Add everything to grid*/
		this.getChildren().addAll(fNameLabel, fNameInput, sNameLabel, sNameInput, addressL1, AddressL1, addressL2,
				AddressL2, phoneLabel, Phone, addressL3, AddressL3, city, City, county, County, dobLabel, dob, enter);

	}

}
