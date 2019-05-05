package tabs;

import controller.Controller;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import list.ObjectList;
import list.PatientList;
import objects.Patient;
import patient.PatientDisplayPane;
import screensanddisplay.MyGridPane;
import search.Search;

public class SearchTab extends MyGridPane {
	// User entered data
	TextField ID;
	TextField fNameInput;
	TextField sNameInput;
	TextField Phone;
	DatePicker DateOfBirth;
	// Imported data from "Instance"
	Controller instance;
	Patient patient;

	int PID;
	MyGridPane resultsPane;
	ScrollPane scrollpane = new ScrollPane();

	public SearchTab() {
		searching();
		instance = Controller.getInstance();
	}

	public void searching() {
		Text head = new Text();
		head.setText("Please Enter at least 1 Field Below to search Patient files.");
		GridPane.setConstraints(head, 0, 0, 3, 1);

		Label fNameLabel = new Label("First Name:");
		GridPane.setConstraints(fNameLabel, 0, 1);
		fNameInput = new TextField();
		GridPane.setConstraints(fNameInput, 1, 1);

		// Second Name Label and entry
		Label sNameLabel = new Label("Surname:");
		GridPane.setConstraints(sNameLabel, 2, 1);
		sNameInput = new TextField();
		GridPane.setConstraints(sNameInput, 3, 1);

		Label phoneLabel = new Label("Phone:");
		GridPane.setConstraints(phoneLabel, 2, 2);
		Phone = new TextField();
		GridPane.setConstraints(Phone, 3, 2);

		Label dobLabel = new Label("Date of Birth:");
		GridPane.setConstraints(dobLabel, 0, 2);
		DateOfBirth = new DatePicker();
		GridPane.setConstraints(DateOfBirth, 1, 2);

		Label IDLabel = new Label("Patient ID:");
		GridPane.setConstraints(IDLabel, 0, 3);
		ID = new TextField();
		GridPane.setConstraints(ID, 1, 3);

		GridPane.setConstraints(scrollpane, 0, 4, 12, 15);
		scrollpane.setVbarPolicy(ScrollBarPolicy.ALWAYS);

		resultsPane = new MyGridPane();

		Button enter = new Button("Search");
		enter.setOnAction(e -> startSearch(fNameInput, sNameInput, DateOfBirth, ID, Phone));
		GridPane.setConstraints(enter, 3, 25);

		this.getChildren().clear();

		this.getChildren().addAll(fNameLabel, fNameInput, sNameLabel, sNameInput, head, dobLabel, DateOfBirth,
				phoneLabel, Phone, scrollpane, IDLabel, ID, enter);

		scrollpane.prefWidthProperty().bind(this.widthProperty());
	}

	@SuppressWarnings("static-access")
	public void startSearch(TextField fNameInput2, TextField sNameInput2, DatePicker dob, TextField ID,
			TextField Phone) {
		// Convert input to the correct data type before passing it to the search class.
		try {
			this.PID = Integer.parseInt(ID.getText());
		} catch (NumberFormatException n) {
			this.PID = 0;
			// n.printStackTrace();
		} finally {
		}
		// Creates a new instance of search and is returned a list of results.
		Search search = new Search();
		PatientList results = search.startSearch(fNameInput2.getText(), sNameInput2.getText(), dob.getValue(), PID,
				Phone.getText());
		int rsize = results.getSize();

		// Create an Objectlist of result frames
		ObjectList resultFrames = new ObjectList();
		for (int i = 0; i < rsize; i++) {
			patient = (Patient) results.get(i);
			PatientDisplayPane searchPane = new PatientDisplayPane(patient, i);
			resultFrames.add(searchPane);
		}
		// Add the result frames to the result pane which is a gridpane.
		int size = resultFrames.getSize();
		for (int i = 0; i < size; i++) {

			resultsPane.setConstraints((Node) resultFrames.get(i), 0, i);
			resultsPane.getChildren().add((Node) resultFrames.get(i));
		}
		resultsPane.prefWidthProperty().bind(this.widthProperty());
		scrollpane.setContent(resultsPane);

		searching();

	}

}
