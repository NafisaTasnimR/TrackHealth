package org.example;

import java.io.*;
import java.util.Date;

public class TrackerFileHandler {
    private String filePath;

    public TrackerFileHandler(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }
    public void saveWeight(String email, double weight) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            String date = new Date().toString();
            writer.write(email + "," + date + "," + weight);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving weight log.");
        }
    }
    public double getLastLoggedWeight(String email) {
        double lastWeight = 0.0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(email)) {
                    lastWeight = Double.parseDouble(parts[2]); 
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading weight log.");
        }
        return lastWeight;
    }
}
