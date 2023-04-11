package DB;

import java.sql.*;
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
        String url = "jdbc:mysql://140.238.154.147:3306/project";
        String uname = "user";
        String passwordForDB = "Eecs2311!";
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
            String url = "jdbc:mysql://140.238.154.147:3306/project";
            String uname = "user";
            String passwordForDB = "Eecs2311!";
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
            String url = "jdbc:mysql://140.238.154.147:3306/project";
            String uname = "user";
            String passwordForDB = "Eecs2311!";
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
            String url = "jdbc:mysql://140.238.154.147:3306/project";
            String uname = "user";
            String passwordForDB = "Eecs2311!";
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
            String url = "jdbc:mysql://140.238.154.147:3306/project";
            String uname = "user";
            String passwordForDB = "Eecs2311!";
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
    public String getUsername(int id) throws SQLException {
        ResultSet resultSet = null;
        String retString="";
        try {
            String url = "jdbc:mysql://140.238.154.147:3306/project";
            String uname = "user";
            String passwordForDB = "Eecs2311!";
            Connection connection = DriverManager.getConnection(url, uname, passwordForDB);
            Statement statement = connection.createStatement();
            String query = String.format("select username  from account where id=%d", id);
            resultSet = statement.executeQuery(query);
            if(resultSet==null) {
                System.out.println("null");
            }

            while(resultSet.next()){
                retString=resultSet.getString(1);
            }
        } catch (SQLException exception) {
            System.out.println("SQL Exception in getUsername(Argument Username) method");
        }
        return  retString;

    }
    public int getId(String Username) throws SQLException {
        ResultSet resultSet = null;
        int retID=0;
        try {
            String url = "jdbc:mysql://140.238.154.147:3306/project";
            String uname = "user";
            String passwordForDB = "Eecs2311!";
            Connection connection = DriverManager.getConnection(url, uname, passwordForDB);
            Statement statement = connection.createStatement();
            String query = String.format("select id  from account where username='%s'", Username);
            resultSet = statement.executeQuery(query);
            if(resultSet==null) {
                System.out.println("null");
            }

            while(resultSet.next()){
                retID=resultSet.getInt(1);
            }
        } catch (SQLException exception) {
            System.out.println("SQL Exception in getID(Argument Username) method");
        }
        return  retID;

    }
    public String getLastLogin(String username){
        ResultSet resultSet=null;
        String str="";

        try {
            String url = "jdbc:mysql://localhost:3306/project";
            String uname = "rajendra";
            String passwordForDB = "rajendra";
            Connection connection = DriverManager.getConnection(url, uname, passwordForDB);
            Statement statement = connection.createStatement();
            String query= String.format("select accountCreateDate from account where username = '%s';",username);
            resultSet = statement.executeQuery(query);
            if(resultSet==null){
                return str;
            }
            else{
                while(resultSet.next()){
//                return Integer.toString(resultSet.getInt(1));
//                System.out.println(resultSet.getInt(1));
                    return resultSet.getString(1);
//                    System.out.println(resultSet.getString(1));
                }
            }
        }
        catch (SQLException exception){
            System.out.println("SQL Exception in lastlogin() method");
        }
        return str;
    }

    
   
}
