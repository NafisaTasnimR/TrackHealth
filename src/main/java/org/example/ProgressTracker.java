package org.example;

public class ProgressTracker {
    private Progress progress;

    public Progress getProgress() {
        return progress;
    }

    public ProgressTracker(Progress progress) {
        this.progress = progress;
    }

    public void logProgress(double currentWeight) {
        getProgress().updateCurrentWeight(currentWeight);
        System.out.printf("Progress: %.2f%%\n", getProgress().calculateProgressPercentage());
    }
    public boolean isGoalAchieved() {
        return progress.calculateProgressPercentage() >= 100.0;
    }

}
