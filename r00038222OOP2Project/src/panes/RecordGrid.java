package panes;

import java.time.LocalDate;

import Appointments.AppointmentTab;
import Appointments.NewAppointments;
import controller.Controller;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import list.PatientList;
import person.EnterPatient;
import person.Patient;

public class RecordGrid extends MyGridPane {
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
	
	TextField fNameField;
	TextField sNameField; 
	TextField Add1Field;
	TextField Add2Field;
	TextField Add3Field;
	TextField cityField; 
	TextField countyField;
	TextField phoneField;
	
	Button amend;
	Button delete;
	Button makeAppointment;
	int i;
	Patient patient;
	Controller instance;
	MyGridPane innerTL;
	MyGridPane innerTR;
	MyGridPane outer ;
	PatientList patientList;
	EnterPatient data;
	NewAppointments makeNewAppointment;
	public RecordGrid(Patient patient, int i) {
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
		this.data = new EnterPatient();
		this.instance = Controller.getInstance();
		this.patientList = instance.getPatientList();
		this.makeNewAppointment = new NewAppointments(patient, i);
		recordTopLeft();
		recordTopRight();
		outerGrid();
	}
	
	@SuppressWarnings("static-access")
	public void recordTopLeft() {
		innerTL = new MyGridPane();
				
		Text IDLabel = new Text("PID :");innerTL.setConstraints(IDLabel, 0,0);
		Text IDText = new Text(id);innerTL.setConstraints(IDText,1,0);
		
		Text fNameLabel = new Text("First Name: ");innerTL.setConstraints(fNameLabel, 0, 1);
		fNameField = new TextField(fName);innerTL.setConstraints(fNameField, 1, 1);
		
		Text sNameLabel = new Text("Last Name: ");innerTL.setConstraints(sNameLabel, 0, 2);
		sNameField = new TextField(sName);innerTL.setConstraints(sNameField, 1, 2);
		
		Text Add1Label = new Text("Address: ");innerTL.setConstraints(Add1Label, 0,3);
		Add1Field = new TextField(Add1);innerTL.setConstraints(Add1Field, 1, 3);
		
		Add2Field = new TextField(Add2);innerTL.setConstraints(Add2Field, 1, 4);
		
		Add3Field = new TextField(Add3);innerTL.setConstraints(Add3Field, 1, 5);
		
		cityField = new TextField(city);innerTL.setConstraints(cityField, 1, 6);
		
		countyField = new TextField(county);innerTL.setConstraints(countyField, 1, 7);
		
		Text phoneLabel = new Text("Phone: ");innerTL.setConstraints(phoneLabel, 0, 8);
		phoneField = new TextField(phone);innerTL.setConstraints(phoneField, 1, 8);
		
		DatePicker DateOfBirth = new DatePicker(dob);
		
		makeAppointment = new Button("Make Appointment");makeAppointment.setOnAction(e -> createNewAppointment());innerTL.setConstraints(makeAppointment, 1, 10);
		
		
		amend = new Button("Amend");amend.setOnAction(e -> data.amend(fNameField,sNameField,Add1Field,Add2Field,Add3Field,cityField,countyField,phoneField,DateOfBirth,i ));GridPane.setConstraints(amend, 0, 10);
		
		delete = new Button("Delete Record");delete.setOnAction(e -> patientList.remove(i));innerTL.setConstraints(delete,0,11);
		
		
		innerTL.getChildren().addAll(fNameLabel, fNameField, sNameLabel, sNameField, Add1Label, Add1Field, Add2Field,Add3Field,cityField,countyField,phoneLabel,phoneField,IDLabel,IDText,amend, delete, makeAppointment);
	}

	public void recordTopRight() {
		innerTR = new MyGridPane();
		Text heading = new Text("Appointments & Records");innerTR.setConstraints(heading,0,0);
		innerTR.getChildren().addAll(heading);
	}
	@SuppressWarnings("static-access")
	public void outerGrid() {
		
		this.setConstraints(innerTL, 0, 0);
		this.setConstraints(innerTR, 1, 0);
		this.getChildren().addAll(innerTL,innerTR);
	}
	public void createNewAppointment() {
		this.makeNewAppointment = new NewAppointments(patient, i);
		makeNewAppointment.getWindow().show();

	}
}