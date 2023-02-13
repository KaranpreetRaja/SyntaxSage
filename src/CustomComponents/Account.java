import java.util.ArrayList;

class Account {

    private String accountName;
    private String accountPass;
    private int ID;
    private ArrayList<String> classes;
    public static int curID = 0;

    //
    public Account() {
        this.accountName = "";
        this.accountPass = "";
        this.ID = curID;
        curID++;
        this.classes = new ArrayList<String>();
    }

    public Account(String accountName, String accountPass) {
        this.accountName = accountName;
        this.accountPass = accountPass;
        this.ID = curID;
        curID++;
        this.classes = new ArrayList<String>();
    }

    public static Account createAccount(String accountName, String accountPass) {
        Account newAccount = new Account(accountName, accountPass);
        return newAccount;
    }

    public String getUsername() {
        return this.accountName;
    }

    public int ID() {
        return this.ID;
    }

    private void setUsername(String newUsername) {
        this.accountName = newUsername;
    }

    private void setPassword(String newPassword) {
        this.accountPass = newPassword;
    }

    public ArrayList<String> getClasses() {
        return this.classes;
    }

    private void enrollClasses(String newClass) {
        // Check if Language exists in database first
        this.classes.add(newClass);
    }

    private void unenrollClasses(String oldClass) {
        if (this.classes.contains(oldClass)) {
            this.classes.remove(oldClass);
        }
    }

}