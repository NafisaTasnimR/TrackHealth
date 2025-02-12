package org.example;

import java.util.Objects;

public class MealPlanService {
    private double breakfastRatio;
    private double lunchRatio;
    private double dinnerRatio;
    private double snackRatio;
    private String goalType;

    public MealPlanService(double breakfastRatio, double lunchRatio,
                           double dinnerRatio, double snackRatio, String goalType) {
        this.breakfastRatio = breakfastRatio;
        this.lunchRatio = lunchRatio;
        this.dinnerRatio = dinnerRatio;
        this.snackRatio = snackRatio;
        this.goalType = goalType;
    }
    private String[] getMealSuggestions(String mealType) {
        return switch (goalType) {
            case "WeightGain" -> switch (mealType) {
                case "Breakfast" -> new String[]{"Oats, Rice Porridge, Whole Wheat Bread, Roti, Milk,Yogurt",
                        "Nuts, Honey, Butter, Cheese, Peanut Butter, Eggs"};
                case "Lunch" -> new String[]{"Rice, Whole Wheat Bread, Potatoes, Chicken, Lentils, Beans",
                        "Avocado, Olive Oil, Fish, Tofu, Vegetables"};
                case "Dinner" -> new String[]{"Whole Wheat Bread, Rice, Potatoes, Meat, Fish, Eggs",
                        "Lentils, Butter, Vegetables, Olive Oil, Soup"};
                case "Mid-Morning Snack" -> new String[]{"Bananas, Dates, Nuts, Almonds, Smoothies",
                        "Dark Chocolate, Cheese, Boiled Eggs"};
                case "Afternoon Snack" -> new String[]{"Yogurt, Trail Mix, Peanut Butter Toast",
                        "Fruit Salad, Nuts, Milkshake"};
                default -> new String[]{};
            };
            case "WeightLoss" -> switch (mealType) {
                case "Breakfast" -> new String[]{"Eggs, Whole Grain Bread, Oats, Rice Porridge, Yogurt",
                        "Fruits, Avocado, Nuts (Almonds, Walnuts), Coffee, Tea"};
                case "Lunch" -> new String[]{"Brown Rice, Whole Wheat Bread, Fish, Lentils",
                        "Grilled Chicken, Steamed Veggies, Salad, Olive Oil"};
                case "Dinner" -> new String[]{"Rice or Bread, Vegetables, Soup, Tofu, Beans",
                        "Grilled Fish or Chicken, Stir-Fried Veggies with Olive Oil"};
                case "Mid-Morning Snack" -> new String[]{"Greek Yogurt, Nuts, Fruits (Berries, Orange, Banana)",
                        "Dark Chocolate(At least 70% cocoa), Cottage Cheese"};
                case "Afternoon Snack" -> new String[]{"Boiled Egg, Trail Mix, Low-Fat Cheese",
                        "Fruit Salad, Protein Bar"};
                default -> new String[]{};
            };
            case "WeightMaintenance" -> switch (mealType) {
                case "Breakfast" -> new String[]{"Eggs,Whole Grain Bread,Oats,Rice Porridge",
                        "Yogurt, Coffee, Tea, Milk"};
                case "Lunch" -> new String[]{"Brown Rice, Whole Wheat Bread, Fish, Lentils",
                        "Chicken, Veggies, Salad"};
                case "Dinner" -> new String[]{"Rice or Bread, Vegetables, Soup, Potatoes, Beans",
                        "Fish or Chicken, Vegetables"};
                case "Mid-Morning Snack" -> new String[]{"Greek Yogurt, Nuts","Fruits (Berries, Orange, Banana)"};
                case "Afternoon Snack" -> new String[]{"Boiled Egg, Trail Mix, Milkshake",
                        "Fruit Salad, Protein Bar"};
                default -> new String[]{};
            };
            default -> new String[]{};
        };
    }
    private void printMeal(String mealType, String[] suggestions, double calories) {
        if(Objects.equals(mealType, "Breakfast")) {
            System.out.println("----------------------------------------------------------------------------------" +
                    "----------------");
            System.out.printf("| %-20s | %-60s | %-8s |\n", "Meal Time", "Food Suggestions", "Calories");
            System.out.println("----------------------------------------------------------------------------------" +
                    "----------------");
        }

        for (int i = 0; i < suggestions.length; i++) {
            if (i == 0) {
                System.out.printf("| %-20s | %-60s | %-8.2f |\n", mealType, suggestions[i], calories);
            } else {
                System.out.printf("| %-20s | %-60s | %-8s |\n", "", suggestions[i], "");
            }
        }
        System.out.println("----------------------------------------------------------------------------------" +
                "----------------");
    }
    public void generateMealPlan(double dailyCalorieNeed) {
        double breakfastCalories = dailyCalorieNeed * breakfastRatio;
        double lunchCalories = dailyCalorieNeed * lunchRatio;
        double dinnerCalories = dailyCalorieNeed * dinnerRatio;
        double snackCalories = dailyCalorieNeed * snackRatio;

        System.out.println("------------------------------------------------------------");
        System.out.printf("Goal: %s%n", goalType);
        System.out.printf("Total Daily Calorie Target: %.2f%n", dailyCalorieNeed);
        System.out.println("------------------------------------------------------------");

        printMeal("Breakfast", getMealSuggestions("Breakfast"), breakfastCalories);
        printMeal("Lunch", getMealSuggestions("Lunch"), lunchCalories);
        printMeal("Dinner", getMealSuggestions("Dinner"), dinnerCalories);
        printMeal("Snack", getMealSuggestions("Snack"), snackCalories);
    }
}
