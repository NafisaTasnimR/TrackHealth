package org.example;

public class WeightMaintenanceGoal extends Goal {
    public WeightMaintenanceGoal(double currentWeight, double height, int durationInWeek, String exercisePlace) {
        super(currentWeight, height, durationInWeek, exercisePlace);
    }

    @Override
    protected double adjustCalories(double tdee) {
        System.out.println("----------------------------------------------------------------------------------" +
                "----------------");
        System.out.printf("| %-94s |\n","You Are Maintaining Your Current Weight");
        System.out.printf("| %-94s |\n","Tips: Avoid Overeating & Stick to your TDEE");
        System.out.println("----------------------------------------------------------------------------------" +
                "----------------");
        return tdee;
    }

    @Override
    protected MealPlanService createMealPlanService() {
        return new MealPlanService(0.2,0.3,0.3,
                0.1,"WeightMaintenance");
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
