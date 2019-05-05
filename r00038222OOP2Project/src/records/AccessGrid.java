package records;

import Appointments.InvoiceScreen;
import Appointments.CheckBoxForProcedures;
import controller.Controller;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import list.AppointmentList;
import list.PatientList;
import list.ProcedureList;
import list.ProceduresDone;
import objects.Appointment;
import objects.Patient;
import objects.Procedure;
import screensanddisplay.MyGridPane;

public class AccessGrid extends MyGridPane {
	PatientList patientList;
	AppointmentList appointmentList;
	Controller instance;
	ProcedureList procedures;
	Appointment appointment;
	InvoiceScreen InScreen;

	Patient patient;
	FlowPane flow;
	ProceduresDone proceduresDone;
	int appointmentIndex;
	int PatientIndex;

	public AccessGrid(Appointment appointment, int appointmentIndex, Patient patient, int PatientIndex) {
		super();
		this.instance = Controller.getInstance();

		this.patientList = instance.getPatientList();
		this.appointmentList = patient.getAppointments();

		this.appointmentIndex = appointmentIndex;
		this.PatientIndex = PatientIndex;

		this.patient = (Patient) patientList.get(PatientIndex);
		this.appointment = appointment;

		this.procedures = instance.getProcedureList();

		this.flow = new FlowPane();
		this.proceduresDone = appointment.getProcedures();

		displayInformation();

	}

	@SuppressWarnings("static-access")
	public void displayInformation() {
		Text nameLabel = new Text("Name: " + patient.getFname() + " " + patient.getSname());
		this.setConstraints(nameLabel, 0, 0);
		Text PIDLabel = new Text("PID : " + patient.getPatientID() + "");
		this.setConstraints(PIDLabel, 0, 1);
		Text addressLabel = new Text("Address : " + patient.getAddLine1() + "," + patient.getAddLine2() + ","
				+ patient.getAddLine3() + "," + patient.getCity() + "," + patient.getCounty() + "");
		this.setConstraints(addressLabel, 0, 2);
		Text phoneLabel = new Text("Phone : " + patient.getPhone());
		this.setConstraints(phoneLabel, 0, 3);
		Text dateof = new Text("Date of Appointment : " + appointment.getDate() + " Time :" + appointment.getTime());
		this.setConstraints(dateof, 0, 4);
		Text notesLabel = new Text("Notes : ");
		this.setConstraints(notesLabel, 0, 5);
		TextArea notes = new TextArea(appointment.getAppointmentNotes());
		this.setConstraints(notes, 0, 5, 4, 2);
		notes.setPrefWidth(450);
		notes.setPrefHeight(100);
		Button save = new Button("Save");
		this.setConstraints(save, 1, 0);
		save.setOnAction(e -> {
			appointment.setAppointmentNotes(notes.getText());
			instance.updatePatientList(patientList);
		});
		Text proceduresPerformed = new Text("Procedures Performed : ");
		this.setConstraints(proceduresPerformed, 0, 7);
		ShowAddedProcedures doneGrid = new ShowAddedProcedures(proceduresDone, appointment);
		this.setConstraints(doneGrid, 0, 8);

		appointment.setTotalPrice(doneGrid.getTotalPrice());

		Text totalPrice = new Text("Total Cost : €" + appointment.getTotalPrice());
		this.setConstraints(totalPrice, 0, 9);
		Button genInvoice = new Button("Generate Invoice");
		this.setConstraints(genInvoice, 1, 9);
		genInvoice.setOnAction(e -> {
			openInvoice();
		});
		if (appointment.isPaid() == false) {
			Button pay = new Button("PAY");
			this.setConstraints(pay, 2, 9);
			pay.setOnAction(e -> {
				appointment.setPaid(true);
				instance.updatePatientList(patientList);
			});
			this.getChildren().add(pay);
		} else {
			Text paid = new Text("PAID");
			this.setConstraints(paid, 2, 9);
			this.getChildren().add(paid);
		}

		constructProcedureSelect();
		this.setConstraints(flow, 0, 10);
		this.getChildren().addAll(nameLabel, PIDLabel, addressLabel, phoneLabel, notesLabel, notes, flow, dateof,
				proceduresPerformed, doneGrid, save, totalPrice, genInvoice);

	}

	public void constructProcedureSelect() {
		try {
			int listSize = procedures.getSize();
			for (int i = 0; i < listSize; i++) {
				Procedure procedure = (Procedure) procedures.get(i);
				CheckBoxForProcedures view = new CheckBoxForProcedures(procedure, patient, appointmentIndex);
				flow.getChildren().add(view);
			}
		} catch (NullPointerException n) {
			// n.printStackTrace();
		}
	}

	public void openInvoice() {
		InScreen = new InvoiceScreen(appointment, appointmentIndex, patient, PatientIndex);
		InScreen.getWindow().show();
	}

}
