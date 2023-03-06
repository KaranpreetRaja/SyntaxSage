package CustomComponents;

public class Lesson {
	private int lessonID;
	public static int curID = 0;
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

}
