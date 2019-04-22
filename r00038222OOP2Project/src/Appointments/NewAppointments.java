package Appointments;

import controller.Controller;
import javafx.scene.text.Text;
import list.PatientList;
import panes.MyGridPane;
import panes.RecordGrid;
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
