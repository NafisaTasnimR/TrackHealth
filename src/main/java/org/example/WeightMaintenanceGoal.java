package org.example;

import java.util.Objects;

public class WeightMaintenanceGoal extends Goal {
    public WeightMaintenanceGoal(GoalInformation goalInformation) {
        super(goalInformation);
    }

    @Override
    protected double adjustCalories(double tdee) {
        System.out.println(" ".repeat(50) + "----------------------------------------------------------------------------------" +
                "----------------");
        System.out.printf(" ".repeat(50) + "| %-94s |\n","You Are Maintaining Your Current Weight");
        System.out.printf(" ".repeat(50) + "| %-94s |\n","Tips: Avoid Overeating & Stick to your TDEE");
        System.out.println(" ".repeat(50) + "----------------------------------------------------------------------------------" +
                "----------------");
        return tdee;
    }

    @Override
    protected MealPlanService createMealPlanService() {
        return new MealPlanService(0.2,0.3,0.3,
                0.1,new WeightMaintenanceMealPlan());
    }

    @Override
    protected WorkoutPlanService createWorkoutPlanService() {
        if(Objects.equals(getGoalInformation().getExercisePlace(), "home")) {
            return new WorkoutPlanService(new WeightMaintenanceHomeWorkoutPlan());
        }
        return new WorkoutPlanService(new WeightMaintenanceGymWorkoutPlan());
    }
}
