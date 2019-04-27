package Login;

import controller.Controller;
import dataentry.HomeScene;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import screensanddisplay.MainTab;

public class Login {
	//login details
	final String user = "bucky";
	final String password = "password";
	Controller instance = Controller.getInstance();
	public Login() {
		super();
		
		//Controller instance = Controller.getInstance();
		
	}

	public void showAlert(String title, String intro, String context){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(intro);
		alert.setContentText(context);
		alert.showAndWait();
		
	}
	
	public void handleLogin(TextField nameInput,PasswordField passInput) {
		instance.fileSetup();
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
			Alert alert = new Alert(AlertType.INFORMATION);
			showAlert("Login Success","Access Granted","You can now continue to the Homepage. Unauthorised use is strictly prohibitted");
			//Controller instance = Controller.getInstance();
			
			
			instance.getStage().setScene(scene);
		}
	}

}
