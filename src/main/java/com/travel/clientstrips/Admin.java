package com.travel.clientstrips;

public class Admin extends User {

    private boolean hasPrivileges;

    public Admin() {
        super();
    }

    public Admin(int id, String name, int age, String passportNumber, String phoneNumber, String email, String password, boolean hasPrivileges) {
        super(id, name, age, passportNumber, phoneNumber, email, password);
        //this.hasPrivileges = hasPrivileges;
    }



    @Override
    public String toString() {
        return "Admin{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", passportNumber='" + getPassportNumber() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", password='" + getPassword() + '\'' +
                //", hasPrivileges=" + hasPrivileges +
                '}';
    }

    public static boolean validateAdmin(String username) {
//        User user = new User().validateUser(username);
        return username.equals("admin");
    }
}
