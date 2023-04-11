package CustomComponents;

import java.sql.*;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import DB.Database;

public class Account {
    private String username;
    private String password;
    private String courses;
    private String experience;
    private String creationDate;
    private String currentCourse;
    private int streaks;

    public Account() {
        this.username = "";
        this.password = "";
        this.courses = "";
        this.experience = "";
        this.creationDate = "";
    }

    public Account(int ID) {
        try {
            Database database = new Database();
            database.connectToDatabase();
            String username;
            username = database.getUsername(ID);
            String[] accountInfo = database.getAccountInfo(username).split(", ");

            this.username = accountInfo[0];
            this.password = accountInfo[1];
            this.courses = accountInfo[2];
            this.experience = accountInfo[3];
            this.creationDate = accountInfo[4];
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
        return new Account(ID);
    }

    public static Account createAccount(String accountName, String accountPass, String courseString, String experience, String creationDate, int ID) {
        return new Account(accountName, accountPass, courseString, experience, creationDate);
    }

    public static Account createAccount(String username, String password, String courses) {
        String accountCreationDate = (LocalDateTime.now()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Database database = new Database(username, password, courses, "", accountCreationDate);
        database.connectToDatabase();
        database.addData();
        try {
            return Account.getAccount(database.getID(username));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    //Logic Functions
    public static Account signIn(String username, String password) throws AccountNotFoundException, SQLException {
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

    public static Account signIn(String username, String password, ArrayList<Account> accountList) throws AccountNotFoundException {
        //Stub Database Sign in
        for (Account account : accountList) {
            if (account.getUsername().equals(username)) {
                if (account.getPassword().equals(password)) {
                    return account;
                } else {
                    throw new AccountNotFoundException("");
                }
            }
        }
        throw new AccountNotFoundException("");
    }

    public static Account signUp(String username, String password, ArrayList<String> courses) throws AccountSignUpException {
        //MySQL Database Sign Up
        Database database = new Database();
        database.connectToDatabase();
        String[] usernameList = database.getAllUsernames().split(", ");
        for (String s : usernameList) {
            if (username.equals(s)) {
                throw new AccountSignUpException("");
            }
        }
        StringBuilder courseString = new StringBuilder();
        for (String course : courses) {
            courseString.append(course).append(",");
        }
        return createAccount(username, password, courseString.toString());
    }

    public static Account signUp(String username, String password, ArrayList<String> courses, ArrayList<Account> accountList) throws AccountSignUpException {
        //Stub Database Sign Up
        for (Account account : accountList) {
            if (Objects.equals(account.getUsername(), username)) {
                throw new AccountSignUpException("");
            }
        }

        StringBuilder courseString = new StringBuilder();
        for (String course : courses) {
            courseString.append(course).append(",");
        }

        Account myAccount = createAccount(username, password, courseString.toString());
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

    public String getCreationDate() {
        return this.creationDate;
    }


    //Setters
    public void setUsername(String newUsername) throws AccountUsernameException {
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
        try {
            String url = "jdbc:mysql://140.238.154.147:3306/project";
            String sqlUsername = "user";
            String sqlPassword = "Eecs2311!";
            Connection connection = DriverManager.getConnection(url, sqlUsername, sqlPassword);

            String query = "UPDATE account SET experience = ? WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, newExperience);
            statement.setString(2, this.username);
            statement.executeUpdate();
            statement.close();
            this.experience = newExperience;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getExperience() {
        try {
            String url = "jdbc:mysql://140.238.154.147:3306/project";
            String sqlUsername = "user";
            String sqlPassword = "Eecs2311!";
            Connection connection = DriverManager.getConnection(url, sqlUsername, sqlPassword);

            String query = "SELECT experience FROM account WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, this.username);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                this.experience = rs.getString("experience");
            }
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.experience;
    }

    public static ArrayList<Account> extractAccountList() {
        ArrayList<Account> accountList = new ArrayList<>();
        try {
            File accountFile = new File("Account.txt");
            Scanner accountScanner = new Scanner(accountFile);
            while (accountScanner.hasNextLine()) {
                String accountDetails = accountScanner.nextLine();
                String[] accountDetailArray = accountDetails.split("!");
                if (accountDetailArray.length == 5) { // Make sure there are 5 elements in the array
                    Account account = new Account(accountDetailArray[0], accountDetailArray[1], accountDetailArray[2], accountDetailArray[3], accountDetailArray[4]);
                    accountList.add(account);
                } else {
                    System.out.println("Invalid account details: " + accountDetails);
                }
            }
            accountScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: Account file not found.");
            e.printStackTrace();
        }
        return accountList;
    }

    public String currentCourse() throws SQLException {
        String url = "jdbc:mysql://140.238.154.147:3306/project";
        String sqlUsername = "user";
        String sqlPassword = "Eecs2311!";
        Connection connection = DriverManager.getConnection(url, sqlUsername, sqlPassword);
        
        String query = "SELECT classes FROM account WHERE username = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, this.username);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            this.currentCourse = rs.getString("classes");
        }
        statement.close();
        return this.currentCourse;
    }
    
    public int getStreaks() {
        return this.streaks;
    }
    
    
    public void setStreaks() {
        Database database = new Database();
        database.connectToDatabase();
        String previousLoginDate = database.getLastLogin(this.username);
        int streakAmount = (int) database.getStreak(this.username);
        String newLoginDate = ((LocalDateTime.now()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).substring(0, 9));
        if (newLoginDate != previousLoginDate){
            streakAmount += 1;
            this.streaks = streakAmount;
            database.updateStreak(this.username, streakAmount);
            database.updateLastLogin(this.username, newLoginDate);
        }
        else {
            this.streaks = streakAmount;
        }
    }
}