package org.example;

public class WeightMaintenanceHomeWorkoutPlan implements WorkoutPlanStrategy {
    @Override
    public void suggestWorkoutPlan() {
        TextFormatter.formatWorkoutPlan(
                "Home Workout Plan for Weight Maintenance",
                new String[]{
                        "Warm-up: Light Treadmill or cycling",
                        "Strength: Yoga, Walking, Jumping Rope"
                },new String[]{
                        "10 minutes","15 minutes"
                }
        );
    }
}
