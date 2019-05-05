package main;

import controller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;
import screensanddisplay.LoginGrid;
import stagesandScenes.LoginScene;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Tabs");
		LoginGrid pane = new LoginGrid();
		LoginScene scene = new LoginScene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();
		Controller.getInstance().setStage(primaryStage);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
