package org.example;

public class WeightMaintenanceHomeWorkoutPlan implements WorkoutPlan {
    @Override
    public void suggestWorkoutPlan() {
        PlanFormatter.formatWorkoutPlan(
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
