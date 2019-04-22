package person;

import java.time.LocalDate;

import controller.Controller;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import list.PatientList;

public class EnterPatient {
	Controller instance;
	PatientList patientList;
	LocalDate localDob;
	Patient patient;
	
	public EnterPatient() {
		instance = Controller.getInstance();
		patientList = instance.getPatientList();
	}
	//Enter new Patient
	public Object enterPatient(TextField fNameInput, TextField sNameInput, TextField addressL1, TextField addressL2,
			TextField addressL3, TextField city, TextField county, TextField phone, DatePicker dob) {
		patient =new Patient();
		data(fNameInput, sNameInput, addressL1, addressL2,	addressL3, city, county, phone, dob);		
		patientList.add(patient);
		instance.updatePatientList(patientList);
		return null;
	}
	//Update of amend an existing patient
	public Object amend(TextField fNameInput, TextField sNameInput, TextField addressL1, TextField addressL2,
			TextField addressL3, TextField city, TextField county, TextField phone, DatePicker dob, int i) {
		patient = (Patient) patientList.get(i);
		data(fNameInput, sNameInput, addressL1, addressL2,addressL3, city, county, phone,dob);
		instance.updatePatientList(patientList);
		return null;
		
	}
	//enter patient to the patient list, both new and amended
	public void data(TextField fNameInput, TextField sNameInput, TextField addressL1, TextField addressL2,
			TextField addressL3, TextField city, TextField county, TextField phone, DatePicker dob) {
		patient.setFname(fNameInput.getText());
		patient.setSname(sNameInput.getText());
		patient.setAddLine1(addressL1.getText());
		patient.setAddLine2(addressL2.getText());
		patient.setAddLine3(addressL3.getText());
		patient.setCity(city.getText());
		patient.setCounty(county.getText());
		patient.setPhone(phone.getText());
		localDob=dob.getValue();
		patient.setDob(localDob);
		System.out.println(patient.toString());

	}
}
