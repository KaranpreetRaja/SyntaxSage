package CustomComponents;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import DB.*;

import java.util.Objects;
import java.util.Scanner;
import java.io.File;


public class Account {
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

    public Account(int ID) throws SQLException {
        Database database = new Database();
        database.connectToDatabase();
        String username = database.getUsername(ID);
        String accountData = database.getAccountInfo(username);
        String[] accountInfo = accountData.split(",");

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

    public Account(String accountName, String accountPass, String courseString, String experience, String creationDate, int id) {
    }

    //Static Factory Methods
    public static Account getAccount(int ID) throws SQLException {
        return new Account(ID);
}
    public static Account createAccount(String accountName, String accountPass, String courseString, String experience,
            String creationDate, int ID) {
        return new Account(accountName, accountPass, courseString, experience, creationDate, ID);
    }

    public static Account createAccount(String username, String password, String courses) throws SQLException {
        String accountCreationDate = (LocalDateTime.now()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Database database = new Database(username, password, courses, "", accountCreationDate);
        database.connectToDatabase();
        database.addData();
        return Account.getAccount(database.getID(username));
    }

    //Logic Functions
    public Account signIn(String username, String password) throws AccountNotFoundException, SQLException {
        //MySQL Database Sign in
        Database database = new Database();
        database.connectToDatabase();
        String[] usernameList = database.getAllUsernames().split(", ");
        for (String s : usernameList) {
            if (username.equals(s)) {
                if (password.equals(database.getPassword(s))) {
                    return Account.getAccount(database.getID(username));
                } else {
                    throw new AccountNotFoundException("");
                }
            }
        }
        throw new AccountNotFoundException("");
    }

    public Account signIn(String username, String password, ArrayList<Account> accountList) throws AccountNotFoundException {
        //Stub Database Sign in
        for (Account account : accountList) {
            if (Objects.equals(account.username, username)) {
                if (account.username.equals(password)) {
                    return account;
                } else {
                    throw new AccountNotFoundException("");
                }
            }
        }
        throw new AccountNotFoundException("");
    }

    public Account signUp(String username, String password, ArrayList<String> courses) throws AccountSignUpException, SQLException {
        //MySQL Database Sign Up
        Database database = new Database();
        database.connectToDatabase();
        String[] usernameList = database.getAllUsernames().split(", ");
        for (String s : usernameList) {
            if (username.equals(s)) {
                throw new AccountSignUpException("");
            }
        }
        String courseString = "";
        for (String course : courses) {
            courseString = courseString + course + ",";
        }
        return createAccount(username, password, courseString);
    }

    public Account signUp(String username, String password, ArrayList<String> courses, ArrayList<Account> accountList) throws AccountSignUpException, SQLException {
        //Stub Database Sign Up
        for (Account account : accountList) {
            if (Objects.equals(account.username, username)) {
                throw new AccountSignUpException("");
            }
        }

        String courseString = "";
        for (String course : courses) {
            courseString = courseString + course + ",";
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
        Database database = new Database();
        database.connectToDatabase();
        String[] usernameList = database.getAllUsernames().split(", ");
        for (String s : usernameList) {
            if (username.equals(s)) {
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
    public ArrayList<Account> extractAccountList() {
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
