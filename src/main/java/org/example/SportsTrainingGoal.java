package org.example;

public class SportsTrainingGoal extends Goal{
    public SportsTrainingGoal(double currentWeight, double targetWeight,
                              double height, int durationInWeek, String exercisePlace) {
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
