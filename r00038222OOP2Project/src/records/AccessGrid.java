package records;

import controller.Controller;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import list.ItemView;
import list.ProcedureList;
import objects.Appointment;
import objects.Patient;
import objects.Procedure;
import screensanddisplay.MyGridPane;

public class AccessGrid extends MyGridPane {
	Controller instance;
	ProcedureList procedures;
	Appointment appointment;
	Patient patient;
	FlowPane flow;
	int appointmentIndex;
	int PatientIndex;
	public AccessGrid(Appointment appointment, int appointmentIndex, Patient patient, int PatientIndex) {
		super();
		this.appointment = appointment;
		this.patient = patient;
		this.appointmentIndex = appointmentIndex;
		this.PatientIndex = PatientIndex;
		this.instance = Controller.getInstance();
		this.procedures = instance.getProcedureList();
		this.flow = new FlowPane();
		displayInformation();
		
	}

	@SuppressWarnings("static-access")
	public void displayInformation() {
		Text nameLabel = new Text("Name: "+patient.getFname()+" "+patient.getSname());this.setConstraints(nameLabel, 0,0);
		Text PIDLabel = new Text("PID : "+patient.getPatientID()+"");this.setConstraints(PIDLabel, 0,1);
		Text addressLabel = new Text("Address : "+patient.getAddLine1()+","+patient.getAddLine2()+","+patient.getAddLine3()+","+patient.getCity()+","+patient.getCounty()+"");this.setConstraints(addressLabel, 0,2);
		Text phoneLabel = new Text("Phone : "+patient.getPhone());this.setConstraints(phoneLabel, 0,3);
		Text dateof = new Text("Date of Appointment : "+appointment.getDate()+" Time :"+appointment.getTime());this.setConstraints(dateof, 0, 4);
		Text notesLabel = new Text("Notes : ");this.setConstraints(notesLabel, 0,5);
		TextArea notes = new TextArea(appointment.getAppointmentNotes());this.setConstraints(notes, 0,5,4,2);
		notes.setPrefWidth(450);notes.setPrefHeight(100);
		constructProcedureSelect();
		this.setConstraints(flow,0,10);
		this.getChildren().addAll(nameLabel,PIDLabel,addressLabel,phoneLabel,notesLabel,notes,flow, dateof);
	}
	public void constructProcedureSelect() {
		try {
			int listSize = procedures.getSize();
			for ( int i = 0; i < listSize; i++) {
				Procedure procedure = (Procedure) procedures.get(i);
				ItemView view = new ItemView(procedure, patient, appointment);
				flow.getChildren().add(view);
			}
		}
		catch (NullPointerException n) {
			System.out.println("constructProcedureSelect");
		}
	}

}
