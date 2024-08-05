package com.travel.clientstrips;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class User {
    private int id;
    private String name;
    private int age;
    private String passportNumber;
    private String phoneNumber;
    private String email;
    private String password;
    String filePath = "src/main/java/com/travel/clientstrips/Users.txt";

    public User() {
    }

    public User(int id, String name, int age, String passportNumber, String phoneNumber, String email, String password) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.passportNumber = passportNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                age == user.age &&
                Objects.equals(name, user.name) &&
                Objects.equals(passportNumber, user.passportNumber) &&
                Objects.equals(phoneNumber, user.phoneNumber) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, passportNumber, phoneNumber, email, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", passportNumber='" + passportNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    public User validateUser(String username , String path) {

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("-");
                if (parts.length >= 7) { // Ensure there are enough parts in the line
                    String storedName = parts[0];

                    if (storedName.equals(username) ) {
                        User dummy = new User(stoi(parts[6]), parts[0], stoi(parts[2]), parts[3], parts[4], parts[5], parts[1]);
                        return dummy;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
       return null;
    }

    private int stoi(String part) {
        return Integer.parseInt(part);
    }
}
