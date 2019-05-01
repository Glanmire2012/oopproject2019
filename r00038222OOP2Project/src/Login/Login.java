package Login;

import java.time.LocalDate;
import java.util.logging.FileHandler;

import Appointments.AppointmentDay;
import Appointments.AppointmentGrid;
import Appointments.AppointmentSlot;
import controller.Controller;
import dataentry.HomeScene;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import list.OverallAppointmentList;
import list.ProcedureList;
import procedures.DisplayProcedures;
import javafx.scene.control.Alert.AlertType;
import screensanddisplay.MainTab;

public class Login {
	// login details
	final String user = "bucky";
	final String password = "password";
	Controller instance = Controller.getInstance();
	ProcedureList pList;
	boolean check;

	public Login() {
		super();

		// Controller instance = Controller.getInstance();

	}

	public void initialise() {// To ensure that today exists in the appointment list
								// and to create the default procedure list on first run.
		LocalDate today = LocalDate.now();
		OverallAppointmentList list = instance.getAppointmentList();
		try {
			int size = list.getSize();
			for (int i = 0; i < size; i++) {
				AppointmentDay day = (AppointmentDay) list.get(i);
				AppointmentSlot slot = (AppointmentSlot) day.get(0);
				if (slot.day.equals(today)) {
					check = true;
				}
			}
			if (check == false) {
				AppointmentGrid grid = new AppointmentGrid();
				grid.createNewDay(today);
			}

		} catch (NullPointerException n) {
			AppointmentGrid grid = new AppointmentGrid();
			grid.createNewDay(today);
		}
		try {
			pList = instance.getProcedureList();
			
			if (instance.isState() == false) {
				int psize = pList.getSize();
				System.out.println("plist size"+psize);
				if (psize == 0) {
					DisplayProcedures disp = new DisplayProcedures();
					disp.firstRun();
					System.out.println("pro list created");

				}
			
			}
		} catch (NullPointerException n) {

		}

	}

	public void showAlert(String title, String intro, String context) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(intro);
		alert.setContentText(context);
		alert.showAndWait();

	}

	public void handleLogin(TextField nameInput, PasswordField passInput) {
		instance.fileSetup();
		initialise();
		String username = nameInput.getText().toString();
		boolean success = true;

		if (!username.toUpperCase().equals(user.toUpperCase())) {
			success = false;
		}

		String pass = passInput.getText().toString();
		// if above check has passed do this check
		if ((!pass.toUpperCase().equals(password.toUpperCase())) && success) {
			success = false;
		}

		if (!success) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Login Failure");
			alert.setHeaderText("Authentication UnSuccessful");
			alert.setContentText("Please try again!");
			alert.showAndWait();
		} else {
			Group root = new Group();
			MainTab pane = new MainTab();

			root.getChildren().add(pane);
			HomeScene scene = new HomeScene(root);

			showAlert("Login Success", "Access Granted",
					"You can now continue to the Homepage. Unauthorised use is strictly prohibitted");
			// Controller instance = Controller.getInstance();

			instance.getStage().setScene(scene);
		}
	}

}
