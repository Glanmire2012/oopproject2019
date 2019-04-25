package Appointments;

import person.Patient;
import stages.Newstage;

public class NewAppointments extends Newstage{
	
		public NewAppointments(Patient patient, int i) {
			
			this.setPatient(patient);
			this.setI(i);

			getWindow().setScene(getScene());
	       
	        AppointmentGrid appointmentGrid = new AppointmentGrid(patient , i);
	       
	        getLayout().setContent(appointmentGrid);
		}
		
}
