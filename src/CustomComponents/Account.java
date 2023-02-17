import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Account{
    public String username;
    public String password;
    public String courses;
    public String experience;
    public String creationDate;

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

    public static Account getAccount(int ID) {
        Account accountObject = new Account(ID);
        return accountObject;
    }

    public static void createAccount(String username, String password, String courses) {
        String accountCreationDate = (LocalDateTime.now()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        DataBase database = new DataBase(username, password, courses, "", accountCreationDate);
        database.connectToDatabase();
        database.addData();
    }

    public int signIn(String username, String password) {
        DataBase database = new DataBase();
        database.connectToDatabase();
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
        database.connectToDatabase();
        String[] usernameList = database.getAllUsernames().split(", ");
        for (int i = 0; i < usernameList.length(); i++) {
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
}
