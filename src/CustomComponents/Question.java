package CustomComponents;

import java.util.ArrayList;

public class Question {
    private int id;
    private static int CUR_ID = 0;
    private String prompt;
    private List<String> options;
    private List<String> answers;
    private boolean isMulChoice;

    // Constructor

    public Question(String prompt, List<String>, List<String> answers) {
        this.id = CUR_ID;
        CUR_ID++;
        this.prompt = prompt;
        this.options = options;
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
    
    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
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
        for (int i = 0; i < options.length; i++) {
            sb.append(options[i]);
            if (i < options.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
    
}
