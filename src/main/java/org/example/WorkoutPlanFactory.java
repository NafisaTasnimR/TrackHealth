package org.example;

public interface WorkoutPlanFactory {
    WorkoutPlanStrategy createWorkoutPlan(String exercisePlace);
}
