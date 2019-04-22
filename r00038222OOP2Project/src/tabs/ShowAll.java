package tabs;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import controller.Controller;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import list.ObjectList;
import list.PatientList;
import panes.MyGridPane;
import panes.PatientDisplayPane;
import person.Patient;

public class ShowAll extends MyGridPane{
	PatientList patientList;
	Controller instance;
	TextField ID;
	TextField fNameInput;
	TextField sNameInput;
	TextField Phone;
	DatePicker dob;
	Patient patient;
	int PID;
	String Fname;
	String Sname;
	String fon;
	LocalDate Dob;
	MyGridPane resultsPane;
	ScrollPane scrollpane = new ScrollPane();
	GridPane inner = new GridPane();

	public ShowAll() {

		this.instance = Controller.getInstance();
		this.patientList = instance.getPatientList();
		this.resultsPane = new MyGridPane();
		this.getChildren().clear();
		
		
		display();
	}
	
	public void display() {
		
		Label Heading = new Label("List of all current Patients");GridPane.setConstraints(Heading, 0, 0, 5, 1);
		int size = patientList.getSize();
		GridPane.setConstraints(scrollpane, 0, 4);
		scrollpane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		ObjectList resultFrames = new ObjectList();
		System.out.println("Patient list size is: "+size);
		for(int i = 0; i < size; i++) {
			patient = (Patient) patientList.get(i);
			PatientDisplayPane srPane = new PatientDisplayPane(patient,i);
			resultFrames.add(srPane);
			srPane.prefWidthProperty().bind(this.widthProperty());
		}
		
		//resultFrames.sort(Comparator.comparing(Patient::getSname));
		int rsize = resultFrames.getSize();
		for (int i = 0; i < rsize; i++) {
			GridPane.setConstraints((Node)resultFrames.get(i),0,i);
			resultsPane.getChildren().add((Node)resultFrames.get(i));
		}
		scrollpane.setContent(resultsPane);
		
		resultsPane.prefWidthProperty().bind(this.widthProperty());
		scrollpane.prefWidthProperty().bind(this.widthProperty());
		scrollpane.prefHeightProperty().bind(this.heightProperty());
		Button refresh = new Button("Refresh");this.setConstraints(refresh,0, 6);
		refresh.setOnAction(e -> reload() );
		this.getChildren().clear();
		this.getChildren().addAll(Heading,scrollpane, refresh);
		
	}
	public void reload() {
		instance = Controller.getInstance();
		instance.getPatientList();
		resultsPane.getChildren().clear();
		display();
	}
}