package DB;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * 
 * +-------------------+--------------+------+-----+---------+----------------+
| Field             | Type         | Null | Key | Default | Extra          |
+-------------------+--------------+------+-----+---------+----------------+
| id                | int          | NO   | PRI | NULL    | 
| username          | varchar(50)  | YES  |     | NULL    |                |
| password          | varchar(50)  | YES  |     | NULL    |                |
| classes           | varchar(700) | YES  |     | NULL    |                |
| experience        | varchar(100) | YES  |     | NULL    |                |
| accountCreateDate | varchar(25)  | YES  |     | NULL    |                |
+-------------------+--------------+------+-----+---------+----------------+
 */
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


    public void addData()  {
        try {
            String url = "jdbc:mysql://localhost:3306/project";
            String uname = "rajendra";
            String passwordForDB = "rajendra";
            Connection connection = DriverManager.getConnection(url, uname, passwordForDB);
            Statement statement = connection.createStatement();
            String query= String.format("insert into  account  values ('%d','%s','%s','%s','%s','%s')",this.ID,this.username,this.password,this.courses,this.experience,this.creationDate);
            boolean result = statement.execute(query);
        }
        catch (SQLException exception){
            System.out.println("SQL Exception in addData() method");
        }

    }
    public void deleteDataById(int id)  {
        try {
            String url = "jdbc:mysql://localhost:3306/project";
            String uname = "rajendra";
            String passwordForDB = "rajendra";
            Connection connection = DriverManager.getConnection(url, uname, passwordForDB);
            Statement statement = connection.createStatement();
            String query= String.format("delete from  account where id=%d",id);
            int resultSet = statement.executeUpdate(query);
        }
        catch (SQLException exception){
            System.out.println("SQL Exception in deleteDataById() method");
        }

    }

    public void deleteDataByUsername(String Username)  {
        try {
            String url = "jdbc:mysql://localhost:3306/project";
            String uname = "rajendra";
            String passwordForDB = "rajendra";
            Connection connection = DriverManager.getConnection(url, uname, passwordForDB);
            Statement statement = connection.createStatement();
            String query= String.format("delete from  account where username='%s'",Username);
            int resultSet = statement.executeUpdate(query);
        }
        catch (SQLException exception){
            System.out.println("SQL Exception in deleteDataByUsername() method");
        }

    }
    public String getPassword(int id) throws SQLException {
        ResultSet resultSet = null;
        String retString="";
        try {
            String url = "jdbc:mysql://localhost:3306/project";
            String uname = "rajendra";
            String passwordForDB = "rajendra";
            Connection connection = DriverManager.getConnection(url, uname, passwordForDB);
            Statement statement = connection.createStatement();
            String query = String.format("select password  from account where id=%d", id);
            resultSet = statement.executeQuery(query);
            if(resultSet==null) {
                System.out.println("null");
            }

            while(resultSet.next()){
                retString=resultSet.getString(1);
            }
        } catch (SQLException exception) {
            System.out.println("SQL Exception in getPassword(Argument Username) method");
        }
        return  retString;

    }

    
   
}
