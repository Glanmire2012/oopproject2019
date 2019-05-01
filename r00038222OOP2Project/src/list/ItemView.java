package list;

import java.io.Serializable;

import Appointments.AppointmentSlot;
import controller.Controller;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.text.Text;
import objects.Appointment;
import objects.Patient;
import objects.Procedure;
import procedures.UpdateProcedures;
import screensanddisplay.MyGridPane;

public class ItemView extends MyGridPane implements Serializable {

	private static final long serialVersionUID = 1L;
	Controller instance;
	PatientList patientList;
	Patient patient;
	Procedure procedure;
	AppointmentSlot slot;
	Appointment appointment;
	OverallAppointmentList ovapplist;
	int index;// index of the procedure in the procedure list.

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public ItemView(Procedure procedure) {
		this.procedure = procedure;
		procedureGrid();
	}

	public ItemView(AppointmentSlot slot) {
		this.instance = Controller.getInstance();
		this.patientList = instance.getPatientList();
		this.slot = slot;

	}

	public ItemView(Procedure procedure, Patient patient, Appointment appointment) {
		this.procedure = procedure;
		this.instance = Controller.getInstance();
		this.patient = patient;
		this.appointment = appointment;
		this.patientList = instance.getPatientList();
		this.ovapplist = instance.getAppointmentList();
		selectProcedureFrames();
	}

	@SuppressWarnings("static-access")
	public void procedureGrid() {// Show procedure information
		Text procedureLabel = new Text("Treatment : ");
		this.setConstraints(procedureLabel, 0, 0);
		Text procedureText = new Text(procedure.getProcedureName());
		this.setConstraints(procedureText, 1, 0);
		Text descriptionLabel = new Text("Description : ");
		this.setConstraints(descriptionLabel, 0, 1);
		Text descriptionText = new Text(procedure.getProcedureDescription());
		this.setConstraints(descriptionText, 1, 1);
		Text priceLabel = new Text("Price : ");
		this.setConstraints(priceLabel, 0, 2);
		Text priceText = new Text("" + procedure.getPrice() + "");
		this.setConstraints(priceText, 1, 2);
		Button edit = new Button("Edit");
		this.setConstraints(edit, 0, 3);
		UpdateProcedures update = new UpdateProcedures(index);
		edit.setOnAction(e -> update.edit());
		this.minWidthProperty().bind(this.widthProperty());
		this.getChildren().addAll(procedureLabel, procedureText, descriptionLabel, descriptionText, priceLabel,
				priceText, edit);
	}

	@SuppressWarnings("static-access")
	public void appointmentGrid() {
		long patID = slot.getId();
		int listSize = patientList.getSize();
		for (int i = 0; i < listSize; i++) {
			patient = (Patient) patientList.get(i);
			if (patient.getPatientID() == patID) {
				this.patient = patient;
				break;
			}
		}

		Text timeLabel = new Text("Time : ");
		this.setConstraints(timeLabel, 0, 0);
		Text timeText = new Text("" + slot.getTime() + "");
		this.setConstraints(timeText, 1, 0);
		Text dateLabel = new Text("Date : ");
		this.setConstraints(dateLabel, 2, 0);
		Text dateText = new Text("" + slot.getDay() + "");
		this.setConstraints(dateText, 3, 0);
		if (slot.getId() != -1) {
			Text PIDLabel = new Text("PID : ");
			this.setConstraints(PIDLabel, 0, 1);
			Text PIDText = new Text("" + slot.getId() + "");
			this.setConstraints(PIDText, 1, 1);
			Text nameLabel = new Text("Name : ");
			this.setConstraints(nameLabel, 2, 1);
			Text nameText = new Text("" + patient.getFname() + " " + patient.getSname() + "");
			this.setConstraints(nameText, 3, 1);
			Button access = new Button("Access Appointment");
			this.setConstraints(access, 0, 2, 3, 1);
			this.getChildren().addAll(PIDLabel, PIDText, nameLabel, nameText, access);
		} else {
			Text noBookingText = new Text("NO BOOKING");
			this.setConstraints(noBookingText, 0, 1);
			this.getChildren().add(noBookingText);
		}
		this.prefWidthProperty().bind(this.widthProperty());
		this.getChildren().addAll(timeLabel, timeText, dateLabel, dateText);

	}

	public void selectProcedureFrames() {
		boolean checked = false;
		CheckBox check = new CheckBox(procedure.getProcedureName());
		if (removeOrCheckProcedure(procedure, 2)==true) {
			check.isArmed();
		}
		
		this.setConstraints(check, 0, 0);
		
		check.setOnAction(e_ -> {
			if (check.isSelected()) {
				addProcedure(procedure);
			} else if (!check.isSelected()) {
				System.out.println(procedure.getProcedureName());
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
		}

		appointment.setProcedures(procedures);
		instance.updatePatientList(patientList);
		// System.out.println(procedures.getSize());

	}

	public boolean removeOrCheckProcedure(Procedure procedure, int function) {

		ProceduresDone procedures = appointment.getProcedures();
		int size = procedures.getSize();
		int i;
		for (i = 0; i < size; i++) {
			Procedure p = (Procedure) procedures.get(i);
			if (p.getProcedureName().contentEquals(procedure.getProcedureName())) {
				switch (function) {
				case 1:
					procedures.removeProcedure(i);
					appointment.setProcedures(procedures);
					instance.update(patientList,ovapplist);
					
					break;
				case 2:
					return true;

				default:
					break;
				}
			}
			return false;
		}

		System.out.println(procedures.getSize());
		return false;

	}

}
