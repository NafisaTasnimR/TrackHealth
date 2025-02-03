package org.example;

import java.util.Objects;

public class WeightGainGoal extends Goal implements WeightChangeCalculator,BMRCalculator{
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
    public double calculateBMR(double weightInKg, double heightIncm, int age, String gender) {
        double BMRValue;
        if(Objects.equals(gender, "male"))
        {
            BMRValue = 88.362 + (13.397*weightInKg) + (4.799*heightIncm) - (5.677*age);
        }
        else {
            BMRValue = 447.593 + (9.247*weightInKg) + (3.098*heightIncm) - (4.330*age);
        }
        return BMRValue;
    }
    @Override
    public String setDietPlan(String gender) {
        System.out.println("--------------------------------------");
        System.out.println("Your weekly weight gain target is " + calculateWeeklyWeightChange() + "pound");
        System.out.println("--------------------------------------");
        System.out.printf("| %-10s | %-15s | %-8s |\n", "Meal", "Food Items", "Calories");
        System.out.println("--------------------------------------");
        if(Objects.equals(gender, "male"))
        System.out.printf("| %-10s | %-15s | %-8s |\n", "Morning", "", "");
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
