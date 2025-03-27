package org.example;

import java.util.Objects;

public class PlanFormatter {
    public static void displayBMI(double bmi) {
        System.out.println(" ".repeat(50) + "----------------------------------------------------------------------------------" +
                "----------------");
        System.out.printf(" ".repeat(50) + "| %-10s %-5.2f %-78s|\n","Your BMI: " , bmi , " (" + HealthMetricsCalculator.getWeightCategory(bmi) + ")");
        System.out.println(" ".repeat(50) + "----------------------------------------------------------------------------------" +
                "----------------");
    }
    public static void printHeader(double dailyCalorieNeed) {
        System.out.println(" ".repeat(50) + "----------------------------------------------------------------------------------" +
                "----------------");
        System.out.printf(" ".repeat(50) + "| %-22s  %-65.2f |\n", "Total Daily Calorie Target:", dailyCalorieNeed);
        System.out.println(" ".repeat(50) + "----------------------------------------------------------------------------------" +
                "----------------");
    }
    public static void printMealPlan(String mealType, String[] suggestions, double calories) {
        if(Objects.equals(mealType, "Breakfast")) {
            System.out.println(" ".repeat(50) + "----------------------------------------------------------------------------------" +
                    "----------------");
            System.out.printf(" ".repeat(50) + "| %-20s | %-60s | %-8s |\n", "Meal Time", "Food Suggestions", "Calories");
            System.out.println(" ".repeat(50) + "----------------------------------------------------------------------------------" +
                    "----------------");
        }

        for (int i = 0; i < suggestions.length; i++) {
            if (i == 0) {
                System.out.printf(" ".repeat(50) + "| %-20s | %-60s | %-8.2f |\n", mealType, suggestions[i], calories);
            } else {
                System.out.printf(" ".repeat(50) + "| %-20s | %-60s | %-8s |\n", "", suggestions[i], "");
            }
        }
        System.out.println(" ".repeat(50) + "----------------------------------------------------------------------------------" +
                "----------------");
    }
    public static void formatWorkoutPlan(String title, String[] workouts, String[] durations) {
        System.out.println(" ".repeat(50) + "-----------------------------------------------------------------------------");
        System.out.printf(" ".repeat(50) + "| %-73s |\n",title);
        System.out.println(" ".repeat(50) + "-----------------------------------------------------------------------------");
        System.out.printf(" ".repeat(50) + "| %-60s | %-10s |\n", "Workout", "Duration");
        System.out.println(" ".repeat(50) + "-----------------------------------------------------------------------------");

        for (int i = 0; i < workouts.length; i++) {
            System.out.printf(" ".repeat(50) + "| %-60s | %-10s |\n", workouts[i], durations[i]);
            System.out.println(" ".repeat(50) + "-----------------------------------------------------------------------------");
        }

    }
}
