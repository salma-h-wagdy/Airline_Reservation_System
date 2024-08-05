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
        // Initialize the admin object before each test
        admin = new Admin(1, "admin", 35, "P12345678", "1234567890", "admin@example.com", "securePass123", true);
    }

    @Test
    void testAdminInheritance() {
        // Test that Admin is an instance of User
        assertTrue(admin instanceof User);

        // Test inherited properties
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
        // Verify that the toString method includes admin-specific information
        String expected = "Admin{id=1, name='admin', age=35, passportNumber='P12345678', phoneNumber='1234567890', email='admin@example.com', password='securePass123'}";
        assertEquals(expected, admin.toString());
    }

    @Test
    void testValidateAdmin() {
        // Test the validateAdmin method
        assertTrue(Admin.validateAdmin("admin"));  // Admin username
        assertFalse(Admin.validateAdmin("user"));  // Non-admin username
    }

    @Test
    void testAdminEqualsAndHashCode() {
        // Create another admin with the same properties
        Admin anotherAdmin = new Admin(1, "admin", 35, "P12345678", "1234567890", "admin@example.com", "securePass123", true);

        // Test equals and hashCode methods
        assertEquals(admin, anotherAdmin);
        assertEquals(admin.hashCode(), anotherAdmin.hashCode());
    }

    @Test
    void testAdminIntegrationWithUser() {
        // Create a User instance and compare it with Admin
        User user = new User(1, "admin", 35, "P12345678", "1234567890", "admin@example.com", "securePass123");

        // Test that admin and user have the same properties
        assertEquals(user.getId(), admin.getId());
        assertEquals(user.getName(), admin.getName());
        assertEquals(user.getAge(), admin.getAge());
        assertEquals(user.getPassportNumber(), admin.getPassportNumber());
        assertEquals(user.getPhoneNumber(), admin.getPhoneNumber());
        assertEquals(user.getEmail(), admin.getEmail());
        assertEquals(user.getPassword(), admin.getPassword());
    }
}
