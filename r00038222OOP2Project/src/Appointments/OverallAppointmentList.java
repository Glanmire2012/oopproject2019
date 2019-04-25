package Appointments;

import list.ObjectList;

public class OverallAppointmentList extends ObjectList{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public AppointmentDay day;
	public int a;
	
	public OverallAppointmentList addAppointment(AppointmentDay day) {
		this.day = day;
		this.add(day);	
		return null;
	}	
	public OverallAppointmentList removeAppointment(int a) {
		this.a = a;
		this.remove(a);
		return null;
	} 
}
