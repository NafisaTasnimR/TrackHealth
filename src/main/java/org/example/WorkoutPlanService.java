package org.example;

public class WorkoutPlanService {

    private WorkoutPlanStrategy workoutPlan;

    public WorkoutPlanService(WorkoutPlanStrategy workoutPlan) {
        this.workoutPlan = workoutPlan;
    }

    public WorkoutPlanStrategy getWorkoutPlan() {
        return workoutPlan;
    }

    public void suggestWorkoutPlan() {
        getWorkoutPlan().suggestWorkoutPlan();
    }

}
