//Imports
import java.util.ArrayList;

/**
* Account Class
* Keeps track of personal details relating to the account
* @author Ryan Lyn
*/
class Account {

    //Class Attributes
    private String accountName;
    private String accountPass;
    private int ID;
    private ArrayList<codeLang> langList;
    public static int curID = 0;

    /**
    * Default Constructor for Account Object
    */
    public Account() {
        this.accountName = "";
        this.accountPass = "";
        this.ID = curID;
        curID++;
        this.langList = new ArrayList<codeLang>();
    }

    /**
    * Overloaded Constructor for Account Object
    * @param accountName Account Name String
    * @param accountPass Account Password String
    */
    public Account(String accountName, String accountPass) {
        this.accountName = accountName;
        this.accountPass = accountPass;
        this.ID = curID;
        curID++;
        this.langList = new ArrayList<codeLang>();
    }

    /**
    * Static Factory Method for Account
    * @param accountName Account Name String
    * @param accountPass Account Password String
    # @return Account Object Reference
    */
    public static Account createAccount(String accountName, String accountPass) {
        Account newAccount = new Account(accountName, accountPass);
        return newAccount;
    }

    /**
    * Getter method for Username
    * @return accountName String
    */
    public String getUsername() {
        return this.accountName;
    }

    /**
    * Getter method for Password
    * @return accountPass String
    */
    public String getPassword() {
        return this.accountPass;
    }

    /**
    * Getter method for ID
    * @return ID int
    */
    public int ID() {
        return this.ID;
    }

    /**
    * Setter method for username
    * @param newUsername New username for account
    */
    private void setUsername(String newUsername) {
        this.accountName = newUsername;
    }

    /**
    * Setter method for password
    * @param newPassword New password for account
    */
    private void setPassword(String newPassword) {
        this.accountPass = newPassword;
    }

    /**
    * Getter method for langList
    * @return langList ArrayList of codeLang objects
    */
    public ArrayList<codeLang> getLangList() {
        return this.langList;
    }

    /**
    * Adds object codeLang to langList based on name
    * @param newLang name of language to be added
    */
    private void enrollClasses(String newLang) {
        if (this.checkLang(newLang) == false){
            if (newLang == "Python"){
                this.langList.add(new Python());
            }
            else if (newLang == "Java"){
                this.langList.add(new Java());
            }
        }
    }

    /**
    * Removes object codeLang from langList based on name
    * @param oldLang name of language to be removed
    */
    private void unenrollClasses(String oldLang) {
        for (int i = 0; i < this.langList.size(); i++){
            if (this.langList.get(i).getName() == oldLang){
                this.langList.remove(i);
            }
        }
    }

    /**
    * Checks if the language is already in langList
    * @param langName name of language to be checked
    * @return boolean if language exists in list
     */
    private boolean checkLang(String langName) {
        for (int i = 0; i < this.langList.size(); i++){
            if (this.langList.get(i).getName() == langName){
                return true;
            }
        }
        return false;
    }

}