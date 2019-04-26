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
		this.slotIndex = slotIndex;
		this.dayIndex = dayIndex;
		this.patientIndex = patientIndex;
		this.day = (AppointmentDay) appointmentList.get(dayIndex);
		this.slot = (Slot) day.get(slotIndex);
		this.time = slot.getTime();
		this.booked = slot.isBooked();
		//this.patientList = instance.getPatientList();
		//this.patient = (Patient) patientList.get(i);
		//this.appointmentList = instance.getAppointmentList();
		
	}


	@SuppressWarnings("static-access")
	public void buildAppointmentSimpleFrame() {
		
		this.patientList = instance.getPatientList();
		this.patient = (Patient) patientList.get(patientIndex);
		this.appointmentList = instance.getAppointmentList();
		//Text timeLabel = new Text("AVAILABLE");
		//this.setConstraints(timeLabel, 0, 0);
		Text timeText = new Text("" + time + "");
		this.setConstraints(timeText, 0, 1);
		if (booked == false) {
			this.setStyle("-fx-background-color: GREEN;");
			Button button = new Button("BOOK");

			//this.prefWidthProperty().bind(this.widthProperty());
			button.setOnAction(e -> makeBooking());
			this.setConstraints(button, 0, 0);
			this.getChildren().addAll(button, timeText);
			
		}else if(booked == true){
			this.setStyle("-fx-background-color: RED;");
			Text timeLabel = new Text("BOOKED");
			this.setConstraints(timeLabel, 0, 0);
			//this.prefWidthProperty().bind(this.widthProperty());
			this.getChildren().addAll(timeLabel, timeText);
		}
		this.prefWidthProperty().bind(this.widthProperty());

	}
	
	public void makeBooking() {
		slot.setBooked(true);
		slot.setId(patient.getPatientID());//sets the relevant patient Id in the relevant slot
		Appointment newAppointment = new Appointment(slot);
		AppointmentList list = patient.getAppointments();// gets a copy of the patients appointment list.
		list.addAppointment(newAppointment);// adds the appointment to the list
		patient.setAppointments(list);// sends the list back to the patient object to replace and update the appointment list
		instance.updatePatientList(patientList);
	}

}
