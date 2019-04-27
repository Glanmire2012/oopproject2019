package screensanddisplay;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LoginGrid extends MyGridPane{
	public LoginGrid(){
		// Name Label - constrains use (child, column, row)
		Label nameLabel = new Label("Username:");
		GridPane.setConstraints(nameLabel, 0, 0);

		// Name Input
		nameInput = new TextField("Bucky");
		GridPane.setConstraints(nameInput, 1, 0);

		// Password Label
		Label passLabel = new Label("Password:");
		GridPane.setConstraints(passLabel, 0, 1);

		// Password Input
		passInput = new PasswordField();
		passInput.setPromptText("password");
		GridPane.setConstraints(passInput, 1, 1);

		// Login
		Button loginButton = new Button("Log In");
	
		loginButton.setOnAction(e -> login.handleLogin(nameInput,passInput));
		GridPane.setConstraints(loginButton, 1, 2);
		GridPane.setConstraints(loginButton, 1, 2);
		// Add everything to grid
		this.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton);
	}
}
