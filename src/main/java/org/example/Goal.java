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

    public abstract String setDietPlan(String gender);
    public abstract String setWorkoutPlan();
    public abstract String trackProgress();

    public double getCurrentWeight() {
        return currentWeight;
    }

    public double getTargetWeight() {
        return targetWeight;
    }

    public double getHeight() {
        return height;
    }

    public int getDurationInWeek() {
        return durationInWeek;
    }

    public String getExercisePlace() {
        return exercisePlace;
    }
}
