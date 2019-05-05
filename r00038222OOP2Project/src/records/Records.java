package records;

import objects.Patient;
import stagesandScenes.Newstage;

public class Records extends Newstage {

	public Records(Patient patient, int i) {

		this.setPatient(patient);
		this.setI(i);

		getWindow().setScene(getScene());

		RecordGrid recordGrid = new RecordGrid(patient, i);
		recordGrid.maxWidthProperty().bind(getLayout().widthProperty());
		recordGrid.minWidthProperty().bind(getLayout().widthProperty());
		getLayout().setContent(recordGrid);
	}

}
