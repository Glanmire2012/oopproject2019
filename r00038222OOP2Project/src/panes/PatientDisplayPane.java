package panes;


import java.awt.Label;
import java.time.LocalDate;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import list.ObjectList;
import list.PatientList;
import person.Patient;
import search.Search;

public class PatientDisplayPane extends MyGridPane {
	String fName;
	String sName;
	String Add1;
	String Add2;
	String Add3;
	String city;
	String county;
	String phone;
	LocalDate dob;
	String id;
	Button enter;
	int i;
	Patient patient;
	Records record;
	public PatientDisplayPane (Patient patient, int i) {
		
		this.fName = patient.getFname();
		this.sName = patient.getSname();
		this.Add1 = patient.getAddLine1();
		this.Add2 = patient.getAddLine2();
		this.Add3 = patient.getAddLine3();
		this.county = patient.getCounty();
		this.city = patient.getCity();
		this.phone = patient.getPhone();
		this.dob = patient.getDob();
		this.id = (""+ patient.getPatientID()+"");
		this.i = i;
		this.patient = patient;
		buildResultFrame();
		
	}
	public void buildResultFrame() {
		
		Text IDLabel = new Text("PID :");GridPane.setConstraints(IDLabel, 0,0);
		Text IDText = new Text(id);GridPane.setConstraints(IDText,1,0);
		Text fNameLabel = new Text("First Name: ");GridPane.setConstraints(fNameLabel, 0, 1);
		Text fNameText = new Text(fName);GridPane.setConstraints(fNameText, 1, 1);
		
		Text sNameLabel = new Text("Last Name: ");GridPane.setConstraints(sNameLabel, 2, 1);
		Text sNameText = new Text(sName);GridPane.setConstraints(sNameText, 3, 1);
		
		Text Add1Label = new Text("Address: ");GridPane.setConstraints(Add1Label, 0,2);
		Text Add1Text = new Text(Add1);GridPane.setConstraints(Add1Text, 1, 2);
		Text Add2Text = new Text(Add2);GridPane.setConstraints(Add2Text, 2, 2);
		Text Add3Text = new Text(Add3);GridPane.setConstraints(Add3Text, 3, 2);
		Text cityText = new Text(city);GridPane.setConstraints(cityText, 4, 2);
		Text countyText = new Text(county);GridPane.setConstraints(countyText, 5, 2);
		
		Text phoneLabel = new Text("Phone: ");GridPane.setConstraints(phoneLabel, 1, 3);
		Text phoneText = new Text(phone);GridPane.setConstraints(phoneText, 2, 3);
		
		enter = new Button("Open Record");GridPane.setConstraints(enter,0,3);
		enter.setOnAction(e -> openRecord());
		this.prefWidthProperty().bind(this.widthProperty());
		this.getChildren().addAll(fNameLabel, fNameText, sNameLabel, sNameText, Add1Label, Add1Text, Add2Text,Add3Text,cityText,countyText,phoneLabel,phoneText,IDLabel,IDText,enter);
	}
	public void openRecord() {
		record = new Records(patient,i);
		record.getWindow().show();
	}
	
	
}
