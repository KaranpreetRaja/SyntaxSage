package CustomComponents;

import DB.Database;

import java.sql.SQLException;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Account {
    private int ID;
    private String username;
    private String password;
    private String courses;
    private String experience;
    private String creationDate;

    public Account() {
        this.ID = -1;
        this.username = "";
        this.password = "";
        this.courses = "";
        this.experience = "";
        this.creationDate = "";
    }

    public Account(int ID) throws SQLException {
        Database database = new Database();
        database.connectToDatabase();
        String username = database.getUsername(ID);
        String[] accountInfo = database.getAccountInfo(username).split(", ");

        this.ID = ID;
        this.username = accountInfo[0];
        this.password = accountInfo[1];
        this.courses = accountInfo[2];
        this.experience = accountInfo[3];
        this.creationDate = accountInfo[4];
    }

    public static Account getAccount(int ID) throws SQLException {
        return new Account(ID);
    }

    public static void createAccount(String username, String password, String courses) {
        String accountCreationDate = (LocalDateTime.now()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Database database = new Database(username, password, courses, "", accountCreationDate);
        database.connectToDatabase();
        database.addData();
    }

    public static int signIn(String username, String password) throws SQLException {
        Database database = new Database();
        database.connectToDatabase();
        String[] usernameList = database.getAllUsernames().split(", ");
        for (String s : usernameList) {
            if (username.equals(s)) {
                if (password.equals(database.getPassword(s))) {
                    return database.getID(username);
                } else {
                    return -1;
                }
            }
        }
        return -1;
    }

    public int signUp(String username, String password, ArrayList<String> courses) throws SQLException {
        Database database = new Database();
        database.connectToDatabase();
        String[] usernameList = database.getAllUsernames().split(", ");
        for (String s : usernameList) {
            if (username.equals(s)) {
                return -1;
            }
        }
        String courseString = "";
        for (String course : courses) {
            courseString = courseString + course;
        }
        createAccount(username, password, courseString);
        return database.getID(username);
    }

    public Account getAccount() {
        return this;
    }

    public int getID() {
        return this.ID;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getCourses() {
        return this.courses;
    }

    public String getExperience() {
        return this.experience;
    }

    public String getCreationDate() {
        return this.creationDate;
    }

    public void setUsername(String newUsername) {
        this.username = newUsername;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public void setCourses(String newCourses) {
        this.courses = newCourses;
    }

    public void setExperience(String newExperience) {
        this.experience = newExperience;
    }

    public void setCreationDate(String newDate) {
        this.creationDate = newDate;
    }
}
