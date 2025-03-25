package org.example;

import java.util.List;

public class ProgressTracker {
    private Progress progress;
    private TrackerFileHandler fileHandler;

    public ProgressTracker(Progress progress) {
        this.progress = progress;
        this.fileHandler = new TrackerFileHandler("weight_log.csv");
    }

    public Progress getProgress() {
        return progress;
    }

    public void logCurrentWeight(double weight,String email) {
        getProgress().updateCurrentWeight(weight);
        fileHandler.saveWeight(email, weight);
        displayProgress(email);
    }

    public void displayProgress(String email) {
        double progressPercentage = getProgress().calculateProgressPercentage();
        double distanceToGoal = getProgress().getTargetWeight() - getProgress().getCurrentWeight();

        System.out.println("User: " + email);
        System.out.println("Initial weight: " + getProgress().getInitialWeight());
        System.out.println("Current weight: " + getProgress().getCurrentWeight());
        System.out.println("Target weight: " + getProgress().getTargetWeight());
        System.out.println("Progress: " + String.format("%.2f", progressPercentage) + "%");

        if (distanceToGoal > 0) {
            System.out.println("You need to lose " + distanceToGoal + " kg to reach your target.");
        } else if (distanceToGoal < 0) {
            System.out.println("You need to gain " + Math.abs(distanceToGoal) + " kg to reach your target.");
        } else {
            System.out.println("Congratulations! You have reached your target weight.");
        }
    }

    public void showWeightHistory(String email) {
        List<String> history = fileHandler.getWeightHistory(email);
        System.out.println("\nWeight History for " + email + ":");
        if (history.isEmpty()) {
            System.out.println("No records found.");
        } else {
            for (String entry : history) {
                System.out.println(entry);
            }
        }
    }
    public boolean isGoalAchieved() {
        return getProgress().calculateProgressPercentage() >= 100.0;
    }

}
