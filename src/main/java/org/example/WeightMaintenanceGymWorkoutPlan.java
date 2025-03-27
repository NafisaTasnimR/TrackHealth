package org.example;

public class WeightMaintenanceGymWorkoutPlan implements WorkoutPlan {
    @Override
    public void suggestWorkoutPlan() {
        PlanFormatter.formatWorkoutPlan(
                "Gym Workout Plan for Weight Maintenance",
                new String[]{
                        "Warm-up: Light treadmill or cycling",
                        "Strength: Bench Press, Deadlift, Burpee, Squat jump"
                },new String[]{
                        "10 minutes","10 minutes"
                }
        );
    }
}
