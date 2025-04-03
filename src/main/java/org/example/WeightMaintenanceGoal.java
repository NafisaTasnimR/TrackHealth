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

//    @Override
//    protected MealPlanService createMealPlanService() {
//        return new MealPlanService(0.2,0.3,0.3,
//                0.1,new WeightMaintenanceMealPlan());
//    }

//    @Override
//    protected WorkoutPlanService createWorkoutPlanService() {
//        String exercisePlace = getGoalInformation().getExercisePlace();
//        return new WorkoutPlanService(workoutPlanFactory.createWorkoutPlan(exercisePlace));
//    }
}
