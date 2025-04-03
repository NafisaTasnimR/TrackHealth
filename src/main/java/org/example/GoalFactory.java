package org.example;

public class GoalFactory {
    public Goal getGoal(String goalType,GoalInformation goalInformation){
        if(goalType == null){
            return null;
        }
        if(goalType.equalsIgnoreCase("WEIGHTGAIN")){
            return new WeightGainGoal(goalInformation);

        } else if(goalType.equalsIgnoreCase("WEIGHTLOSS")){
            return new WeightLossGoal(goalInformation);

        } else if(goalType.equalsIgnoreCase("WEIGHTMAINTENANCE")){
            return new WeightMaintenanceGoal(goalInformation);
        }

        return null;
    }
}
