package CustomComponents;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import DB;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class Account{
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

    public Account(int ID) {
        DataBase database = new DataBase();
        database.connectToDatabase();
        String username = database.getUsername(ID);
        String[5] accountInfo = database.getAccountInfo(username).split(", ");

        this.username = accountInfo[0];
        this.password = accountInfo[1];
        this.courses = accountInfo[2];
        this.experience = accountInfo[3];
        this.creationDate = accountInfo[4];
    }

    public Account(String username, String password, String courses, String experience, String creationDate) {
        this.username = username;
        this.password = password;
        this.courses = courses;
        this.experience = experience;
        this.creationDate = creationDate;
    }

    //Static Factory Methods
    public static Account getAccount(int ID) {
        Account accountObject = new Account(ID);
        return accountObject;
}
    public static Account createAccount(String accountName, String accountPass, String courseString, String experience,
            String creationDate, int ID) {
        return new Account(accountName, accountPass, courseString, experience, creationDate, ID);
    }

    public static Account createAccount(String username, String password, String courses) {
        String accountCreationDate = (LocalDateTime.now()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        DataBase database = new DataBase(username, password, courses, "", accountCreationDate);
        database.connectToDatabase();
        database.addData();
        return Account.getAccount(database.getID(username));
    }

    //Logic Functions
    public Account signIn(String username, String password) throws AccountNotFoundException {
        //MySQL Database Sign in
        DataBase database = new DataBase();
        database.connectToDatabase();
        String[] usernameList = database.getAllUsernames().split(", ");
        for (int i = 0; i < usernameList.length(); i++) {
            if (username.equals(usernameList[i])) {
                if (password.equals(database.getPassword(usernameList[i]))) {
                    return Account.getAccount(database.getID(username));
                }
                else {
                    throw new AccountNotFoundException("");
                }
            }
        }
        throw new AccountNotFoundException("");
    }

    public Account signIn(String username, String password, ArrayList<Account> accountList) throws AccountNotFoundException {
        //Stub Database Sign in
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getUsername.equals(username)) {
                if (accountList.get(i).getPassword.equals(password)) {
                    return accountList.get(i);
                }
                else {
                    throw new AccountNotFoundException("");
                }
            }
        }
        throw new AccountNotFoundException("");
    }

    public Account signUp(String username, String password, ArrayList<String> courses) throws AccountSignUpException {
        //MySQL Database Sign Up
        DataBase database = new DataBase();
        database.connectToDatabase();
        String[] usernameList = database.getAllUsernames().split(", ");
        for (int i = 0; i < usernameList.length(); i++) {
            if (username.equals(usernameList[i])) {
                throw new AccountSignUpException("");
            }
        }
        String courseString = "";
        for (int j = 0; j < courses.size(); j++){
            courseString = courseString + courses.get(j) + ",";
        }
        Account myAccount = createAccount(username, password, courseString);
        return myAccount;
    }

    public Account signUp(String username, String password, ArrayList<String> courses, ArrayList<Account> accountList) throws AccountSignUpException {
        //Stub Database Sign Up
        for (int i = 0; i < accountList.size(); i++){
            if (accountList.get(i).getUsername == username){
                throw new AccountSignUpException("");
            }
        }

        String courseString = "";
        for (int j = 0; j < courses.size(); j++){
            courseString = courseString + courses.get(j) + ",";
        }

        Account myAccount = createAccount(username, password, courseString);
        accountList.add(myAccount);
        return myAccount;
    }


    //Getters
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


    //Setters
    public void setUsername(String newUsername) throws AccountUsernameException{
        DataBase database = new DataBase();
        database.connectToDatabase();
        String[] usernameList = database.getAllUsernames().split(", ");
        for (int i = 0; i < usernameList.length(); i++) {
            if (username.equals(usernameList[i])) {
                throw new AccountUsernameException("");
            }
        }
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


    //Initialization Functions
    public static ArrayList<Account> extractAccountList() {
        try {
        ArrayList<Account> accountList = new ArrayList<Account>();
        File accountFile = new File("Account.txt");
        Scanner accountScanner = new Scanner(accountFile);
        while (accountScanner.hasNextLine()) {
            String accountDetails = accountScanner.nextLine();
            String[] accountDetailArray = accountDetails.split("!");
            accountList.add(new Account(accountDetailArray[0], accountDetailArray[1], accountDetailArray[2], accountDetailArray[3], accountDetailArray[4]));
        }
        accountScanner.close();
        return accountList;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<Account>();
        }
    }


}
