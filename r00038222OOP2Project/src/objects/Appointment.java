package objects;

import java.io.Serializable;
import java.time.LocalDate;

// this class is to store appointments within a patient object
import Appointments.AppointmentSlot;
import list.ProceduresDone;

public class Appointment implements Serializable {

	private static final long serialVersionUID = 1L;
	private String appointmentNotes;
	private int appointmentID;
	public AppointmentSlot slot;
	public ProceduresDone procedures;
	private LocalDate date;
	public double totalPrice;
	public double outstanding;
	public boolean paid;

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public double getOutstanding() {
		if (paid == true) {
			setOutstanding(0.0);
		}
		return outstanding;
	}

	public void setOutstanding(double newCost) {
		this.outstanding = totalPrice;
	}

	public void payOutstanding() {
		this.outstanding = 0.0;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double newTotal) {
		this.totalPrice = newTotal;
	}

	public Appointment(AppointmentSlot slot) {
		this.slot = slot;
		this.procedures = new ProceduresDone();
		setDate(slot.getDay());
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

	public AppointmentSlot getSlot() {
		return slot;
	}

	public void setSlot(AppointmentSlot slot) {
		this.slot = slot;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getTime() {
		// TODO Auto-generated method stub
		return null;
	}

}
