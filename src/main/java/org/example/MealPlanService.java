package org.example;

public class MealPlanService {
    private double breakfastRatio;
    private double lunchRatio;
    private double dinnerRatio;
    private double snackRatio;
    private final MealPlanStrategy mealPlanStrategy;
    private final MealPlanFormatter mealPlanFormatter;
    public MealPlanService(double breakfastRatio, double lunchRatio,
                           double dinnerRatio, double snackRatio, MealPlanStrategy mealPlanStrategy,
                            MealPlanFormatter mealPlanFormatter) {
        this.breakfastRatio = breakfastRatio;
        this.lunchRatio = lunchRatio;
        this.dinnerRatio = dinnerRatio;
        this.snackRatio = snackRatio;
        this.mealPlanStrategy = mealPlanStrategy;
        this.mealPlanFormatter = mealPlanFormatter;
    }

    public void generateMealPlan(double dailyCalorieNeed) {
        double breakfastCalories = dailyCalorieNeed * breakfastRatio;
        double lunchCalories = dailyCalorieNeed * lunchRatio;
        double dinnerCalories = dailyCalorieNeed * dinnerRatio;
        double snackCalories = dailyCalorieNeed * snackRatio;

        mealPlanFormatter.printHeader(dailyCalorieNeed);
        mealPlanFormatter.printMeal("Breakfast", mealPlanStrategy.getMealSuggestions("Breakfast"), breakfastCalories);
        mealPlanFormatter.printMeal("Lunch", mealPlanStrategy.getMealSuggestions("Lunch"), lunchCalories);
        mealPlanFormatter.printMeal("Dinner", mealPlanStrategy.getMealSuggestions("Dinner"), dinnerCalories);
        mealPlanFormatter.printMeal("Mid-Morning Snack", mealPlanStrategy.getMealSuggestions("Mid-Morning Snack"), snackCalories);
        mealPlanFormatter.printMeal("Afternoon Snack", mealPlanStrategy.getMealSuggestions("Afternoon Snack"), snackCalories);
    }
}
