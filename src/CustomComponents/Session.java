package CustomComponents;

import java.util.ArrayList;
import java.util.List;

public class Session {
    private Account user;
    private Lesson lesson;
    private List<String> answers;

    public Session(Lesson lesson, Account user) {
        this.lesson = lesson;
        this.user = user;
        this.answers = new ArrayList<String>();
    }


    public void setAnswer(int questionNumber, List<String> answers) {
    }
}
