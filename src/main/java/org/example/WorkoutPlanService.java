package org.example;

public class WorkoutPlanService {

    private WorkoutPlan workoutPlan;

    public WorkoutPlanService(WorkoutPlan workoutPlan) {
        this.workoutPlan = workoutPlan;
    }

    public WorkoutPlan getWorkoutPlan() {
        return workoutPlan;
    }

    public void suggestWorkoutPlan() {
        getWorkoutPlan().suggestWorkoutPlan();
    }

}
