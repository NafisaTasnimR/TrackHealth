package org.example;

public class WeightLossGoal extends Goal{
    public WeightLossGoal(double currentWeight, double targetWeight,
                          double height, int durationInWeek,
                          String exercisePlace) {
        super(currentWeight, targetWeight, height,
                durationInWeek, exercisePlace);
    }

    @Override
    public boolean setDietPlan(String gender,int age,String activityLevel) {
        return true;
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
