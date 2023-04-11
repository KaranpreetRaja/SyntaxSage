package DB;

import java.sql.*;

/*
Update information
Add information
Delete Information
get information based upon given input usually id
 */

public class Database {

    String username;
    String password;
    String classes;
    String experience;
    String accountCreateDate;


    //Constructor

    public Database() {
        this.username = "";
        this.password = "";
        this.classes = "";
        this.experience = "";
        this.accountCreateDate = "";
    }

    public Database( String username, String password, String classes, String experience, String accountCreateDate) {
        this.username = username;
        this.password = password;
        this.classes = classes;
        this.experience = experience;
        this.accountCreateDate = accountCreateDate;
    }

    //connect to database
    public void connectToDatabase(){
        String url = "jdbc:mysql://140.238.154.147:3306/project";
        String uname = "user";
        String passwordForDB="Eecs2311!";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Found.");
            Connection connection = DriverManager.getConnection(url, uname, passwordForDB);


        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void addData()  {
        try {
            String url = "jdbc:mysql://140.238.154.147:3306/project";
            String uname = "user";
            String passwordForDB="Eecs2311!";
            Connection connection = DriverManager.getConnection(url, uname, passwordForDB);
            Statement statement = connection.createStatement();
            String query= String.format("insert into account (username,password,classes,experience,accountCreateDate) values ('%s','%s','%s','%s','%s')",this.username,this.password,this.classes,this.experience,this.accountCreateDate);
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
            String query= String.format("delete from account where id=%d",id);
            int resultSet = statement.executeUpdate(query);
        }
        catch (SQLException exception){
            System.out.println("SQL Exception in deleteDataById() method");
        }

    }
    public int getID(String Username) throws SQLException {
        ResultSet resultSet = null;
        int retID = 0;
        try {
            String url = "jdbc:mysql://140.238.154.147:3306/project";
            String uname = "user";
            String passwordForDB = "Eecs2311!";
            Connection connection = DriverManager.getConnection(url, uname, passwordForDB);
            Statement statement = connection.createStatement();
            String query = String.format("select id from account where username='%s'", username);
             resultSet = statement.executeQuery(query);
             if(resultSet==null) {
                 System.out.println("null");
             }

             while(true){
                 assert resultSet != null;
                 if (!resultSet.next()) break;
                 retID=resultSet.getInt(1);
             }
        } catch (SQLException exception) {
            System.out.println("SQL Exception in getID(Argument Username) method");
        }
        return  retID;

    }
    public String getUsername(int id) throws SQLException {
        ResultSet resultSet = null;
        String retString = "";
        try {
            String url = "jdbc:mysql://140.238.154.147:3306/project";
            String uname = "user";
            String passwordForDB = "Eecs2311!";
            Connection connection = DriverManager.getConnection(url, uname, passwordForDB);
            Statement statement = connection.createStatement();
            String query = String.format("select username from account where id=%d", id);
            resultSet = statement.executeQuery(query);
            if(resultSet==null) {
                System.out.println("null");
            }

            while(true){
                assert resultSet != null;
                if (!resultSet.next()) break;
                retString=resultSet.getString(1);
            }
        } catch (SQLException exception) {
            System.out.println("SQL Exception in getUsername(Argument Username) method");
        }
        return  retString;

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
            String query = String.format("select password from account where id=%d", id);
            resultSet = statement.executeQuery(query);
            if(resultSet==null) {
                System.out.println("null");
            }

            while(true){
                assert resultSet != null;
                if (!resultSet.next()) break;
                retString=resultSet.getString(1);
            }
        } catch (SQLException exception) {
            System.out.println("SQL Exception in getPassword(Argument Username) method");
        }
        return  retString;

    }
    public String getPassword(String Username) throws SQLException {
        ResultSet resultSet = null;
        String retString = "";
        try {
            String url = "jdbc:mysql://140.238.154.147:3306/project";
            String uname = "user";
            String passwordForDB = "Eecs2311!";
            Connection connection = DriverManager.getConnection(url, uname, passwordForDB);
            Statement statement = connection.createStatement();
            String query = String.format("select password from account where username='%s'", username);
            resultSet = statement.executeQuery(query);
            if(resultSet == null) {
                System.out.println("null");
            }

            while(true){
                assert resultSet != null;
                if (!resultSet.next()) break;
                retString=resultSet.getString(1);
            }
        } catch (SQLException exception) {
            System.out.println("SQL Exception in getPassword(String Username) method");
        }
        return retString;

    }

    public String getAccountInfo(String Username){
        String retString = "";
        try {
            String url = "jdbc:mysql://140.238.154.147:3306/project";
            String uname = "user";
            String passwordForDB = "Eecs2311!";
            Connection connection = DriverManager.getConnection(url, uname, passwordForDB);
            Statement statement = connection.createStatement();
            String query = String.format("select * from account where username='%s'", username);
            ResultSet resultSet = statement.executeQuery(query);
            if(resultSet==null) {
                System.out.println(" ResultSet null");
            }

            while(true){
                assert resultSet != null;
                if (!resultSet.next()) break;
                retString= String.format("%s, %s, %s, %s, %s, %s", resultSet.getInt(1), resultSet.getString(2) , resultSet.getString(3) , resultSet.getString(4), resultSet.getString(5), resultSet.getString(6));
            }
        } catch (SQLException exception) {
            System.out.println("SQL Exception in getID(Argument Username) method");
        }
        return retString;
    }

    public String getAllUsernames(){
        String retString = "";
        try {
            String url = "jdbc:mysql://140.238.154.147:3306/project";
            String uname = "user";
            String passwordForDB = "Eecs2311!";
            Connection connection = DriverManager.getConnection(url, uname, passwordForDB);
            Statement statement = connection.createStatement();
            String query = "select username from account";
            ResultSet resultSet = statement.executeQuery(query);
            if(resultSet==null) {
                System.out.println(" ResultSet null");
            }
            int i=1;
            while(true){
                assert resultSet != null;
                if (!resultSet.next()) break;

                retString += resultSet.getString(1)+", ";
            }
            retString=retString.substring(0,retString.length()-2);
        } catch (SQLException exception) {
            System.out.println("SQL Exception in getAllUsernames() method");
        }
        return retString;
    }

}