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

    //Class Attributes
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
    }

    public Account(String username, String password, String courses, String experience, String creationDate) {
        this.username = username;
        this.password = password;
        this.courses = courses;
        this.experience = experiences;
        this.creationDate = creationDate;
    }

    public static Account createAccount(String accountName, String accountPass, String courseString, String experience, String creationDate) {
        
        Account newAccount = new Account(accountName, accountPass, courseString, experience, creationDate);
        return newAccount;
    }

    public static int signIn(String username, String password, ArrayList<Account> accountList) {
        for (int i = 0; i < accountList.size(), i++) {
            if (Objects.equals(account.get(i).getName(), username)) {
                if (Objects.equals(account.get(i).getPassword(), password)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static int signUp(String username, String password, ArrayList<Account> accountList, ArrayList<String> courses) {
        for (int i = 0; i < accountList.size(), i++) {
            if (Objects.equals(account.get(i).getName(), username)) {
                return -1;
            }
        }
        String courseString = "";
        for (int j = 0; j < courses.size(); j++){
            courseString = courseString + courses.get(j);
        }
        String accountCreationDate = (LocalDateTime.now()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Account newAccount = createAccount(username, password, courses, "", accountCreationDate);
        accountList.add(newAccount);
        return accountList.size();
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
