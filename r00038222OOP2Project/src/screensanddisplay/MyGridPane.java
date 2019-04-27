package screensanddisplay;

import Login.Login;
import javafx.geometry.Insets;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class MyGridPane extends GridPane{
	TextField nameInput;
	PasswordField passInput;
	Login login = new Login();
	public MyGridPane(){
		this.setPadding(new Insets(10, 5, 5, 10));
		this.setVgap(8);
		this.setHgap(10);
		this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));// creates a border
	}
}
