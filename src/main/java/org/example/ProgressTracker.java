package org.example;

import java.util.List;

public class ProgressTracker {
    private TrackerFileHandler fileHandler;

    public ProgressTracker() {
        this.fileHandler = new TrackerFileHandler("weight_log.csv");
    }

    public boolean logCurrentWeight(ProgressCalculator progress, double weight, String email) {
        if (fileHandler.hasLoggedWeightToday(email)) {
            return false;
        }
        if (progress != null) {
            progress.updateCurrentWeight(weight);
            fileHandler.saveWeight(email, weight);
//            displayProgress(progress, email);
            return true;
        } else {
            System.out.println("You Haven't Entered Any Of The Necessary Information!");
        }
        return false;
    }

    public void displayProgress(ProgressCalculator progress, String email) {
        double progressPercentage = progress.calculateProgressPercentage();
        double distanceToGoal = progress.getTargetWeight() - progress.getCurrentWeight();
        TextFormatter.displayProgress(progress,email,progressPercentage,distanceToGoal);
    }

    public boolean showWeightHistory(String email) {
        List<String> history = fileHandler.getWeightHistory(email);
        TextFormatter.displayWeightHistory(email, history);

        return !history.isEmpty();
    }

}
