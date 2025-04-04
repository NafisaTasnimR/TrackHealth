package org.example;

public class WeightMaintenanceGoal extends Goal {
    public WeightMaintenanceGoal(GoalInformation goalInformation) {

        super(goalInformation);
    }
    public WeightMaintenanceGoal(GoalInformation goalInformation,
                          MealPlanService mealPlanService,
                          WorkoutPlanService workoutPlanService) {
        super(goalInformation, mealPlanService, workoutPlanService);
    }

    @Override
    protected double adjustCalories(double tdee) {
        TextFormatter.printWeeklyWeightMaintenance();
        return tdee;
    }

}
