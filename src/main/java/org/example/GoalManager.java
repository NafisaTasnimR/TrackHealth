package org.example;

public class GoalManager {
    private GoalDataRepository goalDataRepository;
    private GoalTrackerService goalTrackerService;
    private GoalFactory goalFactory;

    public GoalManager(GoalDataRepository goalDataRepository,GoalTrackerService goalTracker,GoalFactory goalFactory) {
        this.goalDataRepository = goalDataRepository;
        this.goalTrackerService = goalTracker;
        this.goalFactory = goalFactory;
    }
    public boolean setNewGoal(String email, GoalInformation goalInformation) {
        Goal newGoal = goalFactory.getGoal(goalInformation.getGoalType(),goalInformation);
        if (!goalTrackerService.hasGoal(email)) {
            goalDataRepository.saveGoalData(newGoal);
            return true;
        }

        if (goalTrackerService.isGoalCompleted(email)) {
            goalDataRepository.deletePreviousGoal(email);
            goalDataRepository.saveGoalData(newGoal);
            return true;
        }
        return false;
    }
    public GoalInformation getUserGoal(String email) {
        GoalInformation goalInformation = goalDataRepository.getGoalData(email);
        if (goalInformation == null) {
            System.out.println("No active goal found for " + email);
        }
        return goalInformation;
    }
}
