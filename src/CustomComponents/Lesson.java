package CustomComponents;

public class Lesson {
	public static int curID = 0;

	private int lessonID;
	private String name;
	public int noQuestions;
    public int curQuestion;
    public Question[] questions;
	
	
	public Lesson(String name, int noQuestions, Question[] questions) {
        this.name = name;
        this.lessonID = curID;
        curID++;
        
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
