package CustomComponents;

public class Question {
    private int id;
    private static int CUR_ID = 0;
    private int noAns;
    private String prompt;

    // Constructor

    public Question(int noAns, String prompt) {
        this.id = CUR_ID;
        CUR_ID++;
        this.noAns = noAns;
        this.prompt = prompt;
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
}
