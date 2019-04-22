package Appointments;

import java.time.LocalDate;

import javafx.scene.layout.FlowPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;

public class AppointmentDisplay extends FlowPane{
	AppointmentDay day;
	Slot slot;
	int i;
	int time;
	public AppointmentDisplay(AppointmentDay day, int i) {
		this.day = day;
		this.i = i;
		this.slot = (Slot) day.get(i);
		this.time = slot.getTime();
	}
	
	public void buildAppointmentSimpleFrame() {
		Text timeLabel = new Text("AVAILABLE");
		Text timeText = new Text(""+time+"");
			
		this.getChildren().addAll(timeLabel,timeText);
	}
	
	public void buildAppointmentFullFrame() {
		Text pidLabel = new Text("Patient ID :");
		Text pidText = new Text(""+slot.getId());
		
		Text dateLabel = new Text("Date :");
		Text dateText = new Text(""+slot.getDay());
		
		Text timeLabel = new Text("Time :");
		Text timeText = new Text(""+time+"");
		
		this.getChildren().addAll(pidLabel,pidText,dateLabel,dateText,timeLabel,timeText);
	}
}
