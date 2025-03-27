package org.example;

public class WeightMaintenanceHomeWorkoutPlan implements WorkoutPlan {
    @Override
    public void suggestWorkoutPlan() {
        PlanFormatter.formatWorkoutPlan(
                "Home Workout Plan for Weight Maintenance",
                new String[]{
                        "Warm-up: Light treadmill or cycling",
                        "Strength: Bench Press, Deadlift, Burpee, Squat jump"
                },new String[]{
                        "10 minutes","20 minutes"
                }
        );
    }
}
