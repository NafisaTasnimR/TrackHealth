package org.example;

public class ProgressCalculator {
    private double initialWeight;
    private double targetWeight;
    private double currentWeight;
    private int goalDurationDays;

    public ProgressCalculator(double initialWeight, double targetWeight, double currentWeight, int goalDurationDays) {
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
    public void updateCurrentWeight(double weight) {
        this.currentWeight = weight;
    }
    public double calculateProgressPercentage() {
        if (initialWeight == targetWeight) {
            return 100.0;
        }
        double progress = 100 * Math.abs(currentWeight - initialWeight) / Math.abs(targetWeight - initialWeight);
        return Math.min(progress, 100.0);
    }

}
