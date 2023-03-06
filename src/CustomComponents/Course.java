package CustomComponents;

import java.util.ArrayList;
import java.io.Serializable;
import java.io.*;

public class Course implements Serializable {
	private static final long serialVersionUID = 1L;
	private int courseId; // UUID for class
	private static int curID = 0; //UUID for Current ID
	private String name; //course name
	private ArrayList<Lesson> lessons;
	private int noLessons; // number of lessons
	//TODO: Add badges array
	
	// Constructor for Course
	public Course(String name, ArrayList<Lesson> lessons){
		this.name = name;
		this.noLessons = 0;
		this.courseId = curID;
		curID++;
		this.lessons = lessons;
	}
	
	public Course(String name){
		this.name = name;
		this.noLessons = 0;
		this.courseId = curID;
		curID++;
	}

	// Save the curID to file
	public static void saveCurID(String fileName) {
		try {
			FileOutputStream fileOut = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(curID);
			out.close();
			fileOut.close();
			System.out.println("Serialized data is saved in " + fileName);
		} catch(IOException i) {
			i.printStackTrace();
		}
	}

	// Load the curID from file
	public static void loadCurID(String fileName) {
		try {
			FileInputStream fileIn = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			curID = (int) in.readObject();
			in.close();
			fileIn.close();
			System.out.println("Deserialized data is loaded from " + fileName);
		} catch(IOException i) {
			i.printStackTrace();
		} catch(ClassNotFoundException c) {
			System.out.println("Class not found");
			c.printStackTrace();
		}
	}

	// Getter for curID
	public static int getCurID() {
		return curID;
	}
}
