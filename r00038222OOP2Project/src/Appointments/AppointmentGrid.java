package Appointments;

import java.time.LocalDate;

import controller.Controller;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;
import panes.MyGridPane;
import person.Patient;

public class AppointmentGrid extends MyGridPane {
	String fName;
	String sName;
	String ID;
	MyGridPane innerA;
	Patient patient;
	Controller instance;
	AppointmentList appointments;
	AppointmentDay day;
	ScrollPane innerB;
	boolean ind = false;
	int i;
	int a;

	

	@SuppressWarnings("static-access")
	public void grid() {
		makeAppointment();
		innerB();
		this.setConstraints(innerA, 0, 0);
		this.setConstraints(innerB, 1, 0);
		this.prefWidthProperty().bind(this.widthProperty());
		this.getChildren().addAll(innerA, innerB);
	}

	public void innerB() {

		innerB = new ScrollPane();
		MyGridPane listResults = new MyGridPane();
		listResults.getChildren().clear();
		try {
			int sizeOfDay = day.getSize();
			for (int i = 0; i < sizeOfDay;) {
				AppointmentDisplay frame = new AppointmentDisplay(day, i);
				listResults.getChildren().add(frame);
			}
		} catch (NullPointerException n) {
			System.out.println("Null pointer Exception");
		}
		innerB.prefWidthProperty().bind(this.heightProperty());
		innerB.setContent(listResults);
	    innerB.autosize();
	}

	

	

	@SuppressWarnings("static-access")
	public void makeAppointment() {
		innerA = new MyGridPane();
		Text PIDLabel = new Text("PID");
		innerA.setConstraints(PIDLabel, 0, 0);
		Text PIDtext = new Text(ID);
		innerA.setConstraints(PIDtext, 1, 0);

		Text fNameLabel = new Text("First Name : ");
		innerA.setConstraints(fNameLabel, 0, 1);
		Text fNameText = new Text(fName);
		innerA.setConstraints(fNameText, 1, 1);

		Text sNameLabel = new Text("Last Name : ");
		innerA.setConstraints(sNameLabel, 2, 1);
		Text sNameText = new Text(sName);
		innerA.setConstraints(sNameText, 3, 1);

		Text dateLabel = new Text("Date :");
		innerA.setConstraints(dateLabel, 0, 2);
		DatePicker dateInput = new DatePicker();
		innerA.setConstraints(dateInput, 1, 2);

		// After entering the date the user clicks "check times" to get a list of times
		// available for that day, if any.
		Button check = new Button("Check Times");
		innerA.setConstraints(check, 0, 3);
		check.setOnAction(e -> checkAppointments(dateInput));

		innerA.prefWidthProperty().bind(this.widthProperty());
		innerA.getChildren().addAll(PIDLabel, PIDtext, fNameLabel, fNameText, sNameLabel, sNameText, dateLabel,
				dateInput, check);

	}



	public void checkAppointments(DatePicker dateInput) {
		// checks for times available on a particular date.
		LocalDate dateToCheck = dateInput.getValue();// date that needs to be checked.

		int ListSize = appointments.getSize();// gets the size of the appointment list.
		if (ListSize == 0) { // if the list size is zero (first use), the required day is created and added
								// to the list.
			createNewDay(dateToCheck);
			ind = true;// sets ind to true, date now exists.
			day = (AppointmentDay) appointments.get(0); // sets day to this newly created day, which will be at index 0
			System.out.println("No days exist");										// because it is the first entry.
		} else {
			for (int i = 0; i < ListSize; i++) { // loops through the list to find the relevant day.
				AppointmentDay d = (AppointmentDay) appointments.get(i);
				Slot s = (Slot) d.get(0);// check the first element for the date.
				if (s.getDay() == dateToCheck) {
					ind = true;// date found
					day = d;
					a = i;
					break;// break from loop. There is no need to continue searching the list as each day
							// should only exist once.
				}
			}
		}
		if (ind == false) {// if the day does not exist it is then created.
			System.out.println("Date does not exist yet");
			createNewDay(dateToCheck);
		} else if (ind == true) { // once the day exists a list of available times is then generated, to be
									// displayed.
			AppointmentDisplay appointmentFrames = new AppointmentDisplay(day, a);
			int daySize = day.getSize();
			System.out.println(daySize);
			appointmentFrames.buildAppointmentSimpleFrame();
		}
		
	}

	public void createNewDay(LocalDate dateToCheck) { // creates the required day by populating the list with
														// appointment slots for each hour and half hour from 8am to
														// 5pm.
		AppointmentDay newDay = new AppointmentDay();
		int hour = 800;
		for (int i = 0; i < 9; i++) {
			Slot time = new Slot(dateToCheck, hour, 0);
			newDay.addSlot(time);
			Slot time30 = new Slot(dateToCheck, hour + 30, -1);
			newDay.addSlot(time30);
			hour = hour + 100;
		}
		System.out.println("Day created");
		this.day = newDay;
		instance.appointmentList.addAppointment(newDay);// Adds the freshly created day to the appointment list
		instance.updateList();
	}

	public String getfName() {
		return fName;
	}

	public void setfName(Patient patient) {
		this.fName = patient.getFname();
	}

	public String getsName() {
		return sName;
	}

	public void setsName(Patient patient) {
		this.sName = patient.getSname();
	}

	public String getID() {
		return ID;
	}

	public void setID(Patient patient) {
		ID = ("" + patient.getPatientID() + "");
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
	public AppointmentGrid(Patient patient, int i) {
		super();
		this.instance = Controller.getInstance();
		this.appointments = instance.getAppointmentList();
		
		setPatient(patient);
		setI(i);
		setfName(patient);
		setsName(patient);
		setID(patient);
		grid();
	}
}
