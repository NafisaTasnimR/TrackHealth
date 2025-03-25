package org.example;

import java.time.LocalDate;

public class NotificationService {
    public void showGoalReminder(String email, GoalFileHandler goalTracker) {
        if (goalTracker.getGoalData(email) != null) {
            System.out.println("Reminder: Don't forget to log your weight today!");
        }
    }

    public void checkGoalCompletion(String email, GoalFileHandler goalTracker, String weightLogFile) {
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
}
