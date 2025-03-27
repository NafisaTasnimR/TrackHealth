package org.example;

import java.time.LocalDate;

public class GoalTracker {
    private final GoalFileHandler goalFileHandler;

    public GoalTracker(GoalFileHandler goalFileHandler) {
        this.goalFileHandler = goalFileHandler;
    }

    public boolean hasGoal(String email) {
        return goalFileHandler.getGoalData(email) != null;
    }

    public boolean shouldRemindToday(String email) {
        LocalDate lastLoggedDate = goalFileHandler.getLastLoggedDate(email);
        return lastLoggedDate == null || !lastLoggedDate.isEqual(LocalDate.now());
    }

    public boolean isGoalCompleted(String email) {
        GoalInformation goalInfo = goalFileHandler.getGoalData(email);
        if (goalInfo == null) return false;

        LocalDate startDate = LocalDate.parse(goalInfo.getStartDate());
        int durationDays = goalInfo.getTimeDuration();
        LocalDate endDate = startDate.plusDays(durationDays);
        return !LocalDate.now().isBefore(endDate);
    }

    public int calculateDaysPassed(String email) {
        return goalFileHandler.calculateDaysPassed(email);
    }
}
