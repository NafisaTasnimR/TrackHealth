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
    public void saveWeight(String email, double weight) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(getFilePath(), true))) {
            String date = LocalDate.now().toString();
            writer.write(email + "," + date + "," + weight);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving weight log.");
        }
    }
    public double getLastLoggedWeight(String email) {
        double lastWeight = 0.0;
        try (BufferedReader reader = new BufferedReader(new FileReader(getFilePath()))) {
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
