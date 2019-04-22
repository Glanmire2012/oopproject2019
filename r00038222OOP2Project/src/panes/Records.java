package panes;

import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import person.Patient;
import stages.Newstage;

public class Records extends Newstage{
	
	public Records(Patient patient, int i) {
		
		this.setPatient(patient);
		this.setI(i);
	
		getWindow().setScene(getScene());

        RecordGrid recordGrid = new RecordGrid(patient , i);
        
        getLayout().setContent(recordGrid);
	}
	

}
