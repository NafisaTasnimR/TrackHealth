package org.example;

public abstract class Goal {
    private double currentWeight;
    private double targetWeight;
    private double height;
    private int durationInWeek;
    private String exercisePlace;

    public Goal(double currentWeight, double targetWeight, double height, int durationInWeek, String exercisePlace) {
        this.currentWeight = currentWeight;
        this.targetWeight = targetWeight;
        this.height = height;
        this.durationInWeek = durationInWeek;
        this.exercisePlace = exercisePlace;
    }

    public abstract String setDietPlan();
    public abstract String setWorkoutPlan();
    public abstract String trackProgress();
}
