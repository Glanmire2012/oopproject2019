package dataentry;



import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Welcome extends GridPane{
	TextField fNameInput;
	TextField sNameInput;
	PasswordField passInput;
	
	public Welcome(){
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setVgap(8);
		this.setHgap(10);

		// Name Label - constrains use (child, column, row)
		Label welcome = new Label("WELCOME");
		GridPane.setConstraints(welcome, 0, 0);

		
		this.getChildren().addAll(welcome);
				
	}
	
	
}
