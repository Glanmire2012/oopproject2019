package records;

import javafx.scene.control.Button;
import javafx.scene.text.Text;
import objects.Appointment;
import objects.Patient;
import screensanddisplay.MyGridPane;

public class RecordAppointmentDisplay extends MyGridPane {

	Appointment appointment;
	Patient patient;
	AccessRecord accessRec;
	int appointmentIndex;
	int patientIndex;

	public RecordAppointmentDisplay(Appointment appointment, int appointmentIndex, Patient patient, int patientIndex) {
		this.appointment = appointment;
		this.patientIndex = patientIndex;
		this.patient = patient;
		this.appointmentIndex = appointmentIndex;

	}

	@SuppressWarnings("static-access")
	public void displayFrame() {
		accessRec = new AccessRecord(appointment, appointmentIndex, patient, patientIndex);
		Text appDateLabel = new Text("Date : ");
		this.setConstraints(appDateLabel, 0, 1);

		Text appDate = new Text("" + appointment.getDate() + "");
		this.setConstraints(appDate, 1, 1);
		Text timeLabel = new Text("Time : ");
		this.setConstraints(timeLabel, 0, 2);
		Text timeText = new Text("" + appointment.slot.getTime() + "");
		this.setConstraints(timeText, 1, 2);
		Button access = new Button("Access Appointment");
		this.setConstraints(access, 1, 3);
		access.setOnAction(e -> accessAppointment());
		this.getChildren().addAll(appDateLabel, appDate, access, timeLabel, timeText);
	}

	public void accessAppointment() {
		accessRec.getWindow().show();
	}
}
