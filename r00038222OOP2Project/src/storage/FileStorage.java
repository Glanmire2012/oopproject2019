package storage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileStorage implements Serializable {
    public Object readObject(String fileName) {
		Object ob = null;
		try {
			FileInputStream fileIn = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			ob = in.readObject();
			in.close();
		} catch (IOException i) {
			//i.printStackTrace();
		} catch (ClassNotFoundException c) {
			//c.printStackTrace();
		}
		return ob;
	}

	public boolean writeObject(Object ob, String fileName) {
		boolean success = true;
		try {
			FileOutputStream fileOut = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(ob);
			System.out.println("written");
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
			success = false;
		}
		return success;
	}
}
