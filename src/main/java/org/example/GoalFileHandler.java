package org.example;

import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
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
    public void saveGoalData(GoalInformation goalInfo) {
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
        writeToFile(goalData);
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
    public int calculateDaysPassed(String email) {
        GoalInformation goalInfo = getGoalData(email);
        if (goalInfo == null) {
            return -1;
        }

        LocalDate startDate = LocalDate.parse(goalInfo.getStartDate());
        LocalDate lastLogDate = getLastLoggedDate(email);

        if (lastLogDate == null) {
            return -1;
        }

        return (int) ChronoUnit.DAYS.between(startDate, lastLogDate);
    }


}
