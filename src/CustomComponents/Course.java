package CustomComponents;

import java.util.ArrayList;
import java.io.Serializable;
import java.io.*;

public class Course implements Serializable {
	private static String fileName = "Course_curID.ser";
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
		Course.loadCurID(fileName);
		this.courseId = curID;
		curID++;
		this.lessons = lessons;
		Course.saveCurID(fileName);
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
			System.out.println("serialized curID of Course has been saved to " + fileName);
		} catch(IOException i) {
			i.printStackTrace();
		}
	}

	// Load the curID from file
	public static void loadCurID(String fileName) {
		try {
			FileInputStream fileIn = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			curID = ((Integer) in.readObject()).intValue();
			in.close();
			fileIn.close();
			System.out.println("deserialized curID of Course has been loaded from " + fileName);
		} catch(IOException i) {
			i.printStackTrace();
		} catch(ClassNotFoundException c) {
			System.out.println("curID of Course not found");
			c.printStackTrace();
		}
	}

	public static String getFileName() {
		return fileName;
	}

	public static void setFileName(String fileName) {
		Course.fileName = fileName;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public static int getCurID() {
		return curID;
	}

	public static void setCurID(int curID) {
		Course.curID = curID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(ArrayList<Lesson> lessons) {
		this.lessons = lessons;
	}

	public int getNoLessons() {
		return noLessons;
	}

	public void setNoLessons(int noLessons) {
		this.noLessons = noLessons;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
