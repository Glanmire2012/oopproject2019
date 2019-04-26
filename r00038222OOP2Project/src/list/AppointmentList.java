package list;
//This class stores appointments for individual patients
public class AppointmentList extends ObjectList{

	private static final long serialVersionUID = 1L;

		public Appointment appointment;
		public int a;
		public AppointmentList addAppointment(Appointment appointment) {
			this.appointment = appointment;
			this.add(appointment);
			return null;
		}
		public AppointmentList removeAppointment(int a) {
			this.a = a;
			this.remove(a);
			return null;
		}
		
	}
