package objects;

import java.io.Serializable;
import controller.Controller;
import generateNumbers.IDnumbers;

public class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String fname;
	String sname;
	Controller instance;
	IDnumbers IDgen;
	long PatientID;

	public Person() {
		instance = Controller.getInstance();
		IDgen = new IDnumbers();

		this.PatientID = IDgen.generateID();

	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fNameInput) {
		this.fname = fNameInput.toUpperCase();
	}

	public long getPatientID() {
		return PatientID;
	}

	public void setPatientID(long patientID) {
		PatientID = patientID;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname.toUpperCase();
	}

}
