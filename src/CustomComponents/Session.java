package CustomComponents;

import java.util.ArrayList;

public class Session {
    private Account user;
    private Lesson lesson;
    private ArrayList<String> answers;

    public Session(Lesson lesson, Account user) {
        this.lesson = lesson;
        this.user = user;
        this.answers = new ArrayList<String>();
    }


    public void setAnswer(int questionNumber, String answer) {
        
    }
}
