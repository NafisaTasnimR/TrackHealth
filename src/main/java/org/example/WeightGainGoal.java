package org.example;

public class WeightGainGoal extends Goal implements WeightChangeCalculator{
    public WeightGainGoal(double currentWeight, double targetWeight, double height,
                          int durationInWeek, String exercisePlace) {
        super(currentWeight, targetWeight, height, durationInWeek, exercisePlace);
    }

    @Override
    public double calculateWeeklyWeightChange() {
        double weeklyWeightChange, weightChangeRation;
        if(getDurationInWeek() >= 12)
        {
            weightChangeRation = 0.0025;
            weeklyWeightChange = getCurrentWeight()*weightChangeRation;
        }
        else {
            weightChangeRation = 0.005;
            weeklyWeightChange = getCurrentWeight()*weightChangeRation;
        }
        return weeklyWeightChange;
    }
    @Override
    public String setDietPlan() { return null; }

    @Override
    public String setWorkoutPlan() {
        return null;
    }

    @Override
    public String trackProgress() {
        return null;
    }
}
