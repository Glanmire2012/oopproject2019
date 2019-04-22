package Appointments;

import list.ObjectList;

public class AppointmentList extends ObjectList{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public AppointmentDay day;
	public int a;
	
	public AppointmentList addAppointment(AppointmentDay day) {
		this.day = day;
		this.add(day);	
		return null;
	}	
	public AppointmentList removeAppointment(int a) {
		this.a = a;
		this.remove(a);
		return null;
	} 
}
