package org.example;

public class WeightGainGoal extends Goal {
    public WeightGainGoal(double currentWeight, double height,
                          int durationInWeek, String exercisePlace) {
        super(currentWeight, height, durationInWeek, exercisePlace);
    }

    @Override
    protected double adjustCalories(double tdee) {
        System.out.println("----------------------------------------------------------------------------------" +
                "----------------");
        System.out.printf("| %-94s |\n","Your Weekly Weight Gain Target Is "
                + HealthMetricsCalculator.calculateWeeklyWeightChange(
                        getCurrentWeight(),getDurationInWeek(),"WeightGain") + "kg");
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
    public String setWorkoutPlan() {
        return null;
    }

    @Override
    public String trackProgress() {
        return null;
    }
}
