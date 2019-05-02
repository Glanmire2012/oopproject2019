package Appointments;
import objects.Appointment;
import objects.Invoice;
import objects.Patient;
import stagesandScenes.Newstage;

public class InvoiceScreen extends Newstage{
	Appointment appointment;
	int appointmentIndex;
	Patient patient;
	int PatientIndex;
		
		public InvoiceScreen(Appointment appointment, int appointmentIndex, Patient patient, int PatientIndex) {
			this.appointment = appointment;
			this.appointmentIndex =appointmentIndex;
			this.patient = patient;
			this.PatientIndex = PatientIndex;
			this.setPatient(patient);
			
		
			getWindow().setScene(getScene());

	        Invoice invoiceGrid = new Invoice(appointment,appointmentIndex,patient, PatientIndex);
	        invoiceGrid.maxWidthProperty().bind(getLayout().widthProperty());
	        invoiceGrid.minWidthProperty().bind(getLayout().widthProperty());
	        getLayout().setContent(invoiceGrid);
		}
		

	}


