package org.example;

public class GoalInformation {
    private double currentWeight;
    private double targetWeight;
    private double heightInCm;
    private int timeDuration;
    private int durationInWeek;
    private String exercisePlace;
    private String goalType;
    private String startDate;
    private String email;

    public GoalInformation(double currentWeight, double targetWeight, double heightInCm,
                           int timeDuration, int durationInWeek, String exercisePlace,
                           String goalType, String startDate, String email) {
        this.currentWeight = currentWeight;
        this.targetWeight = targetWeight;
        this.heightInCm = heightInCm;
        this.timeDuration = timeDuration;
        this.durationInWeek = durationInWeek;
        this.exercisePlace = exercisePlace;
        this.goalType = goalType;
        this.startDate = startDate;
        this.email = email;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public double getTargetWeight() {
        return targetWeight;
    }

    public double getHeightInCm() {
        return heightInCm;
    }

    public int getTimeDuration() {
        return timeDuration;
    }

    public int getDurationInWeek() {
        return durationInWeek;
    }

    public String getExercisePlace() {
        return exercisePlace;
    }

    public String getGoalType() {
        return goalType;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEmail() {
        return email;
    }
}
