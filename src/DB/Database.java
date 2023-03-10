package DB;

import java.sql.*;

/*
Update information
Add information
Delete Information
get information based upon given input usually id

NOTE: There must be a server hosted locally with a Database named syntaxsage. A table with

 */



public class Database implements DatabaseInterface {
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
    @Override
    public void connectToDatabase(){
        String url="jdbc:mysql://localhost:3306/project";
        String uname="rajendra";
        String passwordForDB="rajendra";
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
    @Override
    public void addData()  {
        try {
            String url = "jdbc:mysql://localhost:3306/project";
            String uname = "rajendra";
            String passwordForDB = "rajendra";
            Connection connection = DriverManager.getConnection(url, uname, passwordForDB);
            Statement statement = connection.createStatement();
           String query= String.format("insert into  syntaxsage (username,password,classes,experience,accountCreateDate) values ('%s','%s','%s','%s','%s')",this.username,this.password,this.classes,this.experience,this.accountCreateDate);
            boolean result = statement.execute(query);
        }
        catch (SQLException exception){
            System.out.println("SQL Exception in addData() method");
        }

    }

    @Override
    public void deleteDataById(int id)  {
        try {
            String url = "jdbc:mysql://localhost:3306/project";
            String uname = "rajendra";
            String passwordForDB = "rajendra";
            Connection connection = DriverManager.getConnection(url, uname, passwordForDB);
            Statement statement = connection.createStatement();
            String query= String.format("delete from  syntaxsage where id=%d",id);
            int resultSet = statement.executeUpdate(query);
        }
        catch (SQLException exception){
            System.out.println("SQL Exception in deleteDataById() method");
        }

    }

    @Override
    public int getID(String username) throws SQLException {
        ResultSet resultSet = null;
        int retID=0;
        try {
            String url = "jdbc:mysql://localhost:3306/project";
            String uname = "rajendra";
            String passwordForDB = "rajendra";
            Connection connection = DriverManager.getConnection(url, uname, passwordForDB);
            Statement statement = connection.createStatement();
            String query = String.format("select id  from syntaxsage where username='%s'", username);
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
            System.out.println("SQL Exception in getID(Argument username) method");
        }
        return  retID;

    }

    @Override
    public String getUsername(int id) throws SQLException {
        ResultSet resultSet = null;
        String retString="";
        try {
            String url = "jdbc:mysql://localhost:3306/project";
            String uname = "rajendra";
            String passwordForDB = "rajendra";
            Connection connection = DriverManager.getConnection(url, uname, passwordForDB);
            Statement statement = connection.createStatement();
            String query = String.format("select username  from syntaxsage where id=%d", id);
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

    @Override
    public String getPassword(int id) throws SQLException {
        ResultSet resultSet = null;
        String retString="";
        try {
            String url = "jdbc:mysql://localhost:3306/project";
            String uname = "rajendra";
            String passwordForDB = "rajendra";
            Connection connection = DriverManager.getConnection(url, uname, passwordForDB);
            Statement statement = connection.createStatement();
            String query = String.format("select password  from syntaxsage where id=%d", id);
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
            System.out.println("SQL Exception in getPassword(Argument username) method");
        }
        return  retString;

    }

    @Override
    public String getPassword(String username) throws SQLException {
        ResultSet resultSet = null;
        String retString = "";
        try {
            String url = "jdbc:mysql://localhost:3306/project";
            String uname = "rajendra";
            String passwordForDB = "rajendra";
            Connection connection = DriverManager.getConnection(url, uname, passwordForDB);
            Statement statement = connection.createStatement();
            String query = String.format("select password  from syntaxsage where username='%s'", username);
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

    @Override
    public String getAccountInfo(String username){
        String retString = "";
        try {
            String url = "jdbc:mysql://localhost:3306/project";
            String uname = "rajendra";
            String passwordForDB = "rajendra";
            Connection connection = DriverManager.getConnection(url, uname, passwordForDB);
            Statement statement = connection.createStatement();
            String query = String.format("select *  from syntaxsage where username='%s'", username);
           ResultSet resultSet = statement.executeQuery(query);
            if(resultSet==null) {
                System.out.println(" ResultSet null");
            }

            while(true){
                assert resultSet != null;
                if (!resultSet.next()) break;
                retString= resultSet.getInt(1) +", "+resultSet.getString(2)+", "+resultSet.getString(3)+", "+resultSet.getString(4)+", "+resultSet.getString(5)+", "+resultSet.getString(6);
            }
        } catch (SQLException exception) {
            System.out.println("SQL Exception in getID(Argument username) method");
        }
        return retString;
    }

    @Override
    public String getAllUsernames(){
        String retString = "";
        try {
            String url = "jdbc:mysql://localhost:3306/project";
            String uname = "rajendra";
            String passwordForDB = "rajendra";
            Connection connection = DriverManager.getConnection(url, uname, passwordForDB);
            Statement statement = connection.createStatement();
            String query = "select username from syntaxsage";
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
