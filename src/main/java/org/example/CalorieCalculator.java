package org.example;

public interface CalorieCalculator {
    double calculateTDEE(double BMR,String activityLevel);
    double calculateDailyCalorieNeed(double TDEE);
    double calculateCalorieForBreakfast(double dailyCalorieNeed);
    double calculateCalorieForLunch(double dailyCalorieNeed);
    double calculateCalorieForDinner(double dailyCalorieNeed);
    double calculateCalorieForSnack(double dailyCalorieNeed);


}
