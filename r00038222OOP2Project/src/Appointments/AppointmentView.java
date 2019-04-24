package Appointments;

import java.io.Serializable;

import javafx.scene.text.Text;
import panes.MyGridPane;

public class AppointmentView extends MyGridPane implements Serializable  {

	private static final long serialVersionUID = 1L;
	int time;
	public AppointmentView(int time) {
		this.time = time;
	}
	public void Grid() {
		Text timeLabel = new Text("AVAILABLE");this.setConstraints(timeLabel,0,0);
		Text timeText = new Text("" + time + "");this.setConstraints(timeLabel,0,1);
		this.prefWidthProperty().bind(this.widthProperty());
		this.getChildren().addAll(timeLabel, timeText);
	}
	

}
