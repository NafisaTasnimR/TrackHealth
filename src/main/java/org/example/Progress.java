package org.example;

public class Progress {
    private double initialWeight;
    private double targetWeight;
    private double currentWeight;
    private int goalDurationDays;

    public Progress(double initialWeight, double targetWeight, double currentWeight, int goalDurationDays) {
        this.initialWeight = initialWeight;
        this.targetWeight = targetWeight;
        this.currentWeight = currentWeight;
        this.goalDurationDays = goalDurationDays;
    }

    public double getInitialWeight() {
        return initialWeight;
    }

    public double getTargetWeight() {
        return targetWeight;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public int getGoalDurationDays() {
        return goalDurationDays;
    }
    public double calculateProgressPercentage() {
        if (initialWeight == targetWeight) {
            return 100.0;
        }
        double progress = 100 * Math.abs(currentWeight - initialWeight) / Math.abs(targetWeight - initialWeight);
        return Math.min(progress, 100.0);
    }
    
}
