package org.example;

public class GoalFactory {
    public Goal getGoal(String goalType, GoalInformation goalInformation) {
        MealPlanService mealPlanService;
        WorkoutPlanService workoutPlanService;
        WorkoutPlanFactory workoutPlanFactory;

        switch (goalType) {
            case "weightLoss":
                mealPlanService = new MealPlanService(0.25, 0.35, 0.30, 0.10, new WeightLossMealPlan());
                workoutPlanFactory = new WeightLossWorkoutPlanFactory();
                workoutPlanService = new WorkoutPlanService(workoutPlanFactory.createWorkoutPlan(goalInformation.getExercisePlace()));
                return new WeightLossGoal(goalInformation, mealPlanService, workoutPlanService);

            case "weightGain":
                mealPlanService = new MealPlanService(0.30, 0.40, 0.20, 0.10, new WeightGainMealPlan());
                workoutPlanFactory = new WeightGainWorkoutPlanFactory();
                workoutPlanService = new WorkoutPlanService(workoutPlanFactory.createWorkoutPlan(goalInformation.getExercisePlace()));
                return new WeightGainGoal(goalInformation, mealPlanService, workoutPlanService);

            case "weightMaintenance":
                mealPlanService = new MealPlanService(0.30, 0.30, 0.30, 0.10, new WeightMaintenanceMealPlan());
                workoutPlanFactory = new WeightMaintenanceWorkoutPlanFactory();
                workoutPlanService = new WorkoutPlanService(workoutPlanFactory.createWorkoutPlan(goalInformation.getExercisePlace()));
                return new WeightMaintenanceGoal(goalInformation, mealPlanService, workoutPlanService);

            default:
                throw new IllegalArgumentException("Unknown goal type: " + goalType);
        }
    }
}
