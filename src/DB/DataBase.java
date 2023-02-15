package DB;

import java.sql.*;

/*
Update information
Add information
Delete Information
get information based upon given input usually id

NOTE: There must be a server hosted locally with a Database named syntaxsage. A table with

 */
public class DataBase {
    String username;
    String password;
    String classes;
    String experience;
    String accountCreateDate;


    //Constructor


    public DataBase( String username, String password, String classes, String experience, String accountCreateDate) {
        this.username = username;
        this.password = password;
        this.classes = classes;
        this.experience = experience;
        this.accountCreateDate = accountCreateDate;
    }
    //connect to database
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
           String query= String.format("insert into  syntaxsage (username,password,classes,experience,accountCreateDate) values ('%s','%s','%s','%s','%s')",this.username,this.password,this.classes,this.experience,this.accountCreateDate);
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
            String query= String.format("delete from  syntaxsage where id=%d",id);
            int resultSet = statement.executeUpdate(query);
        }
        catch (SQLException exception){
            System.out.println("SQL Exception in deleteDataById() method");
        }

    }
    public int getId(String Username) throws SQLException {
        ResultSet resultSet = null;
        int retID=0;
        try {
            String url = "jdbc:mysql://localhost:3306/project";
            String uname = "rajendra";
            String passwordForDB = "rajendra";
            Connection connection = DriverManager.getConnection(url, uname, passwordForDB);
            Statement statement = connection.createStatement();
            String query = String.format("select id  from syntaxsage where username='%s'", Username);
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
}
