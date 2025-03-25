package org.example;

public class NotificationService {
    public void showGoalReminder(String email, GoalFileHandler goalTracker) {
        if (goalTracker.getGoalData(email) != null) {
            System.out.println("Reminder: Don't forget to log your weight today!");
        }
    }
}
