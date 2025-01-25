package org.example;

public class User {
    private String userId;
    private String userName;
    private int age;
    private String gender;
    private String email;
    private String password;

    public User(String userId, String userName, int age, String gender, String email, String password) {
        this.userId = userId;
        this.userName = userName;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
