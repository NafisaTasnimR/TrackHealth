package org.example;

public class RewardService {
    private GoalTracker goalTracker;
    private Reward reward;

    public RewardService(GoalTracker goalTracker,Reward reward) {
        this.goalTracker = goalTracker;
        this.reward = reward;
    }

    public GoalTracker getGoalTracker() {
        return goalTracker;
    }

    public Reward getReward() {
        return reward;
    }
    public boolean getRewardMessage(String email,ProgressCalculator progressCalculator) {
        if(getGoalTracker().isGoalCompleted(email)) {
            if(getGoalTracker().isGoalAchieved(progressCalculator)) {
                getReward().displayCongratulatoryMessage();
                getReward().displayAdditionalMessage();
            } else {
                getReward().displayMessageForGoalNotAchieved();
            }
            return true;
        }
        return false;
    }
}
