package org.example;

public interface GoalTrackerService {
    boolean hasGoal(String email);
    boolean shouldRemindToday(String email);
    boolean isGoalCompleted(String email);
    boolean isGoalAchieved(ProgressCalculator progress);
    int calculateDaysPassed(String email);
}
