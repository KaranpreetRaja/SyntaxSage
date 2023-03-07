package CustomComponents;

public class Badge {
    public int badgeID;
    public String badgeName;
    public Criteria criteria;

    public Badge(int badgeID, String badgeName, Criteria criteria) {
        this.badgeID = badgeID;
        this.badgeName = badgeName;
        this.criteria = criteria;
    }

    public String getBadgeName() {
        return this.badgeName;
    }

    public void setBadgeName(String newBadgeName) {
        this.badgeName = newBadgeName;
    }

    public int getBadgeID() {
        return this.badgeID;
    }

    public void setBadgeID(int newBadgeID) {
        this.badgeID = newBadgeID;
    }

    public Criteria getCriteria() {
        return this.criteria;
    }

    public void setCriteria(Criteria newCriteria) {
        this.criteria = newCriteria;
    }

    public void awardBadge() {
    }

}

class Criteria {
    public String criteriaName;
    public int criteriaID;

    public Criteria(String criteriaName, int criteriaID) {
        this.criteriaName = criteriaName;
        this.criteriaID = criteriaID;
    }

    public String getCriteriaName() {
        return this.criteriaName;
    }

    public void setCriteriaName(String newCriteriaName) {
        this.criteriaName = newCriteriaName;
    }

    public int getCriteriaID() {
        return this.criteriaID;
    }

    public void setCriteriaName(int newCriteriaID) {
        this.criteriaID = newCriteriaID;
    }

    // public int checkCriteria() {
    // }
}

class CourseCompleted extends Criteria {
    protected String course;
    protected boolean completetion = false;

    public CourseCompleted(String criteriaName, int criteriaID) {
        super(criteriaName, criteriaID);
    }

    public String getCourse() {
        return this.course;
    }

    public void setCourse(String newCourse) {
        this.course = newCourse;
    }

    public boolean getCompletetion() {
        return this.completetion;
    }
}

class FirstLessonCompleted extends Criteria {
    protected boolean completetion = false;

    public FirstLessonCompleted(String criteriaName, int criteriaID) {
        super(criteriaName, criteriaID);
    }

    public boolean getCompletetion() {
        return this.completetion;
    }
}

class NoMistakes extends Criteria {
    protected boolean completetion = false;

    public NoMistakes(String criteriaName, int criteriaID) {
        super(criteriaName, criteriaID);
    }

    public boolean getCompletetion() {
        return this.completetion;
    }
}