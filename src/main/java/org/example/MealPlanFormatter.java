package org.example;

import java.util.Objects;

public class MealPlanFormatter {
    public void printHeader(double dailyCalorieNeed) {
        System.out.println("----------------------------------------------------------------------------------" +
                "----------------");
        System.out.printf("| %-22s  %-65.2f |\n", "Total Daily Calorie Target:", dailyCalorieNeed);
        System.out.println("----------------------------------------------------------------------------------" +
                "----------------");
    }
    public void printMeal(String mealType, String[] suggestions, double calories) {
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
}
