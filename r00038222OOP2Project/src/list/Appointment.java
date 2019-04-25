package list;

import Appointments.Slot;

public class Appointment {
	private String appointmentNotes;
	private int appointmentID;
	private Slot slot;
	private ProceduresDone procedures;
	public Appointment(Slot slot) {
		
	}
	public ProceduresDone getProcedures() {
		return procedures;
	}
	public void setProcedures(ProceduresDone procedures) {
		this.procedures = procedures;
	}
	public int getAppointmentID() {
		return appointmentID;
	}
	public void setAppointmentID(int appointmentID) {
		this.appointmentID = appointmentID;
	}
	public String getAppointmentNotes() {
		return appointmentNotes;
	}
	public void setAppointmentNotes(String appointmentNotes) {
		this.appointmentNotes = appointmentNotes;
	}
	public Slot getSlot() {
		return slot;
	}
	public void setSlot(Slot slot) {
		this.slot = slot;
	}
	

}
