package org.example;

import java.util.Objects;

public class PlanFormatter {
    public static void printHeader(double dailyCalorieNeed) {
        System.out.println("----------------------------------------------------------------------------------" +
                "----------------");
        System.out.printf("| %-22s  %-65.2f |\n", "Total Daily Calorie Target:", dailyCalorieNeed);
        System.out.println("----------------------------------------------------------------------------------" +
                "----------------");
    }
    public static void printMealPlan(String mealType, String[] suggestions, double calories) {
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
    public static void formatWorkoutPlan(String title, String[] workouts, String[] durations) {
        System.out.println("-----------------------------------------------------------------------------\n");
        System.out.printf("| %-73s |\n",title);
        System.out.println("-----------------------------------------------------------------------------\n");
        System.out.printf("| %-60s | %-10s |\n", "Workout", "Duration");
        System.out.println("-----------------------------------------------------------------------------\n");

        for (int i = 0; i < workouts.length; i++) {
            System.out.printf("| %-60s | %-10s |\n", workouts[i], durations[i]);
            System.out.println("-----------------------------------------------------------------------------\n");
        }

    }
}
