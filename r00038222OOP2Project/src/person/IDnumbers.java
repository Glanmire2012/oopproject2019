package person;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class IDnumbers implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Calendar rightNow;
	Date date;
	
	public IDnumbers() {
		this.rightNow = Calendar.getInstance();
		date = rightNow.getTime();
		
	}
	public int generateID() {
		int year = rightNow.get(Calendar.YEAR)-2000;
		int day = rightNow.get(Calendar.DAY_OF_YEAR);
		int hour = rightNow.get(Calendar.HOUR_OF_DAY);

		int millisecond = rightNow.get(Calendar.MILLISECOND);
		String IDstring = ""+year+""+day+""+hour+""+millisecond;
		int ID = Integer.parseInt(IDstring);
		return ID;
	}
	
}
