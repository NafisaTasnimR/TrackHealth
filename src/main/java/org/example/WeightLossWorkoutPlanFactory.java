package org.example;

import java.util.Objects;

public class WeightLossWorkoutPlanFactory implements WorkoutPlanFactory{
    @Override
    public WorkoutPlan createWorkoutPlan(String exercisePlace) {
        if (Objects.equals(exercisePlace, "home")) {
            return new WeightLossHomeWorkoutPlan();
        }
        return new WeightLossGymWorkoutPlan();
    }
}
