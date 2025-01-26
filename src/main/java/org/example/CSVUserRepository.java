package org.example;

import java.io.*;
import java.util.ArrayList;
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
        List<User> users = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("userData.csv"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6 && parts[4].equals(email)) {
                    users.add(new User(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3], parts[4], parts[5]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return users;
    }
}
