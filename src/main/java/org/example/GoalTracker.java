package org.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class GoalTracker implements GoalTrackerService{
    private final GoalDataRepository goalDataRepository;

    public GoalTracker(GoalDataRepository goalDataRepository) {
        this.goalDataRepository = goalDataRepository;
    }
    @Override
    public boolean hasGoal(String email) {
        return goalDataRepository.getGoalData(email) != null;
    }
    @Override
    public boolean shouldRemindToday(String email) {
        LocalDate lastLoggedDate = goalDataRepository.getLastLoggedDate(email);
        return lastLoggedDate == null || !lastLoggedDate.isEqual(LocalDate.now());
    }
    @Override
    public boolean isGoalCompleted(String email) {
        GoalInformation goalInfo = goalDataRepository.getGoalData(email);
        if (goalInfo == null) return false;

        LocalDate startDate = LocalDate.parse(goalInfo.getStartDate());
        int durationDays = goalInfo.getTimeDuration();
        LocalDate endDate = startDate.plusDays(durationDays);
        return !LocalDate.now().isBefore(endDate);
    }
    @Override
    public boolean isGoalAchieved(ProgressCalculator progress) {
        return progress.calculateProgressPercentage() >= 100.0;
    }
    @Override
    public int calculateDaysPassed(String email) {

        GoalInformation goalInfo = goalDataRepository.getGoalData(email);
        if (goalInfo == null) {
            return -1;
        }

        LocalDate startDate = LocalDate.parse(goalInfo.getStartDate());
        LocalDate lastLogDate = goalDataRepository.getLastLoggedDate(email);

        if (lastLogDate == null) {
            return -1;
        }

        return (int) ChronoUnit.DAYS.between(startDate, lastLogDate);
    }
}
