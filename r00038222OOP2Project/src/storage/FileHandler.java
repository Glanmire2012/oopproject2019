package storage;

import java.io.File;
import java.io.Serializable;

public class FileHandler implements Serializable{
	File fileName;
	boolean exists;
	public boolean fileExists() {
		exists = fileName.exists();
		return exists;
	}
	public void setFile(File file) {
		file = this.fileName;
	}
}
