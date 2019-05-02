package objects;

import controller.Controller;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import list.AppointmentList;
import list.PatientList;
import list.ProcedureList;
import list.ProceduresDone;
import records.ShowAddedProcedures;

public class Invoice extends GridPane{
	PatientList patientList;
	AppointmentList appointmentList;
	Controller instance;
	ProcedureList procedures;
	Appointment appointment;

	
	Patient patient;

	ProceduresDone proceduresDone;
	int appointmentIndex;
	int PatientIndex;
	
	public Invoice(Appointment appointment, int appointmentIndex, Patient patient, int patientIndex) {
		super();
		this.instance = Controller.getInstance();
		
		this.patientList = instance.getPatientList();
		this.appointmentList = patient.getAppointments();
		
		this.appointmentIndex = appointmentIndex;
		this.PatientIndex = PatientIndex;
		
		this.patient = (Patient) patientList.get(PatientIndex);
		this.appointment = appointment;
		
		this.procedures = instance.getProcedureList();
		
		this.proceduresDone = appointment.getProcedures();
		layOut();

	}
	public void layOut() {
		Text nameLabel = new Text("Name: "+patient.getFname()+" "+patient.getSname());this.setConstraints(nameLabel, 0,0);
		Text PIDLabel = new Text("PID : "+patient.getPatientID()+"");this.setConstraints(PIDLabel, 0,2);
		Text addressLabel = new Text("Address : "+patient.getAddLine1()+","+patient.getAddLine2()+","+patient.getAddLine3()+","+patient.getCity()+","+patient.getCounty()+"");this.setConstraints(addressLabel, 0,4);
		Text phoneLabel = new Text("Phone : "+patient.getPhone());this.setConstraints(phoneLabel, 0,6);
		Text dateof = new Text("Date of Appointment : "+appointment.getDate()+" Time :"+appointment.getTime());this.setConstraints(dateof, 0, 8);
		Text notesLabel = new Text("Notes : ");this.setConstraints(notesLabel, 0,10);
		Text notes = new Text(appointment.getAppointmentNotes());this.setConstraints(notes, 0,10,4,2);
				
		Text proceduresPerformed = new Text("Procedures Performed : ");this.setConstraints(proceduresPerformed, 0, 12);
		ShowAddedProcedures doneGrid = new ShowAddedProcedures(proceduresDone,appointment);this.setConstraints(doneGrid, 0,13);
		Text totalPrice = new Text("Total Cost : €"+appointment.getTotalPrice()+"Outstanding : "+appointment.getOutstanding());this.setConstraints(totalPrice, 0,15);
		appointment.setTotalPrice(doneGrid.getTotalPrice());
		this.getChildren().addAll(nameLabel,PIDLabel,addressLabel,phoneLabel,notesLabel,notes, dateof,proceduresPerformed,doneGrid,totalPrice
				);
	}
	
	
	
	
	

}
