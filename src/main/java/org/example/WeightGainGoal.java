package org.example;

import java.util.Objects;

public class WeightGainGoal extends Goal {
    public WeightGainGoal(GoalInformation goalInformation) {
        super(goalInformation);
    }
    public WeightGainGoal(GoalInformation goalInformation,
                          MealPlanService mealPlanService,
                          WorkoutPlanService workoutPlanService) {
        super(goalInformation, mealPlanService, workoutPlanService);
    }

    @Override
    protected double adjustCalories(double tdee) {
        double weeklyWeightGain = HealthMetricsCalculator.calculateWeeklyWeightChange(
                getGoalInformation().getCurrentWeight(), getGoalInformation().getDurationInWeek(), "WeightGain");
        TextFormatter.printWeeklyWeightGain(weeklyWeightGain);
        return tdee + 350;
    }

}
