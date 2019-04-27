package records;

import javafx.scene.control.Button;
import javafx.scene.text.Text;
import objects.Appointment;
import screensanddisplay.MyGridPane;

public class RecordAppointmentDisplay extends MyGridPane{
	
	Appointment appointment;
	
	public RecordAppointmentDisplay(Appointment appointment ) {
		this.appointment = appointment;
	}
		
	public void displayFrame() {
		Text appDateLabel = new Text("Date : ");this.setConstraints(appDateLabel,0,1 );
		
		Text appDate = new Text(""+appointment.getDate()+"");this.setConstraints(appDate, 1, 1);
		Text timeLabel = new Text("Time : ");this.setConstraints(timeLabel, 0, 2);
		Text timeText = new Text(""+appointment.slot.getTime()+"");this.setConstraints(timeText, 1, 2);
		Button access = new Button("Access Appointment");this.setConstraints(access, 1, 3);
		this.getChildren().addAll(appDateLabel,appDate,access,timeLabel,timeText);
	}
}
