package org.example;

public class WeightLossGoal extends Goal{
    public WeightLossGoal(double currentWeight, double targetWeight,
                          double height, int durationInWeek,
                          String exercisePlace) {
        super(currentWeight, targetWeight, height,
                durationInWeek, exercisePlace);
    }

    @Override
    public String setDietPlan(String gender,int age,String activityLevel) {
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
