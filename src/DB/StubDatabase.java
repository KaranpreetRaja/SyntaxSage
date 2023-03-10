package DB;

public class StubDatabase implements DatabaseInterface {
    @Override
    public void connectToDatabase() {
        // This is just a stub method and does nothing in this class
    }

    @Override
    public void addData() {
        // This is just a stub method and does nothing in this class
    }

    @Override
    public void deleteDataById(int id) {
        // This is just a stub method and does nothing in this class
    }

    @Override
    public int getID(String username) {
        // This is just a stub method and returns a dummy value of 0 in this class
        return 0;
    }

    @Override
    public String getUsername(int id) {
        // This is just a stub method and returns a dummy value of an empty string in this class
        return "";
    }

    @Override
    public String getPassword(int id) {
        // This is just a stub method and returns a dummy value of an empty string in this class
        return "";
    }

    @Override
    public String getPassword(String username) {
        // This is just a stub method and returns a dummy value of an empty string in this class
        return "";
    }

    @Override
    public String getAccountInfo(String username) {
        return null;
    }

    @Override
    public String getAllUsernames() {
        return null;
    }
}
