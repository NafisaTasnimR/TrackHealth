package org.example;

import java.util.Objects;

public class WeightLossGoal extends Goal {
    public WeightLossGoal(GoalInformation goalInformation) {
        super(goalInformation);
    }

    public WeightLossGoal(GoalInformation goalInformation,
                          MealPlanService mealPlanService,
                          WorkoutPlanService workoutPlanService) {
        super(goalInformation, mealPlanService, workoutPlanService);
    }

    @Override
    protected double adjustCalories(double tdee) {
        double weeklyWeightLoss = HealthMetricsCalculator.calculateWeeklyWeightChange(
                getGoalInformation().getCurrentWeight(), getGoalInformation().getDurationInWeek(), "WeightLoss");
        TextFormatter.printWeeklyWeightLoss(weeklyWeightLoss);
        return tdee-625;
    }

}
