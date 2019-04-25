package controller;

import java.io.File;
import java.io.Serializable;
import Appointments.OverallAppointmentList;
import javafx.stage.Stage;
import list.DentistList;
import list.PatientList;
import list.ProcedureList;
import storage.FileStorage;

public class Controller implements Serializable {

	private static final long serialVersionUID = 1L;
	public static int count = 100000;
	private static Controller instance;

	private Stage myStage;


	public PatientList patientList = new PatientList();
	public DentistList dentistList = new DentistList();
	public ProcedureList procedureList = new ProcedureList();
	public OverallAppointmentList appointmentList = new OverallAppointmentList();
	
	private FileStorage loadSave = new FileStorage();
	private File storage = new File("Storage.ser");

	public Controller() {
		instance = this;
	
	}
	public static Controller getInstance() {
		if (instance == null) {
			instance = new Controller();
		}
		//reload();
		return instance;
	}

	public void setStage(Stage s) {
		this.myStage = s;
	}

	public Stage getStage() {
		return this.myStage;
	}

	public void fileSetup() {
		boolean state = storage.exists();

		System.out.println(state);
		try {

			instance = (Controller) loadSave.readObject("storage.ser");

			this.patientList = instance.getPatientList();

		} catch (Exception e) {
			System.out.println("Error");
			patientList = new PatientList();
			System.out.println("list created");
			new FileStorage().writeObject(instance, "storage.ser");

		}

	}



	

	public PatientList getPatientList() {
		return patientList;
	}

	public void setPatList(PatientList patList) {
		this.patientList = patList;
	}

	public void updatePatientList(PatientList patient) {
		this.patientList = patient;
		new FileStorage().writeObject(instance, "storage.ser");
		System.out.println("List updated");

	}
	public void updateList() {
		
		new FileStorage().writeObject(instance, "storage.ser");
		System.out.println("List updated");

	}

	public void reload() {
		instance = (Controller) new FileStorage().readObject("storage.ser");
	}

	public void setPatientList(PatientList patientList) {
		this.patientList = patientList;
	}
	//lists for patients,dentists,appointments, etc.
	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		instance.count = count;
	}
	public DentistList getDentistList() {
		return dentistList;
	}
	public void setDentistList(DentistList dentistList) {
		this.dentistList = dentistList;
	}
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
