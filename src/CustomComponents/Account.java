package CustomComponents;

//Imports
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.Objects;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Account {

    // Class Attributes
    private int ID;
    private String username;
    private String password;
    private String courses;
    private String experience;
    private String creationDate;

    public Account() {
        this.username = "";
        this.password = "";
        this.courses = "";
        this.experience = "";
        this.creationDate = "";
        this.ID = -1;
    }

    public Account(String username, String password, String courses, String experience, String creationDate, int ID) {
        this.username = username;
        this.password = password;
        this.courses = courses;
        this.experience = experience;
        this.creationDate = creationDate;
        this.ID = ID;
    }

    public static Account createAccount(String accountName, String accountPass, String courseString, String experience,
            String creationDate, int ID) {
        Account newAccount = new Account(accountName, accountPass, courseString, experience, creationDate, ID);
        return newAccount;
    }

    public static int signIn(String username, String password, ArrayList<Account> accountList) {
        for (int i = 0; i < accountList.size(); i++) {
            if (Objects.equals(accountList.get(i).getUsername(), username)) {
                if (Objects.equals(accountList.get(i).getPassword(), password)) {
                    return i+1;
                }
            }
        }
        return -1;
    }

    public static int signUp(String username, String password, ArrayList<Account> accountList,
            ArrayList<String> courses) {
        for (int i = 0; i < accountList.size(); i++) {
            if (Objects.equals(accountList.get(i).getUsername(), username)) {
                return -1;
            }
        }
        String courseString = "";
        for (int j = 0; j < courses.size(); j++) {
            courseString = courseString + courses.get(j);
        }
        String accountCreationDate = (LocalDateTime.now()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        int ID = accountList.size() + 1;
        Account newAccount = Account.createAccount(username, password, courseString, "", accountCreationDate, ID);
        accountList.add(newAccount);
        return accountList.size();
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
