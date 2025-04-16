package org.example;

public class WeightLossGymWorkoutPlan implements WorkoutPlanStrategy {
    @Override
    public void suggestWorkoutPlan() {
        TextFormatter.formatWorkoutPlan(
                "Gym Workout Plan for Weight Loss",
                new String[]{
                        "Warm-up: Light treadmill or cycling",
                        "Strength: Bench Press, Deadlift, Burpee, Squat jump"
                },new String[]{
                        "10 minutes","20 minutes"
                }
        );
    }
}
