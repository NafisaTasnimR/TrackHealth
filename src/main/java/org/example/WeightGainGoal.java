package org.example;

import java.util.Objects;

public class WeightGainGoal extends Goal implements WeightChangeCalculator,BMRCalculator,CalorieCalculator{
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
    public double calculateTDEE(double BMR, String activityLevel) {
        double tdee,activityFactor;
        if(Objects.equals(activityLevel,"Sedentary"))
        {
            activityFactor = 1.2;
        } else if (Objects.equals(activityLevel,"Light Activity")) {
            activityFactor = 1.375;
        } else if (Objects.equals(activityLevel,"Moderate Activity")) {
            activityFactor = 1.55;
        } else if (Objects.equals(activityLevel,"Very Active")) {
            activityFactor = 1.725;
        } else if (Objects.equals(activityLevel,"Super Active")) {
            activityFactor = 1.9;
        }else {
            System.out.println("Choose correct activity level");
            activityFactor = 0.0;
        }
        tdee = BMR*activityFactor;
        return tdee;
    }

    @Override
    public double calculateDailyCalorieNeed(double TDEE) {
        return 0;
    }

    @Override
    public double calculateCalorieForBreakfast(double dailyCalorieNeed) {
        return 0;
    }

    @Override
    public double calculateCalorieForLunch(double dailyCalorieNeed) {
        return 0;
    }

    @Override
    public double calculateCalorieForDinner(double dailyCalorieNeed) {
        return 0;
    }

    @Override
    public double calculateCalorieForSnack(double dailyCalorieNeed) {
        return 0;
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
