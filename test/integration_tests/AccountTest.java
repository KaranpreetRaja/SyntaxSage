package integration_tests;

import static org.junit.jupiter.api.Assertions.*;
import CustomComponents.AccountNotFoundException;
import org.junit.jupiter.api.Test;
import CustomComponents.Account;


public class AccountTest {

    // Test setExperience method
    @Test
    void testSetExperience() {
        Account account = new Account("test", "test", "Python", "Beginner", "Mar 10 2023");
        account.setExperience("Master");
        assertEquals("Master", account.getExperience());
    }

    // Test new account
    @Test
    void testGetUsername() {
        Account account = new Account("username", "password", "course1,course2", "2 years", "2022-01-01 12:00:00");
        assertEquals("username", account.getUsername());
    }

    @Test
    void testGetPassword() {
        Account account = new Account("username", "password", "course1,course2", "2 years", "2022-01-01 12:00:00");
        assertEquals("password", account.getPassword());
    }

    @Test
    void testGetCourses() {
        Account account = new Account("username", "password", "course1,course2", "2 years", "2022-01-01 12:00:00");
        assertEquals("course1,course2", account.getCourses());
    }

    @Test
    void testGetExperience() {
        Account account = new Account("username", "password", "course1,course2", "2 years", "2022-01-01 12:00:00");
        assertEquals("2 years", account.getExperience());
    }
    @Test
    void testGetCreationDate() {
        Account account = new Account("username", "password", "course1,course2", "2 years", "2022-01-01 12:00:00");
        assertEquals("2022-01-01 12:00:00", account.getCreationDate());
    }

    // Test the signIn method with incorrect password
    @Test
    void testSignInFailure() {
        // Assuming username exists in the database, but the password is incorrect
        assertThrows(AccountNotFoundException.class, () -> Account.signIn("username", "wrongpassword"));
    }

    @Test
    void testCreateAccount1() {
        Account account = Account.createAccount("username", "password", "course1,course2", "2 years", "2022-01-01 12:00:00", 1);
        assertEquals("username", account.getUsername());
    }

    @Test
    void testCreateAccount2() {
        Account account = Account.createAccount("username", "password", "course1,course2", "2 years", "2022-01-01 12:00:00", 1);
        assertEquals("password", account.getPassword());
    }

    @Test
    void testCreateAccount3() {
        Account account = Account.createAccount("username", "password", "course1,course2", "2 years", "2022-01-01 12:00:00", 1);
        assertEquals("course1,course2", account.getCourses());
    }

    @Test
    void testCreateAccount4() {
        Account account = Account.createAccount("username", "password", "course1,course2", "2 years", "2022-01-01 12:00:00", 1);
        assertEquals("2 years", account.getExperience());
    }

    @Test
    void testCreateAccount5() {
        Account account = Account.createAccount("username", "password", "course1,course2", "2 years", "2022-01-01 12:00:00", 1);
        assertEquals("2022-01-01 12:00:00", account.getCreationDate());
    }


}