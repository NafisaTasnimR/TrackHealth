package org.example;

import java.util.List;
import java.util.Objects;

public class TextFormatter {
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
    public static void displayProgress(ProgressCalculator progress, String email, double progressPercentage, double distanceToGoal) {
        String BORDER = " ".repeat(50) + "----------------------------------------";

        System.out.println(BORDER);
        System.out.println(" ".repeat(50) + String.format("| %-36s |", "User Progress Summary"));
        System.out.println(BORDER);
        System.out.println(" ".repeat(50) + String.format("| %-20s : %-12s |", "User", email));
        System.out.println(" ".repeat(50) + String.format("| %-20s : %-12.2f |", "Initial Weight", progress.getInitialWeight()));
        System.out.println(" ".repeat(50) + String.format("| %-20s : %-12.2f |", "Current Weight", progress.getCurrentWeight()));
        System.out.println(" ".repeat(50) + String.format("| %-20s : %-12.2f |", "Target Weight", progress.getTargetWeight()));
        System.out.println(" ".repeat(50) + String.format("| %-20s : %-11.2f%% |", "Progress", progressPercentage));

        System.out.println(BORDER);

        String message;
        if (distanceToGoal > 0) {
            message = "You need to gain " + distanceToGoal + " kg to reach your target.";
        } else if (distanceToGoal < 0) {
            message = "You need to lose " + Math.abs(distanceToGoal) + " kg to reach your target.";
        } else {
            message = "Congratulations! You have reached your target weight.";
        }

        System.out.println(" ".repeat(50) + String.format("| %-36s |", message));
        System.out.println(BORDER);
    }
    public static void displayWeightHistory(String email, List<String> history) {
        String BORDER = " ".repeat(50) + "+------------------------------------------+";
        System.out.println(BORDER);
        System.out.printf(" ".repeat(50) + "| %-40s |%n","            Weight History");
        System.out.println(BORDER);
        System.out.printf(" ".repeat(50) + "| %-40s |%n"," User: " + email );
        System.out.println(BORDER);

        if (history.isEmpty()) {
            System.out.printf(" ".repeat(50) + "| %-40s |%n","  No weight history found. ");
        } else {
            System.out.printf(" ".repeat(50) + "| %-10s | %-27s |%n", "Date", "Weight (kg)");
            System.out.println(BORDER);
            for (String entry : history) {
                System.out.printf(" ".repeat(50) +"| %-40s |%n",entry);
                System.out.println(BORDER);
            }
        }
    }
}
