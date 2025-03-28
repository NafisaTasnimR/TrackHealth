package org.example;

public class RewardService {
    private GoalTracker goalTracker;
    private Reward reward;

    public RewardService() {
        this.goalTracker = new GoalTracker();
        this.reward = new Reward();
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
