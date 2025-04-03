package org.example;

public class RewardService {
    private GoalTrackerService goalTrackerService;
    private Reward reward;

    public RewardService(GoalTrackerService goalTracker,Reward reward) {
        this.goalTrackerService = goalTracker;
        this.reward = reward;
    }

    public GoalTrackerService getGoalTrackerService() {
        return goalTrackerService;
    }

    public Reward getReward() {
        return reward;
    }
    public boolean getRewardMessage(String email,ProgressCalculator progressCalculator) {
        if(getGoalTrackerService().isGoalCompleted(email)) {
            if(getGoalTrackerService().isGoalAchieved(progressCalculator)) {
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
