package list;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

import objects.Patient;

public class ObjectList  implements Serializable {

	private static final long serialVersionUID = 1L;

	private ArrayList<Object> list;
	
	public ObjectList() {
		list = new ArrayList<Object>();
	}
	
	public void add(Object obj) {
		this.list.add(obj);
	}
	
	public int getSize() {
		return this.list.size();// returns the size of the arraylist
	}
	
	public void remove(int i) {
		this.list.remove(i);// removes objects from the array list
	}
	public Object get() {
		return this.list;// returns an object 
	}
	public Object get(int i) {
		return this.list.get(i);// returns an object at agiven index
	}
	
	public ArrayList<Object> getList(){
		return this.list;// returns the entire list
	}

	public PatientList sort(Comparator<Patient> comparing) {
		return null;
		// TODO Auto-generated method stub
		
	}
}
