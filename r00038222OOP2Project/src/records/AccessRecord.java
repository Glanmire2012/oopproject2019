package records;

import objects.Appointment;
import objects.Patient;
import stagesandScenes.Newstage;

public class AccessRecord extends Newstage {
	Appointment appointment;
	Patient patient;
	AccessRecord accessRec;
	int appointmentIndex;
	int patientIndex;

	public AccessRecord(Appointment appointment, int appoinmentIndex, Patient patient, int patientIndex) {
		this.appointment = appointment;
		this.patientIndex = patientIndex;
		this.patient = patient;
		this.appointmentIndex = appoinmentIndex;
		getWindow().setScene(getScene());

		AccessGrid accessGrid = new AccessGrid(appointment, appointmentIndex, patient, patientIndex);
		accessGrid.maxWidthProperty().bind(getLayout().widthProperty());
		accessGrid.minWidthProperty().bind(getLayout().widthProperty());
		getLayout().setContent(accessGrid);
	}

}
