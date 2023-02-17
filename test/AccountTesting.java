import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.io.File;
import src.*;

class AccountTest{
    Account acc1 = new Account();
    
    @Test
    void usernameGetterSetterTest() {
        assertEquals(acc1.getUsername(), "");
        acc1.setUsername("John");
        assertEquals(acc1.getUsername(), "John");
    }

    @Test
    void passwordGetterSetterTest() {
        assertEquals(acc1.getPassword(), "");
        acc1.setPassword("password");
        assertEquals(acc1.getPassword(), "password");
    }

    @Test 
    void getIDTest() {
        assertEquals(acc1.getID(), -1);
    }

    @Test
    void coursesGetterSetterTest() {
        assertEquals(acc1.getCourses(), "");
        acc1.setCourses("Java,Python");
        assertEquals(acc1.getCourses(), "Java,Python");
    }

    @Test
    void experienceGetterSetterTest() {
        assertEquals(acc1.getExperience(), "");
        acc1.setExperience("Skilled");
        assertEquals(acc1.getExperience(), "Skilled");
    }

    @Test
    void creationDateGetterSetter() {
        assertEquals(acc1.getCreationDate(), "");
        acc1.setCreationDate("2023-02-07");
        assertEquals(acc1.getCreationDate(), "");
    }
}