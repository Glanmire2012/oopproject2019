package Appointments;

import controller.Controller;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import list.AppointmentList;
import list.ObjectList;
import list.OverallAppointmentList;
import list.PatientList;
import objects.Appointment;
import objects.Patient;
import screensanddisplay.MyGridPane;

public class AppointmentDisplay extends MyGridPane {
	Controller instance;
	AppointmentSlot slot;
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
		this.slot = (AppointmentSlot) day.get(slotIndex);

		this.time = slot.getTime();
		this.booked = slot.isBooked();
	}

	@SuppressWarnings("static-access")
	public void buildAppointmentSimpleFrame() { // displays appointments as time slots
		this.getChildren().clear();
		this.patientList = instance.getPatientList();
		this.patient = (Patient) patientList.get(patientIndex);
		this.appointmentList = instance.getAppointmentList();

		Text timeText = new Text("" + time + "");
		this.setConstraints(timeText, 0, 1);
		if (booked == false) {
			this.setStyle("-fx-background-color: GREEN;");// If a time slot is displayed green, it is bookable.
			Text timeLabel = new Text("  AVAILABLE   ");
			this.setConstraints(timeLabel, 0, 2);
			Button button = new Button("BOOK");

			button.setOnAction(e -> makeBooking());
			this.setConstraints(button, 0, 0);
			this.getChildren().addAll(button, timeLabel, timeText);

		} else if (booked == true) {
			this.setStyle("-fx-background-color: RED;");// if a time slot is displayed red it is already allocated.
			Text timeLabel = new Text("UNAVAILABLE");
			this.setConstraints(timeLabel, 0, 2);

			this.getChildren().addAll(timeLabel, timeText);
		}
		this.prefWidthProperty().bind(this.widthProperty());

	}

	public void makeBooking() {// once the BOOK button is pressed that time slot is allocated to the patient
		if (slot.isBooked() == false) {
			slot.setBooked(true);

			slot.setId(patient.getPatientID());// sets the relevant patient Id in the relevant slot
			Appointment newAppointment = new Appointment(slot);
			AppointmentList list = patient.getAppointments();// gets a copy of the patients appointment list.
			list.addAppointment(newAppointment);// adds the appointment to the list
			patient.setAppointments(list);// sends the list back to the patient object to replace and updates the
											// appointment list

			instance.update(patientList, appointmentList);
			this.getChildren().clear();
			buildAppointmentSimpleFrame();
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
