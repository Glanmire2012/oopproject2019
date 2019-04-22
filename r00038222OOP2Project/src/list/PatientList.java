package list;

import person.Patient;

public class PatientList extends ObjectList {
	private static final long serialVersionUID = 1L;
	public Patient patient;

	
	public PatientList addPatient1(Patient patient) {
		this.patient= patient;
		this.add(patient);
		return null;
	}

	
}
