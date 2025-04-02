package org.example;

public class GoalManager {
    private GoalFileHandler goalFileHandler;
    private GoalTracker goalTracker;

    public GoalManager() {
        this.goalFileHandler = new GoalFileHandler();
        this.goalTracker = new GoalTracker();
    }
    public boolean setNewGoal(String email, GoalInformation newGoal) {
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
