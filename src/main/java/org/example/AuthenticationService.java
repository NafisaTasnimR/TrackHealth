package org.example;

import java.util.HashMap;

public class AuthenticationService {
    private HashMap<String, User> users = new HashMap<>();
    public boolean register(String userId,String name,int age,
                            String gender,String email,String password)
    {
        if(users.containsKey(email))
        {
            System.out.println("You are already registered with this email!");
            return false;
        }
        User user = new User(userId,name,age,gender,email,password);
        users.put(email,user);
        System.out.println("Registration successful!");
        return true;
    }

    public boolean login(String email,String password)
    {
        return true;
    }
}
