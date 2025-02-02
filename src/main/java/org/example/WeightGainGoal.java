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
        }
        else {
            weightChangeRation = 0.005;
        }
        weeklyWeightChange = getCurrentWeight()*weightChangeRation;
        return weeklyWeightChange;
    }
    @Override
    public String setDietPlan() {
        System.out.println("--------------------------------------");
        System.out.println("Your weekly weight gain target is " + calculateWeeklyWeightChange() + "pound");
        System.out.println("--------------------------------------");
        System.out.printf("| %-10s | %-15s | %-8s |\n", "Meal", "Food Items", "Calories");
        System.out.println("--------------------------------------");
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
