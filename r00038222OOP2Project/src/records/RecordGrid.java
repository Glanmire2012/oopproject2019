package records;

import java.time.LocalDate;

import Appointments.NewAppointments;
import controller.Controller;
import dataentry.EnterPatient;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import list.AppointmentList;
import list.PatientList;
import objects.Appointment;
import objects.Patient;
import screensanddisplay.MyGridPane;

public class RecordGrid extends MyGridPane {
	LocalDate dob;
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
	Patient patient;
	Controller instance;
	MyGridPane appointmentFrame;
	MyGridPane innerTL;
	MyGridPane innerTR;
	MyGridPane outer;
	PatientList patientList;
	AppointmentList appointments;
	Appointment appointment;
	EnterPatient data;
	NewAppointments makeNewAppointment;
	int i;
	public RecordGrid(Patient patient, int i) {
		this.dob = patient.getDob();
		this.i = i;
		this.patient = patient;
		this.data = new EnterPatient();
		this.instance = Controller.getInstance();
		this.patientList = instance.getPatientList();
		this.makeNewAppointment = new NewAppointments(patient, i);
		
		recordTopLeft();
		recordTopRight();
		outerGrid();
		
		ColumnConstraints column1 = new ColumnConstraints();
	    column1.setPercentWidth(48);
	    this.getColumnConstraints().add(column1);
	    ColumnConstraints column2 = new ColumnConstraints();
	    column2.setPercentWidth(48);
	    this.getColumnConstraints().add(column2);
	}

	@SuppressWarnings("static-access")
	public void recordTopLeft() {
		innerTL = new MyGridPane();
		
		Text IDLabel = new Text("PID :");
		innerTL.setConstraints(IDLabel, 0, 0);
		Text IDText = new Text("" + patient.getPatientID() + "");
		innerTL.setConstraints(IDText, 1, 0);

		Text fNameLabel = new Text("First Name: ");
		innerTL.setConstraints(fNameLabel, 0, 1);
		fNameField = new TextField(patient.getFname());
		innerTL.setConstraints(fNameField, 1, 1);

		Text sNameLabel = new Text("Last Name: ");
		innerTL.setConstraints(sNameLabel, 0, 2);
		sNameField = new TextField(patient.getSname());
		innerTL.setConstraints(sNameField, 1, 2);

		Text Add1Label = new Text("Address: ");
		innerTL.setConstraints(Add1Label, 0, 3);
		Add1Field = new TextField(patient.getAddLine1());
		innerTL.setConstraints(Add1Field, 1, 3);

		Add2Field = new TextField(patient.getAddLine2());
		innerTL.setConstraints(Add2Field, 1, 4);

		Add3Field = new TextField(patient.getAddLine3());
		innerTL.setConstraints(Add3Field, 1, 5);

		cityField = new TextField(patient.getCity());
		innerTL.setConstraints(cityField, 1, 6);

		countyField = new TextField(patient.getCounty());
		innerTL.setConstraints(countyField, 1, 7);

		Text phoneLabel = new Text("Phone: ");
		innerTL.setConstraints(phoneLabel, 0, 8);
		phoneField = new TextField(patient.getPhone());
		innerTL.setConstraints(phoneField, 1, 8);

		DatePicker DateOfBirth = new DatePicker(dob);

		makeAppointment = new Button("Make Appointment");
		makeAppointment.setOnAction(e -> createNewAppointment());// user is sent to the appointment managment screen
		innerTL.setConstraints(makeAppointment, 1, 10);

		amend = new Button("Amend");
		amend.setOnAction(e -> data.amend(fNameField, sNameField, Add1Field, Add2Field, Add3Field, cityField,
				countyField, phoneField, DateOfBirth, i));
		GridPane.setConstraints(amend, 0, 10);

		delete = new Button("Delete Record");
		delete.setOnAction(e -> patientList.remove(i));
		innerTL.setConstraints(delete, 0, 11);

		innerTL.getChildren().addAll(fNameLabel, fNameField, sNameLabel, sNameField, Add1Label, Add1Field, Add2Field,
				Add3Field, cityField, countyField, phoneLabel, phoneField, IDLabel, IDText, amend, delete,
				makeAppointment);
	}

	@SuppressWarnings("static-access")
	public void recordTopRight() { // Displays The patients appointments on the records screen.
		innerTR = new MyGridPane();
		ColumnConstraints innerCol = new ColumnConstraints();
	    innerCol.setPercentWidth(100);
	    innerTR.getColumnConstraints().add(innerCol);
		Text heading = new Text("Appointments & Records");
		innerTR.setConstraints(heading, 0, 0);
		innerTR.getChildren().add(heading);
		this.appointments = patient.getAppointments();
		try {
			int size = appointments.getSize();
			for (int i = 0; i < size; i++) {
				appointment = (Appointment) appointments.get(i);
				RecordAppointmentDisplay frame = new RecordAppointmentDisplay(appointment,i,patient,this.i);
				frame.displayFrame();
				innerTR.setConstraints(frame, 0, i + 1);
				innerTR.getChildren().add(frame);
			}
		} catch (NullPointerException e) {
			Text notice = new Text("No Appointments Found.");
			innerTR.setConstraints(notice, 0, 1);
			innerTR.getChildren().add(notice);
		}

	}

	@SuppressWarnings("static-access")
	public void outerGrid() {

		this.setConstraints(innerTL, 0, 0);
		this.setConstraints(innerTR, 1, 0);
		this.getChildren().addAll(innerTL, innerTR);
	}

	public void createNewAppointment() {
		this.makeNewAppointment = new NewAppointments(patient, i);
		makeNewAppointment.getWindow().show();

	}
}