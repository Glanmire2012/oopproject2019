package Appointments;

import controller.Controller;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;
import list.PatientList;
import list.ProceduresDone;
import objects.Appointment;
import objects.Patient;
import objects.Procedure;

public class CheckBoxForProcedures extends GridPane {

	Controller instance;
	PatientList patientList;
	Patient patient;
	Procedure procedure;
	AppointmentSlot slot;
	Appointment appointment;
	ProceduresDone procedureList;

	public CheckBoxForProcedures(Procedure procedure, Patient patient, int appointmentIndex) {
		this.procedure = procedure;
		this.instance = Controller.getInstance();
		this.patient = patient;
		this.appointment = (Appointment) patient.getAppointments().get(appointmentIndex);
		this.patientList = instance.getPatientList();
		this.procedureList = appointment.getProcedures();
		selectProcedureFrames();
	}

	public void selectProcedureFrames() {

		CheckBox check = new CheckBox(procedure.getProcedureName());

		check.setOnAction(e_ -> {
			boolean alreadyListed = false;
			if (check.isSelected()) { // this will only add the procedure if its not already on the list.
				int size = procedureList.getSize();
				for (int i = 0; i < size; i++) {
					Procedure pro = (Procedure) procedureList.get(i);
					if (pro.getProcedureName().equals(procedure.getProcedureName())) {
						alreadyListed = true;
					}
				}
				if (alreadyListed == false) {
					addProcedure(procedure);
				}
			}
		});
		this.getChildren().add(check);
	}

	public void addProcedure(Procedure procedure) {
		ProceduresDone procedures = null;
		try {
			procedures = appointment.getProcedures();
			procedures.add(procedure);

		} catch (NullPointerException n) {
			procedures = new ProceduresDone();
			procedures.add(procedure);
			// n.printStackTrace();
		}

		instance.updatePatientList(patientList);

	}

}
