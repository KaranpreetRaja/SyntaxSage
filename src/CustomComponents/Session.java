package CustomComponents;

public class Session {
    public String sessionName;
    public int noQuestions;
    public int curQuestion;
    public Question[] questions;

    public Session(String sessionName, int noQuestions, int curQuestion, Question[] questions) {
        this.sessionName = sessionName;
        this.noQuestions = noQuestions;
        this.curQuestion = curQuestion;
        this.questions = questions;
    }

    public Session() {
        this.sessionName = "Default";
        this.noQuestions = 0;
        this.curQuestion = 0;
        this.questions = new Question[0];
    }

    public void getNextQuestion() {
        if (curQuestion < noQuestions) {
            curQuestion++;
        }
    }

}