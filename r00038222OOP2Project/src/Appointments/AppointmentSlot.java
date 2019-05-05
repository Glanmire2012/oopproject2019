package Appointments;

import java.io.Serializable;
import java.time.LocalDate;

//These are the time slots for appointments, there are 18 in every day
public class AppointmentSlot implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public LocalDate day;
	public int myIndex;// this stores the index of the slot

	public int getMyIndex() {
		return myIndex;
	}

	public void setMyIndex(int myIndex) {
		this.myIndex = myIndex;
	}

	public int year;
	public int doy;
	private int time;
	private int id;
	private long appointmentID;
	private boolean booked;

	public AppointmentSlot(LocalDate day, int time, int id) {// each slot is a half hour time slot into which
																// appointments are booked.
		this.day = day;
		this.time = time;
		this.year = day.getYear();
		this.doy = day.getDayOfYear();
		this.setId(id);
		this.setAppointmentID();

	}

	public LocalDate getDay() {
		return day;
	}

	public void setDay(LocalDate day) {
		this.day = day;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public void setId(long l) {
		this.id = (int) l;
	}

	public long getAppointmentID() {
		return appointmentID;
	}

	public void setAppointmentID() {
		String genID = "" + (year - 2000) + doy + time + "";
		this.appointmentID = Integer.parseInt(genID);
	}

	public boolean isBooked() {
		return booked;
	}

	public void setBooked(boolean booked) {
		this.booked = booked;
	}
}
