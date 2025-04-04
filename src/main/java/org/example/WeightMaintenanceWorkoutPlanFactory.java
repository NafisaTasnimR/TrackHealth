package org.example;

import java.util.Objects;

public class WeightMaintenanceWorkoutPlanFactory implements WorkoutPlanFactory{
    @Override
    public WorkoutPlan createWorkoutPlan(String exercisePlace) {
        if (Objects.equals(exercisePlace, "home")) {
            return new WeightMaintenanceHomeWorkoutPlan();
        }
        return new WeightMaintenanceGymWorkoutPlan();
    }
}
