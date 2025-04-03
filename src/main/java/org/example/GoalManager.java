package org.example;

public class GoalManager {
    private GoalFileHandler goalFileHandler;
    private GoalTracker goalTracker;
    private GoalFactory goalFactory;

    public GoalManager(GoalFileHandler goalFileHandler,GoalTracker goalTracker,GoalFactory goalFactory) {
        this.goalFileHandler = goalFileHandler;
        this.goalTracker = goalTracker;
        this.goalFactory = goalFactory;
    }
    public boolean setNewGoal(String email, GoalInformation goalInformation) {
        Goal newGoal = goalFactory.getGoal(goalInformation.getGoalType(),goalInformation);
        if (!goalTracker.hasGoal(email)) {
            goalFileHandler.saveGoalData(newGoal);
            return true;
        }

        if (goalTracker.isGoalCompleted(email)) {
            goalFileHandler.deletePreviousGoal(email);
            goalFileHandler.saveGoalData(newGoal);
            return true;
        }
        return false;
    }
    public GoalInformation getUserGoal(String email) {
        GoalInformation goalInformation = goalFileHandler.getGoalData(email);
        if (goalInformation == null) {
            System.out.println("No active goal found for " + email);
        }
        return goalInformation;
    }
}
