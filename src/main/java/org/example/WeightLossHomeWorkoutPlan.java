package org.example;

public class WeightLossHomeWorkoutPlan implements WorkoutPlan {
    @Override
    public void suggestWorkoutPlan() {
        TextFormatter.formatWorkoutPlan(
                "Home Workout Plan for Weight Loss",
                new String[]{
                        "Warm-up: Light treadmill, cycling, walking",
                        "Strength: Jump Rope, Burpee, Crunches, Lunge"
                },new String[]{
                        "10 minutes","25 minutes"
                }
        );
    }
}
