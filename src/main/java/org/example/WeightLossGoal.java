package org.example;

import java.util.Objects;

public class WeightLossGoal extends Goal {
    public WeightLossGoal(GoalInformation goalInformation) {
        super(goalInformation);
    }

    @Override
    protected double adjustCalories(double tdee) {
        System.out.println(" ".repeat(50) +"----------------------------------------------------------------------------------" +
                "----------------");
        System.out.printf(" ".repeat(50) + "| %-94s |\n","Your Weekly Weight Loss Target Is "
                + HealthMetricsCalculator.calculateWeeklyWeightChange(
                getGoalInformation().getCurrentWeight(), getGoalInformation().getDurationInWeek(), "WeightLoss") + "kg");
        System.out.println(" ".repeat(50) + "----------------------------------------------------------------------------------" +
                "----------------");
        return tdee-625;
    }

    @Override
    protected MealPlanService createMealPlanService() {
        return new MealPlanService(0.25, 0.35, 0.30,
                0.10, new WeightLossMealPlan());
    }

    @Override
    protected WorkoutPlanService createWorkoutPlanService() {
        if(Objects.equals(getGoalInformation().getExercisePlace(), "home")) {
            return new WorkoutPlanService(new WeightLossHomeWorkoutPlan());
        }
        return new WorkoutPlanService(new WeightLossGymWorkoutPlan());
    }
}
