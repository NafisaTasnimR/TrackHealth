package org.example;

import java.util.Objects;

public class WeightGainGoal extends Goal {
    private final WorkoutPlanFactory workoutPlanFactory;
    public WeightGainGoal(GoalInformation goalInformation) {
        super(goalInformation);
        this.workoutPlanFactory = new WeightGainWorkoutPlanFactory();
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
        String exercisePlace = getGoalInformation().getExercisePlace();
        return new WorkoutPlanService(workoutPlanFactory.createWorkoutPlan(exercisePlace));
    }
}
