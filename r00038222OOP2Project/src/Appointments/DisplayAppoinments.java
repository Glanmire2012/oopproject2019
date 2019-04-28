package Appointments;

import java.time.LocalDate;

import controller.Controller;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.ColumnConstraints;
import list.ItemView;
import list.OverallAppointmentList;
import list.PatientList;
import objects.Appointment;
import objects.Patient;
import screensanddisplay.MyGridPane;

public class DisplayAppoinments extends ScrollPane{
	Controller instance;
	OverallAppointmentList appointmentList;
	PatientList patientList;
	AppointmentDay day;
	Appointment appointment;
	AppointmentSlot slot;
	MyGridPane grid;
	ItemView appointmentView;
	int listSize;
	Patient patient;
	LocalDate today;
	
	public DisplayAppoinments() {
		this.instance = Controller.getInstance();
		this.appointmentList = instance.getAppointmentList();
		this.today = LocalDate.now();
		
		display();
	}
	@SuppressWarnings("static-access")
	public void display() {

		grid = new MyGridPane();
		ColumnConstraints column = new ColumnConstraints();
		column.setPercentWidth(100);
		grid.getColumnConstraints().add(column);
		grid.minWidthProperty().bind(this.maxWidthProperty());
		try {//checks through appointmentLists for appointments for today
			listSize = appointmentList.getSize();
			for ( int i = 0; i < listSize; i++) {
				day = (AppointmentDay) appointmentList.get(i);
				slot = (AppointmentSlot) day.get(i);
				if (slot.getDay().equals(today)){
					int daySize = day.getSize();
					for ( int a = 0; a < daySize; a++) {
						slot = (AppointmentSlot) day.get(a);
						appointmentView = new ItemView(slot);// Sends the relevant day to item view to construct viewable frames to display.
						appointmentView.appointmentGrid();grid.setConstraints(appointmentView,0,a);
						grid.getChildren().add(appointmentView);
					}
					break;
				}
			}
			//grid.minWidthProperty().bind(this.prefWidthProperty());
			this.setContent(grid);
		}
		catch (NullPointerException n) {
			
		}
	}
}
