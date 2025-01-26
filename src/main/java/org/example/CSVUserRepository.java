package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVUserRepository implements UserRepository{
    @Override
    public boolean addUser(User user)
    {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("userData.csv",true))){
            bufferedWriter.write(user.getUserId() + "," + user.getUserName() + ","
                    + user.getAge() + "," + user.getGender() + "," + user.getEmail() + "," + user.getPassword());
            return true;
        }catch (IOException e)
        {
            System.out.println("Error adding user data to file :"+ e.getMessage());
            return false;
        }
    }

    @Override
    public List<User> findUser(String email) {
        return null;
    }
}
