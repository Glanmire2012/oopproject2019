package Appointments;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import screensanddisplay.MyGridPane;

public class AppointmentTab extends MyGridPane{
	public AppointmentTab() {
		
	}
	public void display() {
		Label fNameLabel = new Label("First Name:");
		GridPane.setConstraints(fNameLabel, 0, 0);
		this.getChildren().addAll(fNameLabel);
	}
}
