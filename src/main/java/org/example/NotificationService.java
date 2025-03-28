package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NotificationService {
    public void showGoalReminder(String email, GoalFileHandler goalTracker) {
        if (goalTracker.getGoalData(email) != null) {
            System.out.println("Reminder: Don't forget to log your weight today!");
        }
    }

    public void checkGoalCompletion(String email, GoalFileHandler goalTracker) {
        String goalData = goalTracker.getGoalData(email);
        if (goalData == null) return;

        String[] parts = goalData.split(",");
        LocalDate startDate = LocalDate.parse(parts[2]);
        int durationDays = Integer.parseInt(parts[3]);
        LocalDate endDate = startDate.plusDays(durationDays);
        LocalDate today = LocalDate.now();

        if (!today.isBefore(endDate)) {
            System.out.println("Your goal duration has ended. Would you like to review your progress history? (Yes/No)");
        }
    }

    public void getProTipPerWeek(String email, GoalFileHandler goalTracker) {
        int daysPassed = goalTracker.calculateDaysPassed(email, "weight_log.txt");
        if (daysPassed > 0 && daysPassed % 7 == 0) {
            int weekNumber = daysPassed / 7;
            List<String> proTips = readProTipsFromFile();
            if (weekNumber <= proTips.size()) {
                System.out.println("Pro Tip for Week " + weekNumber + ": " + proTips.get(weekNumber - 1));
            }
        }
    }

    private List<String> readProTipsFromFile() {
        List<String> proTips = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("pro_tips.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                proTips.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return proTips;
    }
}
