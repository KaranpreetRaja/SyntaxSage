import java.sql.*;


/*
+----------------+---------------+------+-----+---------+-------+
        | Field          | Type          | Null | Key | Default | Extra |
        +----------------+---------------+------+-----+---------+-------+
        | id             | int           | NO   | PRI | NULL    |       |
        | countOfStreaks | int           | YES  |     | NULL    |       |
        | date           | varchar(10)   | YES  |     | NULL    |       |
        +----------------+---------------+------+-----+---------+-------+

        // TODO The date should be of the format YYYY-DD-MM  dashes are mandatory

 */
public class StreakDB {




    //Constructor -Empty
    public StreakDB(){

    }

  

    //connect to database
    public void connectToDataBase(){
        String url="jdbc:mysql://localhost:3306/project";
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
      public void addData(int count , String date)  {
        try {
            String url = "jdbc:mysql://localhost:3306/project";
            String uname = "rajendra";
            String passwordForDB = "rajendra";
            Connection connection = DriverManager.getConnection(url, uname, passwordForDB);
            Statement statement = connection.createStatement();
           String query= String.format("insert into  streaks (countOfStreaks,date) values ('%d','%s');",count,date);
            boolean result = statement.execute(query);
        }
        catch (SQLException exception){
            System.out.println("SQL Exception in addData() method");
        }

    }
}