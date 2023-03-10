package CustomComponents;

public class ProgressBar {
    private int numLessons; // Number of Lessons
    private int numLessonsCompleted; // Number of Lessons Completed

    public ProgressBar(int numLessonsCompleted, int numLessons) {
        this.numLessons = numLessons;
        this.numLessonsCompleted = numLessonsCompleted;
    }

    public int getNumLessons() {
        return numLessons;
    }

    public void setNumLessons(int numLessons) {
        this.numLessons = numLessons;
    }

    public int getNumLessonsCompleted() {
        return numLessonsCompleted;
    }

    public void setNumLessonsCompleted(int numLessonsCompleted) {
        this.numLessonsCompleted = numLessonsCompleted;
    }

    public int getProgress() {
        return (int) (((double) numLessonsCompleted / numLessons) * 100);
    }

    public void setProgress(int numLessonsCompleted) {
        this.numLessonsCompleted = numLessonsCompleted;
    }

}
