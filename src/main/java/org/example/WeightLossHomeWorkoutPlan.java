package org.example;

public class WeightLossHomeWorkoutPlan implements WorkoutPlan {
    @Override
    public void suggestWorkoutPlan() {
        PlanFormatter.formatWorkoutPlan(
                "Home Workout Plan for Weight Loss",
                new String[]{
                        "Warm-up: Light treadmill or cycling",
                        "Strength: Bench Press, Deadlift, Burpee, Squat jump"
                },new String[]{
                        "10 minutes","20 minutes"
                }
        );
    }
}
