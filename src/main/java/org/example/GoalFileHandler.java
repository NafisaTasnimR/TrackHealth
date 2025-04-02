package org.example;

import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoalFileHandler {
    private static final String FILE_NAME = "userGoal.csv";

    public LocalDate getLastLoggedDate(String email) {
        File file = new File("weight_log.csv");
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
                if (parts.length == 9) {
                    goalData.put(parts[0], line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return goalData;
    }
    private boolean writeToFile(Map<String, String> goalData) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String dataLine : goalData.values()) {
                writer.write(dataLine);
                writer.newLine();
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean saveGoalData(Goal goal) {
        GoalInformation goalInfo = goal.getGoalInformation();
        Map<String, String> goalData = loadGoalData();
        String dataLine = String.join(",",
                goalInfo.getEmail(),
                goalInfo.getGoalType(),
                goalInfo.getStartDate(),
                String.valueOf(goalInfo.getTimeDuration()),
                String.valueOf(goalInfo.getCurrentWeight()),
                String.valueOf(goalInfo.getTargetWeight()),
                String.valueOf(goalInfo.getHeightInCm()),
                String.valueOf(goalInfo.getDurationInWeek()),
                goalInfo.getExercisePlace()
        );
        goalData.put(goalInfo.getEmail(), dataLine);
        return writeToFile(goalData);
    }
    public GoalInformation getGoalData(String email) {
        Map<String, String> goalData = loadGoalData();
        String dataLine = goalData.get(email);
        if (dataLine == null) {
            return null;
        }

        String[] parts = dataLine.split(",");
        return new GoalInformation(
                Double.parseDouble(parts[4]),
                Double.parseDouble(parts[5]),
                Double.parseDouble(parts[6]),
                Integer.parseInt(parts[3]),
                Integer.parseInt(parts[7]),
                parts[8],
                parts[1],
                parts[2],
                parts[0]
        );
    }
    private boolean deleteUserDataFromFile(String filePath, String email) {
        File file = new File(filePath);
        List<String> updatedLines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.startsWith(email + ",")) {
                    updatedLines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, false))) {
            for (String line : updatedLines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public boolean deletePreviousGoal(String email) {
        String goalFilePath = "userGoal.csv";
        String progressFilePath = "weight_log.csv";

        boolean userGoalDataDeleted = deleteUserDataFromFile(goalFilePath, email);
        boolean userLogDataDeleted = deleteUserDataFromFile(progressFilePath, email);

        System.out.println("Previous goal and progress deleted successfully.");
        return (userGoalDataDeleted && userLogDataDeleted);
    }
}
