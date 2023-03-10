package DB;

import java.sql.SQLException;

public interface DatabaseInterface {
    void connectToDatabase();
    void addData();
    void deleteDataById(int id);
    int getID(String username) throws SQLException;
    String getUsername(int id) throws SQLException;
    String getPassword(int id) throws SQLException;
    String getPassword(String username) throws SQLException;
    String getAccountInfo(String username);
    String getAllUsernames();

}
