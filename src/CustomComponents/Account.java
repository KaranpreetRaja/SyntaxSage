package CustomComponents;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import DB.DataBase;


public class Account{
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

    public Account(int ID) {
        DataBase database = new DataBase();
        database.connectToDataBase();
        String username = database.getUsername(ID);
        String[] accountInfo = database.getAccountInfo(username).split(", ");

        this.ID = ID;
        this.username = accountInfo[0];
        this.password = accountInfo[1];
        this.courses = accountInfo[2];
        this.experience = accountInfo[3];
        this.creationDate = accountInfo[4];
    }

    public static Account getAccount(int ID) {
        Account accountObject = new Account(ID);
        return accountObject;
    }

    public static void createAccount(String username, String password, String courses) {
        String accountCreationDate = (LocalDateTime.now()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        DataBase database = new DataBase(username, password, courses, "", accountCreationDate);
        database.connectToDataBase();
        database.addData();
    }

    public int signIn(String username, String password) {
        DataBase database = new DataBase();
        database.connectToDataBase();
        String[] usernameList = database.getAllUsernames().split(", ");
        for (int i = 0; i < usernameList.length(); i++) {
            if (username.equals(usernameList[i])) {
                if (password.equals(database.getPassword(usernameList[i]))) {
                    return database.getID(username);
                }
                else {
                    return -1;
                }
            }
        }
        return -1;
    }

    public int signUp(String username, String password, ArrayList<String> courses) {
        DataBase database = new DataBase();
        database.connectToDataBase();
        String[] usernameList = database.getAllUsernames().split(", ");
        for (int i = 0; i < usernameList.length; i++) {
            if (username.equals(usernameList[i])) {
                return -1;
            }
        }
        String courseString = ""
        for (int j = 0; j < courses.size(); j++){
            courseString = courseString + courses.get(j);
        }
        createAccount(username, password, courseString);
        return database.getID(username);
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
