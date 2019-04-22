package search;

import java.time.LocalDate;

import controller.Controller;
import list.PatientList;
import person.IDnumbers;
import person.Patient;

public class Search {
	Controller instance;
	PatientList patientList;
	PatientList searchList = new PatientList();
	Patient patient;
	String Fname;
	String Sname;
	LocalDate dob;
	int s;

	int ID;
	String phone;

	public Search() {
		this.instance = Controller.getInstance();
		this.patientList = instance.getPatientList();
	}

	@SuppressWarnings("unused")
	public PatientList startSearch(String fname, String sname, LocalDate dob2, int PID, String phone) {
		IDnumbers a = new IDnumbers();
		a.generateID();
		this.Fname = fname.toUpperCase();
		this.Sname = sname.toUpperCase();
		this.dob = dob2;
		this.ID = PID;
		this.phone = phone;
		System.out.println(Fname);
		// if the ID is not 0 only ID is checked as this should only return a single
		// result.
		boolean test = true;
		if (ID != 0) {
			searchLoop(patientList, null, ID, 1, 1, null);
			//otherwise we loop through each of the next variables.
		} else if (!(Fname.isEmpty())) {
			System.out.println("String here " + Fname);
			searchLoop(patientList, Fname, 0, 1, 2, null);
			// the next if statements remove any incorrect matches.
			
			 if(Sname.isEmpty()) {}else{ searchLoop(searchList, Sname, 0, 2, 3, null); } if(phone.isEmpty()) {}
			 else{ searchLoop(searchList, Sname, 0, 2, 4, null); } if (dob !=
			 null) { searchLoop(searchList, Sname, 0, 2, 5, null); }
			 
		} else if (!(Sname.isEmpty())) {
			searchLoop(patientList, Sname, 0, 1, 3, null);
			
			 if (phone.isEmpty()){} else{ searchLoop(searchList, Sname, 0, 2, 4, null); } if (dob
			!= null) { searchLoop(searchList, Sname, 0, 2, 5, null); }
			 
		} else if (!(phone.isEmpty())) {
			searchLoop(patientList, Sname, 0, 1, 4, null);
			
			if (dob != null) { searchLoop(searchList, Sname, 0, 2, 5, null); }
			
		} else if (dob != null) {
			searchLoop(patientList, Sname, 0, 1, 5, null);
		} else {
		}

		return searchList;

	}

	public void searchLoop(PatientList list, String var1, int varID, int r, int a, LocalDate var2) {
		System.out.println("Main loop");
		s = list.getSize();
		System.out.println(s);
		for (int i = 0; i < s; i++) {
			System.out.println("s loop");
			searchSwitch(list, var1, varID, r, a, var2, i);
		}
	}

	public void remove(int i) {
		try {
			searchList.remove(i);
			if (i >= 1) {
				i--;
			}
		} catch (IndexOutOfBoundsException out) {

		}
	}

	public void searchSwitch(PatientList list, String var1, int varID, int r, int a, LocalDate var2, int in) {
		Patient patient = (Patient) list.get(in);
		System.out.println("Here");
		switch (r) {
		case 1:
			switch (a) {
			case 1:
				if (varID == patient.getPatientID()) {
					searchList.addPatient1(patient);
					System.out.println("added" + patient.getPatientID());
				}else {System.out.println("added" + patient.getPatientID());}
				;
				break;
			case 2:
				if (var1.equals(patient.getFname().toUpperCase())) {
					
					searchList.addPatient1(patient);
					
				}
				
				;
				break;
			case 3:
				if (var1.equals(patient.getSname().toUpperCase()) ) {
					searchList.addPatient1(patient);
					System.out.println("added");
				}
				;
				break;
			case 4:
				if (var1.equals(patient.getPhone())) {
					searchList.addPatient1(patient);
					System.out.println("added");
				}
				;
				break;
			case 5:
				if (var2 == patient.getDob()) {
					searchList.addPatient1(patient);
					System.out.println("added");
				}
				;
				break;
			default:
				break;
			}
		case 2:
			// this is used to remove results which match first name but not last name.
			// decrements i to account for 1 index being removed.
			switch (a) {
			case 3:
				if (var1.equals(patient.getSname().toUpperCase())) {
				} else {
					remove(in);
					System.out.println("index = "+in);
					System.out.println("removed");
					in--;s--;
				}
				;
				break;
			case 4:
				if (var1.equals(patient.getPhone())) {
				} else {
					remove(in);
					System.out.println("index = "+in);
					System.out.println("removed");
					in--;s--;
				}
				;
				break;
			case 5:
				if (var2 == patient.getDob()) {
				} else {
					remove(in);
					System.out.println("index = "+in);
					System.out.println("removed");
					in--;s--;
				}

				;
				break;
			}
			if (in < 0) {
				System.out.println("index = "+in);
				in = 0;
			}
		}
	}
}
