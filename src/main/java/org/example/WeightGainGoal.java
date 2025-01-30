package org.example;

public class WeightGainGoal extends Goal{
    public WeightGainGoal(double currentWeight, double targetWeight, double height,
                          int durationInWeek, String exercisePlace) {
        super(currentWeight, targetWeight, height, durationInWeek, exercisePlace);
    }

    @Override
    public String setDietPlan() {
        return null;
    }

    @Override
    public String setWorkoutPlan() {
        return null;
    }

    @Override
    public String trackProgress() {
        return null;
    }
}
