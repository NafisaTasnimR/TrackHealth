package org.example;

import java.util.HashMap;

public class Authentication {
    private HashMap<String, User> users = new HashMap<>();
    public boolean register(String userId,String name,int age,
                            String gender,String email,String password)
    {
        return true;
    }

    public boolean login(String email,String password)
    {
        return true;
    }
}
