package Appointments;

import javafx.scene.control.Button;
import javafx.scene.text.Text;
import list.ObjectList;
import panes.MyGridPane;
import person.Patient;

public class AppointmentDisplay extends MyGridPane {

	Slot slot;
	ObjectList store;
	Patient patient;
	int i;
	int time;
	boolean booked;

	

	
	public AppointmentDisplay(Slot slot, Patient patient, int i) {
		this.i = i;
		this.slot = slot;
		this.time = slot.getTime();
		this.booked = slot.isBooked();
		this.patient = patient;
		buildAppointmentSimpleFrame();
	}


	@SuppressWarnings("static-access")
	public void buildAppointmentSimpleFrame() {
		
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
		slot.setId(patient.getPatientID());
		
	}

}
