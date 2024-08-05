package  com.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.travel.clientstrips.Admin;
import com.travel.clientstrips.User;

public class AdminTest {

    private Admin admin;

    @BeforeEach
    void setUp() {
        admin = new Admin(1, "admin", 35, "P12345678", "1234567890", "admin@example.com", "securePass123", true);
    }

    @Test
    void testAdminInheritance() {
        assertTrue(admin instanceof User);

        assertEquals(1, admin.getId());
        assertEquals("admin", admin.getName());
        assertEquals(35, admin.getAge());
        assertEquals("P12345678", admin.getPassportNumber());
        assertEquals("1234567890", admin.getPhoneNumber());
        assertEquals("admin@example.com", admin.getEmail());
        assertEquals("securePass123", admin.getPassword());
    }

    @Test
    void testAdminToString() {
        String expected = "Admin{id=1, name='admin', age=35, passportNumber='P12345678', phoneNumber='1234567890', email='admin@example.com', password='securePass123'}";
        assertEquals(expected, admin.toString());
    }

    @Test
    void testValidateAdmin() {
        assertTrue(Admin.validateAdmin("admin"));  
        assertFalse(Admin.validateAdmin("user"));  
    }


    @Test
    void testAdminIntegrationWithUser() {
        User user = new User(1, "admin", 35, "P12345678", "1234567890", "admin@example.com", "securePass123");

        assertEquals(user.getId(), admin.getId());
        assertEquals(user.getName(), admin.getName());
        assertEquals(user.getAge(), admin.getAge());
        assertEquals(user.getPassportNumber(), admin.getPassportNumber());
        assertEquals(user.getPhoneNumber(), admin.getPhoneNumber());
        assertEquals(user.getEmail(), admin.getEmail());
        assertEquals(user.getPassword(), admin.getPassword());
    }
    @Test
    void testAdminValidation() {
        assertTrue(Admin.validateAdmin("admin"));
        assertFalse(Admin.validateAdmin("user"));
    }
}
