package controller;

import java.io.File;
import java.io.Serializable;

import javafx.stage.Stage;
import list.OverallAppointmentList;
import list.PatientList;
import list.ProcedureList;
import storage.FileStorage;

public class Controller implements Serializable {

	private static final long serialVersionUID = 1L;
	public static int count = 100000;
	private static Controller instance;

	private Stage myStage;

	public PatientList patientList = new PatientList();;
	public ProcedureList procedureList;
	public OverallAppointmentList appointmentList;
	public boolean state;
	private FileStorage loadSave = new FileStorage();
	private File storage = new File("Storage.ser");

	public Controller() {
		instance = this;
		this.appointmentList = new OverallAppointmentList();
		this.procedureList = new ProcedureList();

	}

	public static Controller getInstance() {
		if (instance == null) {
			instance = new Controller();
		}

		return instance;
	}

	public void setStage(Stage s) {
		this.myStage = s;
	}

	public Stage getStage() {
		return this.myStage;
	}

	public void fileSetup() { // if storage.ser does not exist it is created. try/catch used to prevent crash.
		this.state = storage.exists();
		try {

			instance = (Controller) loadSave.readObject("storage.ser");

			this.patientList = instance.getPatientList();

		} catch (Exception e) {
			patientList = new PatientList();
			new FileStorage().writeObject(instance, "storage.ser");
			// e.printStackTrace();
		}

	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public PatientList getPatientList() {
		return patientList;
	}

	public void setPatList(PatientList patList) {
		this.patientList = patList;
	}

	public void updatePatientList(PatientList patient) {// Updates the storage file with new patient list.
		this.patientList = patient;
		new FileStorage().writeObject(instance, "storage.ser");

	}

	public void update(ProcedureList procedureList) {// Updates the storage file with new procedure list.
		this.procedureList = procedureList;
		new FileStorage().writeObject(instance, "storage.ser");

	}

	public void update(PatientList patient, OverallAppointmentList appointments) {// Updates the storage file with new
																					// procedure list and patient list.
		this.patientList = patient;
		this.appointmentList = appointments;
		new FileStorage().writeObject(instance, "storage.ser");

	}

	public void update() {// default update

		new FileStorage().writeObject(instance, "storage.ser");

	}

	public void reload() {
		instance = (Controller) new FileStorage().readObject("storage.ser");
	}

	public void setPatientList(PatientList patientList) {
		this.patientList = patientList;
	}
	// lists for patients,appointments, etc.

	public ProcedureList getProcedureList() {
		return procedureList;
	}

	public void setProcedureList(ProcedureList procedureList) {
		this.procedureList = procedureList;
	}

	public OverallAppointmentList getAppointmentList() {
		return appointmentList;
	}

	public void setAppointmentList(OverallAppointmentList appointmentList) {
		this.appointmentList = appointmentList;
	}
}
