package org.example;

import java.util.Objects;

public class WeightGainWorkoutPlanFactory implements WorkoutPlanFactory{
    @Override
    public WorkoutPlanStrategy createWorkoutPlan(String exercisePlace) {
        if (Objects.equals(exercisePlace, "home")) {
            return new WeightGainHomeWorkoutPlan();
        }
        return new WeightGainGymWorkoutPlan();
    }

}
