package org.example;

public class WorkoutPlanService {
    private String workoutPlace;
    private String goalType;

    public WorkoutPlanService(String workoutPlace, String goalType) {
        this.workoutPlace = workoutPlace;
        this.goalType = goalType;
    }

    public String getWorkoutPlace() {
        return workoutPlace;
    }

    public String getGoalType() {
        return goalType;
    }

    private void formatWorkoutPlan(String title, String[] workouts, String[] durations) {
        System.out.println("-----------------------------------------------------------------------------\n");
        System.out.printf("| %-73s |\n",title);
        System.out.println("-----------------------------------------------------------------------------\n");
        System.out.printf("| %-60s | %-10s |\n", "Workout", "Duration");
        System.out.println("-----------------------------------------------------------------------------\n");

        for (int i = 0; i < workouts.length; i++) {
            System.out.printf("| %-60s | %-10s |\n", workouts[i], durations[i]);
            System.out.println("-----------------------------------------------------------------------------\n");
        }

    }

    private void suggestHomeWorkout(String goalType){
        switch (goalType){
            case "weightGain":
                formatWorkoutPlan(
                        "Home Workout Plan for Weight Gain",
                        new String[]{
                                "Warm-up: Light stretches, jumping jacks",
                                "Strength: Push-ups, Pull-ups, Lunges, Squats"
                        },new String[]{
                                "10 minutes","10 minutes"
                        }
                );
                break;
            case "weightLoss":
                formatWorkoutPlan(
                        "Home Workout Plan for Weight Loss",
                        new String[]{
                                "Warm-up: Light treadmill or cycling",
                                "Strength: Bench Press, Deadlift, Burpee, Squat jump"
                        },new String[]{
                                "10 minutes","20 minutes"
                        }
                );
                break;
            case "weightMaintenance":
                formatWorkoutPlan(
                        "Home Workout Plan for Weight Maintenance",
                        new String[]{
                                "Warm-up: Light treadmill or cycling",
                                "Strength: Bench Press, Deadlift, Burpee, Squat jump"
                        },new String[]{
                                "10 minutes","20 minutes"
                        }
                );
                break;
            default:
                System.out.println("Goal type not recognized for home workouts.");
        }
    }

    private void suggestGymWorkout(String goalType){
        switch (goalType){
            case "weightGain":
                formatWorkoutPlan(
                        "Gym Workout Plan for Weight Gain",
                        new String[]{
                                "Warm-up: Light stretches, jumping jacks",
                                "Strength: Push-ups, Pull-ups, Lunges, Squats"
                        },new String[]{
                                "10 minutes","10 minutes"
                        }
                );
                break;
            case "weightLoss":
                formatWorkoutPlan(
                        "Gym Workout Plan for Weight Loss",
                        new String[]{
                                "Warm-up: Light treadmill or cycling",
                                "Strength: Bench Press, Deadlift, Burpee, Squat jump"
                        },new String[]{
                                "10 minutes","20 minutes"
                        }
                );
                break;
            case "weightMaintenance":
                formatWorkoutPlan(
                        "Gym Workout Plan for Weight Maintenance",
                        new String[]{
                                "Warm-up: Light treadmill or cycling",
                                "Strength: Bench Press, Deadlift, Burpee, Squat jump"
                        },new String[]{
                                "10 minutes","20 minutes"
                        }
                );
            default:
                System.out.println("Goal type not recognized for home workouts.");
        }
    }

    public void suggestWorkoutPlan() {
        if (getWorkoutPlace().equals("home")) {
            suggestHomeWorkout(getGoalType());
        } else if (getWorkoutPlace().equals("gym")) {
            suggestGymWorkout(getGoalType());
        } else {
            System.out.println("Workout place not recognized. Please choose 'home' or 'gym'.");
        }
    }

}
