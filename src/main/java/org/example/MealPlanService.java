package org.example;

public class MealPlanService {
    private double breakfastRatio;
    private double lunchRatio;
    private double dinnerRatio;
    private double snackRatio;
    private final MealPlanStrategy mealPlanStrategy;
    public MealPlanService(double breakfastRatio, double lunchRatio,
                           double dinnerRatio, double snackRatio, MealPlanStrategy mealPlanStrategy) {
        this.breakfastRatio = breakfastRatio;
        this.lunchRatio = lunchRatio;
        this.dinnerRatio = dinnerRatio;
        this.snackRatio = snackRatio;
        this.mealPlanStrategy = mealPlanStrategy;
    }

    public void generateMealPlan(double dailyCalorieNeed) {
        double breakfastCalories = dailyCalorieNeed * breakfastRatio;
        double lunchCalories = dailyCalorieNeed * lunchRatio;
        double dinnerCalories = dailyCalorieNeed * dinnerRatio;
        double snackCalories = dailyCalorieNeed * snackRatio;

        PlanFormatter.printHeader(dailyCalorieNeed);
        PlanFormatter.printMealPlan("Breakfast", mealPlanStrategy.getMealSuggestions("Breakfast"), breakfastCalories);
        PlanFormatter.printMealPlan("Lunch", mealPlanStrategy.getMealSuggestions("Lunch"), lunchCalories);
        PlanFormatter.printMealPlan("Dinner", mealPlanStrategy.getMealSuggestions("Dinner"), dinnerCalories);
        PlanFormatter.printMealPlan("Mid-Morning Snack", mealPlanStrategy.getMealSuggestions("Mid-Morning Snack"), snackCalories);
        PlanFormatter.printMealPlan("Afternoon Snack", mealPlanStrategy.getMealSuggestions("Afternoon Snack"), snackCalories);
    }
}
