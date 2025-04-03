package org.example;

public class WeightMaintenanceGoal extends Goal {
    private final WorkoutPlanFactory workoutPlanFactory;
    public WeightMaintenanceGoal(GoalInformation goalInformation) {

        super(goalInformation);
        this.workoutPlanFactory = new WeightMaintenanceWorkoutPlanFactory();
    }

    @Override
    protected double adjustCalories(double tdee) {
        TextFormatter.printWeeklyWeightMaintenance();
        return tdee;
    }

    @Override
    protected MealPlanService createMealPlanService() {
        return new MealPlanService(0.2,0.3,0.3,
                0.1,new WeightMaintenanceMealPlan());
    }

    @Override
    protected WorkoutPlanService createWorkoutPlanService() {
        String exercisePlace = getGoalInformation().getExercisePlace();
        return new WorkoutPlanService(workoutPlanFactory.createWorkoutPlan(exercisePlace));
    }
}
