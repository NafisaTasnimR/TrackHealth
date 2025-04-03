package org.example;

public abstract class Goal {
    private GoalInformation goalInformation;
    private MealPlanService mealPlanService;
    private WorkoutPlanService workoutPlanService;

    public Goal(GoalInformation goalInformation) {
        this.goalInformation = goalInformation;
    }

    public Goal(GoalInformation goalInformation, MealPlanService mealPlanService, WorkoutPlanService workoutPlanService) {
        this.goalInformation = goalInformation;
        this.mealPlanService = mealPlanService;
        this.workoutPlanService = workoutPlanService;
    }

    public boolean setDietPlan(String gender, int age, String activityLevel) {
        double bmi = HealthMetricsCalculator.calculateBMI(getGoalInformation().getCurrentWeight(), getGoalInformation().getHeightInCm());
        TextFormatter.displayBMI(bmi);

        double bmr = HealthMetricsCalculator.calculateBMR(getGoalInformation().getCurrentWeight(), getGoalInformation().getHeightInCm(), age, gender);
        double tdee = HealthMetricsCalculator.calculateTDEE(bmr, activityLevel);
        double dailyCalorieNeed = adjustCalories(tdee);

        //MealPlanService mealPlanService = createMealPlanService();
        mealPlanService.generateMealPlan(dailyCalorieNeed);

        return true;
    }
    public boolean setWorkoutPlan(){
        //WorkoutPlanService workoutPlan = createWorkoutPlanService();
        if(workoutPlanService == null){
            return false;
        }
        workoutPlanService.suggestWorkoutPlan();
        return true;
    }

    protected abstract double adjustCalories(double tdee);
    //protected abstract MealPlanService createMealPlanService();
    //protected abstract WorkoutPlanService createWorkoutPlanService();

    public GoalInformation getGoalInformation() {
        return goalInformation;
    }
}
