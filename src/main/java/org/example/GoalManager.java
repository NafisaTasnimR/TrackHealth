package org.example;

public class GoalManager {
    private GoalFileHandler goalFileHandler;
    private GoalTracker goalTracker;

    public GoalManager() {
        this.goalFileHandler = new GoalFileHandler();
        this.goalTracker = new GoalTracker();
    }

}
