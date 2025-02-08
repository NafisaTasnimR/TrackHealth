package org.example;

public abstract class Goal {
    private double currentWeight;
    private double height;
    private int durationInWeek;
    private String exercisePlace;

    public Goal(double currentWeight, double height, int durationInWeek, String exercisePlace) {
        this.currentWeight = currentWeight;
        this.height = height;
        this.durationInWeek = durationInWeek;
        this.exercisePlace = exercisePlace;
    }

    public abstract boolean setDietPlan(String gender,int age,String activityLevel);
    public abstract String setWorkoutPlan();
    public abstract String trackProgress();

    public double getCurrentWeight() {
        return currentWeight;
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
