package junit_tests;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import CustomComponents.Account;

class AccountTest{
	private ArrayList<Account> accountList;


    @Test
    void signUpTest1() {
    	accountList = new ArrayList<>();
        ArrayList<String> courses1 = new ArrayList<>();
        courses1.add("Python,");
        
		int accountID = Account.signUp("Milk", "Tea", accountList, courses1);
        assertEquals(accountID, 1);
    }

    @Test
    void signUpTest2() {
        accountList = new ArrayList<>();
        ArrayList<String> courses1 = new ArrayList<>();
        courses1.add("Python,");
        int accountID1 = Account.signUp("Milk", "Tea", accountList, courses1);
        ArrayList<String> courses2 = new ArrayList<>();
        courses2.add("Python,");
        courses2.add("Java,");
        int accountID2 = Account.signUp("Pepsi", "Man", accountList, courses2);

        assertEquals(accountID2, 2);
    }

    @Test
    void signInTest1() {
    	accountList = new ArrayList<>();
        ArrayList<String> courses1 = new ArrayList<>();
        courses1.add("Python,");
        int accountID1 = Account.signUp("Milk", "Tea", accountList, courses1);
        int accountIDTest = Account.signIn("Milk", "Tea", accountList);
        assertEquals(accountID1, accountIDTest);
    }

    @Test
    void signInTest2() {
    	accountList = new ArrayList<>();
        int accountIDTest = Account.signIn("Pepsi", "Man", accountList);
        assertEquals(accountIDTest, -1);
    }
}