//Imports
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.Objects;

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
    private String langList;

    /**
    * Default Constructor for Account Object
    */
    public Account() {
        this.accountName = "";
        this.accountPass = "";
        this.ID = currentID();
        this.langList = "";
    }

    /**
    * Constructor for new Account Object
    * @param accountName Account Name String
    * @param accountPass Account Password String
    */
    public Account(String accountName, String accountPass) {
        this.accountName = accountName;
        this.accountPass = accountPass;
        this.ID = currentID();
        this.langList = ""
    }

    /**
    * Constructor for existing Account Object
    * @param accountName Account Name String
    * @param accountPass Account Password String
    * @param accountID Account ID Int
    * @param langList Account Language List String
    */
    public Account(String accountName, String accountPass, String accountID, String langList) {
        this.accountName = accountName;
        this.accountPass = accountPass;
        this.ID = Integer.parseInt(accountID);
        this.langList = langList;
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
    public int getID() {
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
    public String getLangList() {
        return this.langList;
    }

    /**
    * Adds object codeLang to langList based on name
    * @param newLang name of language to be added
    */
    private void enrollClasses(String newLang) {
        if (newLang == "Python" && this.langList.contains("Python,") == false){
            this.langList = this.langList + "Python,";
        }
        else if (newLang == "Java" && this.langList.contains("Java,") == false){
            this.langList = this.langList + "Java,";
        }
    }

    /**
    * Removes object codeLang from langList based on name
    * @param oldLang name of language to be removed
    */
    private void unenrollClasses(String oldLang) {
        if (Object.equals(oldLang, "Python,")){
            if (this.langList.contains("Java")) {
                this.langList = "Java,";
            }
            else {
                this.langList = ",";
            }
        }
        else if (Object.equals(oldLang, "Java,")) {
            if (this.langList.contains("Python,")) {
                this.langList = "Python";
            }
            else {
                this.langList = ",";
            }
        }
    }

    /**
    * Reads the currentID from file and increments it in file
    * @return int curID
    */
    private int currentID() {
        try {
            //Read Current ID and Delete curID.txt
            File curIDFile = new File("curID.txt");
            Scanner scannerID = new Scanner(curIDFile);
            while (scannerID.hasNextLine()) {
                String ID = Integer.parseInt(scannerID.nextLine());
            }
            scannerID.close();
            curIDFile.delete();

            //Create curID.txt and write CurrentID+1
            File newIDFile = new File("curID.txt");
            newIDFile.createNewFile();
            int newID = ID + 1;
            FileWriter IDWriter = new FileWriter("curID.txt");
            IDWriter.write(newID);
            IDWriter.close();

            return ID;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
    * Extracts existing account details from file
    * @return ArrayList<Account> accountList
    */
    public ArrayList<Account> extractAccount() {
        try {
        ArrayList<Account> accountList = new ArrayList<Account>();
        File accountFile = new File("Account.txt");
        Scanner accountScanner = new Scanner(accountFile);
        while (accountScanner.hasNextLine()) {
            String accountDetails = accountScanner.nextLine();
            String[] accountDetailArray = accountDetails.split("!");
            accountList.add(new Account(accountDetailArray[0], accountDetailArray[1], accountDetailArray[2], accountDetailArray[3]));
        }
        accountScanner.close();
        return accountList;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
    * Checks if login is valid
    * @param username Account Username
    * @param password Account Password
    * @param accountList List of Existing Accounts
    * @return int index of account in list, -1 if no account found
    */
    public int accountLogIn(String username, String password, ArrayList<Account> accountList) {
        for (int i = 0; i < accountList.size(), i++) {
            if (Objects.equals(account.get(i).getName(), username)) {
                if (Objects.equals(account.get(i).getPassword(), password)) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
    * Account Creation Method
    * @param username Account Username
    * @param password Account Password
    * @param accountList List of Existing Accounts
    * @return boolean -1 if account exists, 0 if error, 1 if account creation success
    */
    public int accountSignUp(String username, String password, ArrayList<Account> accountList) {
        try {
        for (int i = 0; i < accountList.size(), i++) {
            if (Objects.equals(account.get(i).getName(), username)) {
                return -1;
            }
        Account newAccount = createAccount(username, password);
        accountList.add(newAccount);
        FileWriter accountFile = new FileWriter("Account.txt");
        accountFile.newLine();
        String fileString = username + "!" + password + "!" + newAccount.getID() + "!,";
        accountFile.write(fileString);
        return 1;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }
}