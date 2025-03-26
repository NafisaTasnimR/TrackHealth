package org.example;

public abstract class Goal {
    /*private double currentWeight;
    private double height;
    private int durationInWeek;
    private String exercisePlace;*/

    /*public Goal(double currentWeight, double height, int durationInWeek, String exercisePlace) {
        this.currentWeight = currentWeight;
        this.height = height;
        this.durationInWeek = durationInWeek;
        this.exercisePlace = exercisePlace;
    }*/
    private GoalInformation goalInformation;

    public Goal(GoalInformation goalInformation) {
        this.goalInformation = goalInformation;
    }

    public boolean setDietPlan(String gender, int age, String activityLevel) {
        double bmi = HealthMetricsCalculator.calculateBMI(getGoalInformation().getCurrentWeight(), getGoalInformation().getHeightInCm());
        System.out.println("----------------------------------------------------------------------------------" +
                "----------------");
        System.out.printf("| %-10s %-5.2f %-78s|\n","Your BMI: " , bmi , " (" + HealthMetricsCalculator.getWeightCategory(bmi) + ")");
        System.out.println("----------------------------------------------------------------------------------" +
                "----------------");

        double bmr = HealthMetricsCalculator.calculateBMR(getGoalInformation().getCurrentWeight(), getGoalInformation().getHeightInCm(), age, gender);
        double tdee = HealthMetricsCalculator.calculateTDEE(bmr, activityLevel);
        double dailyCalorieNeed = adjustCalories(tdee);

        MealPlanService mealPlanService = createMealPlanService();
        mealPlanService.generateMealPlan(dailyCalorieNeed);

        return true;
    }
    public boolean setWorkoutPlan(){
        WorkoutPlanService workoutPlan = createWorkoutPlanService();
        if(workoutPlan == null){
            return false;
        }
        workoutPlan.suggestWorkoutPlan();
        return true;
    }

    protected abstract double adjustCalories(double tdee);
    protected abstract MealPlanService createMealPlanService();
    protected abstract WorkoutPlanService createWorkoutPlanService();

    public GoalInformation getGoalInformation() {
        return goalInformation;
    }
    /*public double getCurrentWeight() {
        return currentWeight;
    }

    public double getHeight() {
        return height;
    }

    public int getDurationInWeek() {
        return durationInWeek;
    }

    public String getExercisePlace() {
        return exercisePlace;
    }*/
}
