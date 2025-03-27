package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NotificationService {
    private final GoalTracker goalTracker;
    private final HealthTipService proTipService;

    public NotificationService(GoalTracker goalTracker, HealthTipService proTipService) {
        this.goalTracker = goalTracker;
        this.proTipService = proTipService;
    }

    public void showGoalReminder(String email) {
        if (goalTracker.hasGoal(email) && goalTracker.shouldRemindToday(email)) {
            System.out.println("Reminder: Don't forget to log your weight today!");
        }
    }

    public void checkGoalCompletion(String email) {
        if (goalTracker.isGoalCompleted(email)) {
            System.out.println("Your goal duration has ended. Would you like to review your progress history? (Yes/No)");
        }
    }

    public void getProTipPerWeek(String email) {
        proTipService.provideWeeklyTip(email, goalTracker);
    }
}
