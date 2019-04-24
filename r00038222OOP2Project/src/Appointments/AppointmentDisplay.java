package Appointments;

import javafx.scene.text.Text;
import list.ObjectList;
import panes.MyGridPane;

public class AppointmentDisplay extends MyGridPane {
	
	Slot slot;
	ObjectList store;
	int i;
	int time;

	public AppointmentDisplay(Slot slot, int i) {
		
		this.i = i;
		this.slot = slot;
		this.time = slot.getTime();
		buildAppointmentSimpleFrame();
	}

	@SuppressWarnings("static-access")
	public void buildAppointmentSimpleFrame() {
		Text timeLabel = new Text("AVAILABLE");this.setConstraints(timeLabel,0,0);
		Text timeText = new Text("" + time + "");this.setConstraints(timeLabel,0,1);
		this.prefWidthProperty().bind(this.widthProperty());
		this.getChildren().addAll(timeLabel, timeText);
		}
		

	}

	

