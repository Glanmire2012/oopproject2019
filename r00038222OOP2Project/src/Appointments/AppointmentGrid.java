package Appointments;

import java.time.LocalDate;

import controller.Controller;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;
import list.ObjectList;
import list.OverallAppointmentList;
import objects.Patient;
import screensanddisplay.MyGridPane;

public class AppointmentGrid extends MyGridPane {
	String fName;
	String sName;
	String ID;
	
	MyGridPane innerA;
	Patient patient;
	Controller instance;
	
	OverallAppointmentList appointments;
	AppointmentDay day;
	LocalDate today;
	MyGridPane innerB;
	ObjectList store;
	FlowPane slotPane = new FlowPane();
	AppointmentSlot slot;
	Button update;
	boolean ind = false;
	boolean check = false;
	int i;
	int indexOfDay;
	
	public AppointmentGrid(Patient patient, int i) {
		super();
		this.instance = Controller.getInstance();
		this.appointments = instance.getAppointmentList();
		this.day = null;
		this.today = LocalDate.now();
		setPatient(patient);
		setI(i);
		setfName(patient);
		setsName(patient);
		setID(patient);
		grid();

	}
	public AppointmentGrid() {
		this.instance = Controller.getInstance();
		this.appointments = instance.getAppointmentList();
		this.today = LocalDate.now();
	}
	@SuppressWarnings("static-access")
	public void grid() {
		makeAppointment();
		innerB();
		this.setConstraints(innerA, 0, 0);
		this.setConstraints(innerB, 0, 1);
		final ColumnConstraints col1 = new ColumnConstraints(25, Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE);
		final ColumnConstraints col2 = new ColumnConstraints(25, Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE);
		
		col2.setHgrow(Priority.ALWAYS);
		this.getColumnConstraints().addAll(col1, col2);
		this.getChildren().addAll(innerA, innerB);
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
		update = new Button("update");
		Alert alert = new Alert(AlertType.INFORMATION);
		dateInput.setOnAction(e -> {if (dateInput.getValue().isAfter(today)) {
			checkAppointments(dateInput);}else if(dateInput.getValue().isEqual(today)){checkAppointments(dateInput);}else {showAlert("Invalid Date","Must be a future date!!","Please Select a Date which is after today!!");}
		});
		
		
		
		update.setOnAction(e -> checkAppointments(dateInput));
		// This button is not visible until after the first date is picked	

		innerA.prefWidthProperty().bind(this.widthProperty());
		innerA.getChildren().addAll(PIDLabel, PIDtext, fNameLabel, fNameText, sNameLabel, sNameText, dateLabel,
				dateInput);

	}

	@SuppressWarnings("static-access")
	public void checkAppointments(DatePicker dateInput) {
		// checks for times available on a particular date.
		LocalDate dateToCheck = dateInput.getValue();// date that needs to be checked.
		
		int ListSize = appointments.getSize();// gets the size of the appointment list.
		if (ListSize == 0) { // if the list size is zero (first use), the required day is created and added
								// to the list.
			createNewDay(dateToCheck);
			ind = true;// sets ind to true, date now exists.
			day = (AppointmentDay) appointments.get(0); // sets day to this newly created day, which will be at index 0
			this.indexOfDay = 0;
			System.out.println("No days exist"); // because it is the first entry.
		} else {
			for (int i = 0; i < ListSize; i++) { // loops through the list to find the relevant day.
				AppointmentDay d = (AppointmentDay) appointments.get(i);
				AppointmentSlot s = (AppointmentSlot) d.get(0);// check the first element for the date.
				if (s.getDay().equals(dateToCheck)) {
					ind = true;// date found
					day = d;
					this.indexOfDay = i;
					break;// break from loop. There is no need to continue searching the list as each day
							// should only exist once.
				}
			}
		}
		if (ind == false) {// if the day does not exist it is then created.
			System.out.println("Date does not exist yet");
			createNewDay(dateToCheck);
			this.indexOfDay=instance.appointmentList.getSize()-1;
		}
		innerA.setConstraints(update, 0, 3);
		if ( check == false) {
			innerA.getChildren().add(update);
		}
		check = true;
		populate();
	}

	public void populate() {
		ObjectList frames = new ObjectList();
		slotPane.getChildren().clear();
		innerB.getChildren().clear();
		try {
			int rsize = day.getSize();
			System.out.println("Size of Day is : "+rsize);
			for (int i = 0; i < rsize; i++) {
				slot = (AppointmentSlot) day.get(i);
				slot.setMyIndex(i);// this sets the index of this slot for use in updating
				AppointmentDisplay searchPane = new AppointmentDisplay(i, indexOfDay, this.i);
				searchPane.buildAppointmentSimpleFrame();
				frames.add(searchPane);
			}
		} catch (NullPointerException n) {
			System.out.println("Null pointer");
		}
		// Add the result frames to the result pane which is a gridpane.
		int size = frames.getSize();
		System.out.println("reslults frame size " + size);
		
		for (int i = 0; i < size; i++) {
			slotPane.getChildren().add((Node) frames.get(i));
		}
		slotPane.prefWidthProperty().bind(this.widthProperty());

		innerB.getChildren().addAll(slotPane);

	}

	public void innerB() {

		innerB = new MyGridPane();
		innerB.setAlignment(Pos.CENTER);
		populate();
	}
	
	

	public void createNewDay(LocalDate dateToCheck) { // creates the required day by populating the list with
														// appointment slots for each hour and half hour from 8am to
														// 5pm.
		AppointmentDay newDay = new AppointmentDay();
		int hour = 800;
		for (int i = 0; i < 9; i++) {
			AppointmentSlot time = new AppointmentSlot(dateToCheck, hour, -1);
			newDay.addSlot(time);
			AppointmentSlot time30 = new AppointmentSlot(dateToCheck, hour + 30, -1);
			newDay.addSlot(time30);
			hour = hour + 100;
		}
		System.out.println("Day created");
		this.day = newDay;
		instance.appointmentList.addAppointment(newDay);// Adds the freshly created day to the appointment list
		instance.update();
	}
	public void updateAppointmentsScreen(MyGridPane displayAppoinments) {
		innerB.getChildren().clear();
		innerB.getChildren().addAll(displayAppoinments);
	}
	public void showAlert(String title, String intro, String context){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(intro);
		alert.setContentText(context);
		alert.showAndWait();
		
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

	
}
