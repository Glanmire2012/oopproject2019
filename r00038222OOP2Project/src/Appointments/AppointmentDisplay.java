package Appointments;

import controller.Controller;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import list.Appointment;
import list.AppointmentList;
import list.ObjectList;
import list.OverallAppointmentList;
import list.PatientList;
import panes.MyGridPane;
import person.Patient;

public class AppointmentDisplay extends MyGridPane {
	Controller instance;
	Slot slot;
	AppointmentDay day;
	ObjectList store;
	PatientList patientList;
	OverallAppointmentList appointmentList;
	Patient patient;
	int slotIndex;
	int dayIndex;
	int patientIndex;
	int time;
	boolean booked;

	public AppointmentDisplay(int slotIndex, int dayIndex, int patientIndex) {
		this.instance = Controller.getInstance();
		this.appointmentList = instance.getAppointmentList();

		this.dayIndex = dayIndex;
		this.patientIndex = patientIndex;
		this.day = (AppointmentDay) appointmentList.get(dayIndex);
		this.slotIndex = slotIndex;
		this.slot = (Slot) day.get(slotIndex);
		System.out.println("day index = " + dayIndex);
		System.out.println("slot index = " + slotIndex);
		this.time = slot.getTime();
		this.booked = slot.isBooked();
	}

	@SuppressWarnings("static-access")
	public void buildAppointmentSimpleFrame() {

		this.patientList = instance.getPatientList();
		this.patient = (Patient) patientList.get(patientIndex);
		this.appointmentList = instance.getAppointmentList();

		Text timeText = new Text("" + time + "");
		this.setConstraints(timeText, 0, 1);
		if (booked == false) {
			this.setStyle("-fx-background-color: GREEN;");
			Button button = new Button("BOOK");

			// this.prefWidthProperty().bind(this.widthProperty());
			button.setOnAction(e -> makeBooking());
			this.setConstraints(button, 0, 0);
			this.getChildren().addAll(button, timeText);

		} else if (booked == true) {
			this.setStyle("-fx-background-color: RED;");
			Text timeLabel = new Text("BOOKED");
			this.setConstraints(timeLabel, 0, 0);
			// this.prefWidthProperty().bind(this.widthProperty());
			this.getChildren().addAll(timeLabel, timeText);
		}
		this.prefWidthProperty().bind(this.widthProperty());

	}

	public void makeBooking() {
		if (slot.isBooked() == false) {
			slot.setBooked(true);
			System.out.println("Booking made " + slot.isBooked());
			slot.setId(patient.getPatientID());// sets the relevant patient Id in the relevant slot
			Appointment newAppointment = new Appointment(slot);
			AppointmentList list = patient.getAppointments();// gets a copy of the patients appointment list.
			list.addAppointment(newAppointment);// adds the appointment to the list
			patient.setAppointments(list);// sends the list back to the patient object to replace and update the
											// appointment list
			// instance.updatePatientList(patientList);// updates the controller
			instance.update(patientList, appointmentList);
		}
	}

	@SuppressWarnings("static-access")
	public void displayAppointment() {
		MyGridPane dipApp = new MyGridPane();
		Text PIDLabel = new Text("PID : ");
		dipApp.setConstraints(PIDLabel, 0, 0);
		Text PIDText = new Text("" + patient.getPatientID() + "");
		dipApp.setConstraints(PIDLabel, 1, 0);
		Text fNameLabel = new Text("Firstname : ");
		dipApp.setConstraints(fNameLabel, 0, 1);
		Text fNameText = new Text("" + patient.getFname() + "");
		dipApp.setConstraints(fNameText, 1, 1);
		Text sNameLabel = new Text("Surname : ");
		dipApp.setConstraints(sNameLabel, 0, 1);
		Text sNameText = new Text("" + patient.getSname() + "");
		dipApp.setConstraints(sNameText, 1, 1);
		dipApp.getChildren().addAll(PIDLabel, PIDText, fNameLabel, fNameText, sNameLabel, sNameText);

	}
}
