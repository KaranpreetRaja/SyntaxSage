package CustomComponents;

import java.util.Arrays;
import java.util.List;

public class Question {
    private int id;
    private static int CUR_ID = 0;
    private String prompt;
    private List<String> options;
    private List<String> answers;
    private boolean isMulChoice;
    private int noAns;

    // Constructor

    public Question(String prompt, List<String> options, List<String> answers) {
        this.id = CUR_ID;
        CUR_ID++;
        this.prompt = prompt;
        this.answers = answers;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getCurId() {
        return Question.CUR_ID;
    }

    public static void setCurId(int CUR_ID) {
        Question.CUR_ID = CUR_ID;
    }

    public int getNoAns() {
        return this.noAns;
    }

    public void setNoAns(int noAns) {
        this.noAns = noAns;
    }

    public String getPrompt() {
        return this.prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }
    
    public List<String> getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = Arrays.asList(options);
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = Arrays.asList(answers);
    }
    
    public boolean isAnswer(String str) {
        // Check if the given string is present in the answers array
        for (String answer : answers) {
            if (answer.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public String getStringOptions() {
        // Return a comma and space separated list of options
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < options.size(); i++) {
            sb.append(options.get(i));
            if (i < options.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
    
}
