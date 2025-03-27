package org.example;

public class WeightLossGoal extends Goal {
    public WeightLossGoal(GoalInformation goalInformation) {
        super(goalInformation);
    }

    @Override
    protected double adjustCalories(double tdee) {
        System.out.println("----------------------------------------------------------------------------------" +
                "----------------");
        System.out.printf("| %-94s |\n","Your Weekly Weight Loss Target Is "
                + HealthMetricsCalculator.calculateWeeklyWeightChange(
                getGoalInformation().getCurrentWeight(), getGoalInformation().getDurationInWeek(), "WeightLoss") + "kg");
        System.out.println("----------------------------------------------------------------------------------" +
                "----------------");
        return tdee-625;
    }

    @Override
    protected MealPlanService createMealPlanService() {
        return new MealPlanService(0.25, 0.35, 0.30,
                0.10, new WeightLossMealPlan(),new MealPlanFormatter());
    }

    @Override
    protected WorkoutPlanService createWorkoutPlanService() {
        return new WorkoutPlanService(getGoalInformation().getExercisePlace(), "weightLoss");
    }
}
