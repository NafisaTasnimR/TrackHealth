package org.example;

import java.util.Objects;

public class WeightGainGoal extends Goal {
    public WeightGainGoal(GoalInformation goalInformation) {
        super(goalInformation);
    }

    @Override
    protected double adjustCalories(double tdee) {
        double weeklyWeightGain = HealthMetricsCalculator.calculateWeeklyWeightChange(
                getGoalInformation().getCurrentWeight(), getGoalInformation().getDurationInWeek(), "WeightGain");
        TextFormatter.printWeeklyWeightGain(weeklyWeightGain);
        return tdee + 350;
    }

    @Override
    protected MealPlanService createMealPlanService() {
        return new MealPlanService(0.20, 0.30,
                0.30, 0.20, new WeightGainMealPlan());
    }

    @Override
    protected WorkoutPlanService createWorkoutPlanService() {
        if(Objects.equals(getGoalInformation().getExercisePlace(), "home")) {
            return new WorkoutPlanService(new WeightGainHomeWorkoutPlan());
        }
        return new WorkoutPlanService(new WeightGainGymWorkoutPlan());
    }
}
