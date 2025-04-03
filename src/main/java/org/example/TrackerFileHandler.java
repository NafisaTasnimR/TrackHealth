package org.example;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TrackerFileHandler {
    private String filePath;

    public TrackerFileHandler(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public boolean hasLoggedWeightToday(String email) {
        try (BufferedReader reader = new BufferedReader(new FileReader(getFilePath()))) {
            String line;
            LocalDate today = LocalDate.now();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 3 && parts[0].equals(email) && parts[1].equals(today.toString())) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean canLogWeight(String email){
        if(hasLoggedWeightToday(email)) {
            return false;
        }
        return true;
    }
    public void saveWeight(String email, double weight) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(getFilePath(), true))) {
            String date = LocalDate.now().toString();
            writer.write(email + "," + date + "," + weight);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving weight log.");
        }
    }
    public List<String> getWeightHistory(String email) {
        List<String> history = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(getFilePath()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(email)) {
                    history.add(parts[1] + " - " + parts[2] + " kg");
                }
            }
        } catch (IOException e) {
            System.out.println("Error retrieving weight history.");
        }
        return history;
    }
}
