package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccountDB {
    private int ID;
    private String username;
    private String password;
    private String courses;
    private String experience;
    private String creationDate;
    
    public AccountDB(){

    }


    public AccountDB(int ID, String username, String password, String courses, String experience, String creationDate) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.courses = courses;
        this.experience = experience;
        this.creationDate = creationDate;
    }
    public void connectToDataBase(){
        String url="jdbc:mysql://localhost:3306/project";
        String uname="rajendra";
        String passwordForDB="rajendra";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Found.");
            Connection connection = DriverManager.getConnection(url, uname, passwordForDB);


        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
   
}
