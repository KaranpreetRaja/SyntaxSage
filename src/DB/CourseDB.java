package DB;
import java.sql.*;


public class CourseDB {
    int courseId;
    String courseName;
    int noLessons;
    public CourseDB(){

    }

    public CourseDB(int courseId, String courseName, int noLessons) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.noLessons = noLessons;
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
            String query= String.format("insert into  courses values ('%d','%s','%d')",this.courseId,this.courseName,this.noLessons);
            boolean result = statement.execute(query);
        }
        catch (SQLException exception){
            System.out.println("SQL Exception in addData() method");
        }

    }
    public void deleteDataByCourseId(int id)  {
        try {
            String url = "jdbc:mysql://localhost:3306/project";
            String uname = "rajendra";
            String passwordForDB = "rajendra";
            Connection connection = DriverManager.getConnection(url, uname, passwordForDB);
            Statement statement = connection.createStatement();
            String query= String.format("delete from  courses where courseId=%d",id);
            int resultSet = statement.executeUpdate(query);
        }
        catch (SQLException exception){
            System.out.println("SQL Exception in deleteDataById() method");
        }

    }


}
