package org.example;

import java.util.List;

public class ProgressTracker {
    private TrackerFileHandler fileHandler;

    public ProgressTracker() {
        this.fileHandler = new TrackerFileHandler("weight_log.csv");
    }

    public boolean logCurrentWeight(Progress progress, double weight, String email) {
        if (progress != null) {
            progress.updateCurrentWeight(weight);
            fileHandler.saveWeight(email, weight);
            displayProgress(progress, email);
            return true;
        } else {
            System.out.println("You Haven't Entered Any Of The Necessary Information!");
        }
        return false;
    }

    public void displayProgress(Progress progress, String email) {
        double progressPercentage = progress.calculateProgressPercentage();
        double distanceToGoal = progress.getTargetWeight() - progress.getCurrentWeight();

        System.out.println("User: " + email);
        System.out.println("Initial weight: " + progress.getInitialWeight());
        System.out.println("Current weight: " + progress.getCurrentWeight());
        System.out.println("Target weight: " + progress.getTargetWeight());
        System.out.println("Progress: " + String.format("%.2f", progressPercentage) + "%");

        if (distanceToGoal > 0) {
            System.out.println("You need to gain " + distanceToGoal + " kg to reach your target.");
        } else if (distanceToGoal < 0) {
            System.out.println("You need to lose " + Math.abs(distanceToGoal) + " kg to reach your target.");
        } else {
            System.out.println("Congratulations! You have reached your target weight.");
        }
    }

    public boolean showWeightHistory(String email) {
        List<String> history = fileHandler.getWeightHistory(email);
        System.out.println("\nWeight History for " + email + ":");
        if (history.isEmpty()) {
            System.out.println("No records found.");
            return false;
        }
        for (String entry : history) {
            System.out.println(entry);
        }
        return true;
    }

    public boolean isGoalAchieved(Progress progress) {
        return progress.calculateProgressPercentage() >= 100.0;
    }
}
