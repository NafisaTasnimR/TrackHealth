package org.example;

public class WeightGainGoal extends Goal {
    public WeightGainGoal(GoalInformation goalInformation) {
        super(goalInformation);
    }

    @Override
    protected double adjustCalories(double tdee) {
        System.out.println("----------------------------------------------------------------------------------" +
                "----------------");
        System.out.printf("| %-94s |\n","Your Weekly Weight Gain Target Is "
                + HealthMetricsCalculator.calculateWeeklyWeightChange(
                getGoalInformation().getCurrentWeight(), getGoalInformation().getDurationInWeek(), "WeightGain") + "kg");
        System.out.println("----------------------------------------------------------------------------------" +
                "----------------");
        return tdee + 350;
    }

    @Override
    protected MealPlanService createMealPlanService() {
        return new MealPlanService(0.20, 0.30,
                0.30, 0.20, "WeightGain");
    }

    @Override
    protected WorkoutPlanService createWorkoutPlanService() {
        return new WorkoutPlanService(getGoalInformation().getExercisePlace(), "weightGain");
    }
}
