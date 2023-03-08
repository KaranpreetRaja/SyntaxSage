package DB;

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
    

}
