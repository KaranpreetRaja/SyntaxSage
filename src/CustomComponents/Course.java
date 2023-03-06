package CustomComponents;

import java.util.ArrayList;

import java.io.Serializable;
import java.io.*;

public class Course implements Serializable {
	private static final long serialVersionUID = 1L;
	private int courseId = 0; // UUID for class
	public static int curID = 0; //UUID for 
	private String name; //course name
	private ArrayList<Lesson> lessons;
	private int noLessons; // number of lessons
	//TODO: Add badges array
	
	//private String fileName = "course.ser"; //path to ser file
	
	
	//constructor
	public Course(String name){
		this.name = name;
		
		
		this.noLessons = 0;
		this.courseId = curID;
		curID++;
	}

	// Serialize the object
	public void saveCourse(String fileName) {
		try {
			FileOutputStream fileOut = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(this);
			out.close();
			fileOut.close();
			System.out.println("Serialized data is saved in " + fileName);
		} catch(IOException i) {
			i.printStackTrace();
		}
	}

	// Deserialize the object
	public static Course loadCourse(String fileName) {
		Course course = null;
		try {
			FileInputStream fileIn = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			course = (Course) in.readObject();
			in.close();
			fileIn.close();
			System.out.println("Deserialized data is loaded from " + fileName);
		} catch(IOException i) {
			i.printStackTrace();
		} catch(ClassNotFoundException c) {
			System.out.println("Course class not found");
			c.printStackTrace();
		}
		return course;
	}
}
