package org.example;

import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class GoalFileHandler {
    private static final String FILE_NAME = "userGoal.csv";

    private LocalDate getLastLoggedDate(String weightLogFile, String email) {
        File file = new File(weightLogFile);
        if (!file.exists()) {
            return null;
        }

        LocalDate lastDate = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2 && parts[0].equals(email)) {
                    LocalDate logDate = LocalDate.parse(parts[1]);
                    if (lastDate == null || logDate.isAfter(lastDate)) {
                        lastDate = logDate;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lastDate;
    }
    private Map<String, String> loadGoalData() {
        Map<String, String> goalData = new HashMap<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return goalData;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    goalData.put(parts[0], line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return goalData;
    }
    private void writeToFile(Map<String, String> goalData) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String dataLine : goalData.values()) {
                writer.write(dataLine);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void saveGoalData(String email, String goalType, String startDate, int durationDays) {
        Map<String, String> goalData = loadGoalData();
        String dataLine = email + "," + goalType + "," + startDate + "," + durationDays;
        goalData.put(email, dataLine);
        writeToFile(goalData);
    }
    public String getGoalData(String email) {
        Map<String, String> goalData = loadGoalData();
        return goalData.getOrDefault(email, null);
    }
    public int calculateDaysPassed(String email, String weightLogFile) {
        String goalData = getGoalData(email);
        if (goalData == null) {
            return -1;
        }

        String[] parts = goalData.split(",");
        LocalDate startDate = LocalDate.parse(parts[2]);
        LocalDate lastLogDate = getLastLoggedDate(weightLogFile, email);

        if (lastLogDate == null) {
            return -1;
        }

        return (int) ChronoUnit.DAYS.between(startDate, lastLogDate);
    }


}
