package CustomComponents;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Lesson {
	public static int curID = 0;

	private static String fileName = "Lesson_curID.ser";

	private int lessonID;
	private String name;
	public int noQuestions;
    public int curQuestion;
    public Question[] questions;
	
	
	public Lesson(String name, int noQuestions, Question[] questions) {
		Lesson.loadCurID(fileName);
		this.lessonID = Lesson.curID;
		Lesson.curID++;
	    Lesson.saveCurID(fileName);
	     
        this.name = name;
        
        this.noQuestions = noQuestions;
        this.curQuestion = 0;
        this.questions = questions;
    }

    public Lesson(String name) {
        this.sessionName = "Default";
        this.noQuestions = 0;
        this.curQuestion = 0;
        this.questions = new Question[0];
    }

    public Question getNextQuestion() {
        if (curQuestion < noQuestions) {
            curQuestion++;
            return questions[curQuestion--];
        }
        return null;
    }

    public static void saveCurID(String fileName) {
		try {
			FileOutputStream fileOut = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(curID);
			out.close();
			fileOut.close();
			System.out.println("serialized curID of Lesson has been saved to " + fileName);
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
			System.out.println("deserialized curID of Lesson has been loaded from " + fileName);
		} catch(IOException i) {
			i.printStackTrace();
		} catch(ClassNotFoundException c) {
			System.out.println("curID of Lesson not found");
			c.printStackTrace();
		}
	}

	// Getter for curID
	public static int getCurID() {
		return curID;
	}

	public static void setCurID(int curID) {
		Lesson.curID = curID;
	}

	public int getLessonID() {
		return lessonID;
	}

	public void setLessonID(int lessonID) {
		this.lessonID = lessonID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNoQuestions() {
		return noQuestions;
	}

	public void setNoQuestions(int noQuestions) {
		this.noQuestions = noQuestions;
	}

	public int getCurQuestion() {
		return curQuestion;
	}

	public void setCurQuestion(int curQuestion) {
		this.curQuestion = curQuestion;
	}

	public Question[] getQuestions() {
		return questions;
	}

	public void setQuestions(Question[] questions) {
		this.questions = questions;
	}

}
