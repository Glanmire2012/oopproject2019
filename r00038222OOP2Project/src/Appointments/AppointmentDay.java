package Appointments;

import list.ObjectList;

public class AppointmentDay extends ObjectList {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Object slot;

	public AppointmentDay() {

	}

	public void addSlot(Object slot) {
		this.slot = slot;
		this.add(slot);
	}

}
