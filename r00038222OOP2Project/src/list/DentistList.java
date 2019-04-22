package list;

public class DentistList extends ObjectList{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Dentist dentist; 
	public int d;
	
	public DentistList addProcedure(Dentist dentist) {
		this.dentist = dentist;
		this.add(dentist);	
		return null;
	}	
	public DentistList removeProcedure(int d) {
		this.d = d;
		this.remove(d);
		return null;
	} 
}
