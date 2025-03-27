package org.example;

public class WeightGainGymWorkoutPlan implements WorkoutPlan {
    @Override
    public void suggestWorkoutPlan() {
        PlanFormatter.formatWorkoutPlan(
                "Gym Workout Plan for Weight Gain",
                new String[]{
                        "Warm-up: Light stretches, jumping jacks",
                        "Strength: Push-ups, Pull-ups, Lunges, Squats"
                },new String[]{
                        "10 minutes","10 minutes"
                }
        );
    }
}
