package org.example;

public class WeightGainGymWorkoutPlan implements WorkoutPlanStrategy {
    @Override
    public void suggestWorkoutPlan() {
        TextFormatter.formatWorkoutPlan(
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
