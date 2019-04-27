package stagesandScenes;

import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import objects.Patient;
import records.RecordGrid;
import screensanddisplay.MyGridPane;

public class Newstage {
	
	ScrollPane Layout;
	Patient patient;
	Stage window;
	Scene scene;
	int a;
	int b;
	int i;
	public Newstage() {
		
		setLayout(Layout);
		Layout.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		setScene(scene);
		setWindow(window);
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public void setUp() {
		//scene = new Scene(Layout,600,450);
		//window = new Stage();
		
        //window.setScene(scene);
        //window.show();
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
	

	public ScrollPane getLayout() {
		return Layout;
	}

	public void setLayout(ScrollPane layout) {
		Layout = new ScrollPane();
	}

	public Stage getWindow() {
		return window;
	}

	public void setWindow(Stage window) {
		this.window = new Stage();
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = new Scene(Layout,600,450);
	}
	public void setScene() {
		this.scene = new Scene(Layout,300,225);
	}
	
}
