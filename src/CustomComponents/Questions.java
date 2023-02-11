package CustomComponents;

public class Questions {
    public int id;
    public static int curId = 0;
    public String prompt;
    public int noAns;

    public Questions(String prompt, int noAns) {
        this.id = curId;
        curId++;
        this.prompt = prompt;
        this.noAns = noAns;
    }

    public Questions() {
        this.id = curId;
        curId++;
        this.prompt = "Default";
        this.noAns = 0;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getPrompt() {
        return this.prompt;
    }

}
