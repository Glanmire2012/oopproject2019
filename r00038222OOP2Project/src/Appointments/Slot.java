package Appointments;

import java.io.Serializable;
import java.time.LocalDate;

public class Slot implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public LocalDate day;
	private int time;
	private int id;
	
	public Slot(LocalDate day,int time, int id) {//each slot is a half hour time slot into which appointments are booked.
		this.day = day;
		this.time = time;
		this.setId(id);
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

	public void setId(int id) {
		this.id = id;
	}
}
