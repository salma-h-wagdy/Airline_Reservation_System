package com.testing;

import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import com.travel.clientstrips.User;
import org.junit.jupiter.api.io.TempDir;

import static org.junit.jupiter.api.Assertions.*;

class UserTests {
    @TempDir
    File tempDir;

    @Test
    void testIdGetterSetter() {
        User user = new User();
        user.setId(1);
        assertEquals(1, user.getId());
    }

    @Test
    void testNameGetterSetter() {
        User user = new User();
        user.setName("Ahmed Hassan");
        assertEquals("Ahmed Hassan", user.getName());
    }

    @Test
    void testAgeGetterSetter() {
        User user = new User();
        user.setAge(35);
        assertEquals(35, user.getAge());
    }

    @Test
    void testPassportNumberGetterSetter() {
        User user = new User();
        user.setPassportNumber("E1234567");
        assertEquals("E1234567", user.getPassportNumber());
    }

    @Test
    void testPhoneNumberGetterSetter() {
        User user = new User();
        user.setPhoneNumber("0101234567");
        assertEquals("0101234567", user.getPhoneNumber());
    }

    @Test
    void testEmailGetterSetter() {
        User user = new User();
        user.setEmail("ahmed.hassan@example.com");
        assertEquals("ahmed.hassan@example.com", user.getEmail());
    }

    @Test
    void testPasswordGetterSetter() {
        User user = new User();
        user.setPassword("securepass");
        assertEquals("securepass", user.getPassword());
    }

    @Test
    void testEquals() {
        User user1 = new User(1, "Ahmed Hassan", 35, "E1234567", "010-123-4567", "ahmed.hassan@example.com", "securepass");
        User user2 = new User(1, "Ahmed Hassan", 35, "E1234567", "010-123-4567", "ahmed.hassan@example.com", "securepass");
        User user3 = new User(2, "Fatima El-Sayed", 29, "E7654321", "011-765-4321", "fatima.elsayed@example.com", "newsecurepass");

        assertEquals(user1, user2);
        assertNotEquals(user1, user3);

    }

    @Test
    void testToString() {
        User user = new User(1, "Ahmed Hassan", 35, "E1234567", "010-123-4567", "ahmed.hassan@example.com", "securepass");
        String expected = "User{id=1, name='Ahmed Hassan', age=35, passportNumber='E1234567', phoneNumber='010-123-4567', email='ahmed.hassan@example.com', password='securepass'}";
        assertEquals(expected, user.toString());
    }

    @Test
    void testValidateUser() throws IOException {
        File file = new File(tempDir, "Userstemp.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("ahmed.hassan@example.com-securepass-35-E1234567-0101234567-ahmed.hassan@example.com-1234\n");
            writer.write("fatima.elsayed@example.com-newsecurepass-29-E7654321-0117654321-fatima.elsayed@example.com-12345\n");
        }

        User user = new User();
        User validatedUser = user.validateUser("ahmed.hassan@example.com", file.getAbsolutePath());

        assertNotNull(validatedUser);
        assertEquals(35, validatedUser.getAge());
        assertEquals("E1234567", validatedUser.getPassportNumber());
        assertEquals("0101234567", validatedUser.getPhoneNumber());
        assertEquals("ahmed.hassan@example.com", validatedUser.getEmail());

        User invalidUser = user.validateUser("unknown@example.com",file.getAbsolutePath());
        assertNull(invalidUser);
    }
}
