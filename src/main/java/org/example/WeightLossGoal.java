package org.example;

public class WeightLossGoal extends Goal {
    public WeightLossGoal(double currentWeight, double height, int durationInWeek,
                          String exercisePlace) {
        super(currentWeight, height,
                durationInWeek, exercisePlace);
    }

    @Override
    protected double adjustCalories(double tdee) {
        System.out.println("----------------------------------------------------------------------------------" +
                "----------------");
        System.out.printf("| %-94s |\n","Your Weekly Weight Gain Target Is "
                + HealthMetricsCalculator.calculateWeeklyWeightChange(
                getCurrentWeight(),getDurationInWeek(),"WeightLoss") + "kg");
        System.out.println("----------------------------------------------------------------------------------" +
                "----------------");
        return tdee-625;
    }

    @Override
    protected MealPlanService createMealPlanService() {
        return new MealPlanService(0.25, 0.35, 0.30,
                0.10, "WeightLoss");
    }

    @Override
    protected WorkoutPlanService createWorkoutPlanService() {
        return new WorkoutPlanService(getExercisePlace(),"weightLoss");
    }

    @Override
    public String trackProgress() {
        return null;
    }
}
