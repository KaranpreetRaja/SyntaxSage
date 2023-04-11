package CustomComponents;

import java.util.Arrays;
import java.util.List;

public class Question {
    private int id;
    private static int CUR_ID = 0;
    private String prompt;
    private List<String> options;
    private Answer answer;
    
    // Constructor
    public Question(String prompt, List<String> options, List<String> answers) {
        this.id = CUR_ID;
        CUR_ID++;
        this.prompt = prompt;
        this.options = options;
        this.answer = new Answer(answers);
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

    public int getNumberOfAnswers() {
        return this.answer.getNumberOfAnswers();
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
        return answer.getAnswers();
    }

    public void setAnswers(String[] answers) {
        this.answer.setAnswers(Arrays.asList(answers));
    }

    public boolean isAnswer(String str) {
        return answer.isAnswer(str);
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

    // Answer class to handle answer-related properties and methods
    private static class Answer {
        private List<String> answers;
        private int numberOfAnswers;

        public Answer(List<String> answers) {
            this.answers = answers;
            this.numberOfAnswers = answers.size();
        }

        public List<String> getAnswers() {
            return this.answers;
        }

        public void setAnswers(List<String> answers) {
            this.answers = answers;
            this.numberOfAnswers = answers.size();
        }

        public int getNumberOfAnswers() {
            return this.numberOfAnswers;
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
    }
}
