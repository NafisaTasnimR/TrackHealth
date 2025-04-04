package org.example;

public class NotificationService {
    private final GoalTrackerService goalTrackerService;
    private final HealthTipService proTipService;
    private static final String RED = "\u001B[31m";
    private static final String YELLOW = "\u001B[33m";
    private static final String CYAN = "\u001B[36m";
    private static final String RESET = "\u001B[0m";

    public NotificationService(GoalTrackerService goalTracker, HealthTipService proTipService) {
        this.goalTrackerService = goalTracker;
        this.proTipService = proTipService;
    }

    public void showGoalReminder(String email) {
        if (goalTrackerService.hasGoal(email) && goalTrackerService.shouldRemindToday(email)) {
            System.out.println(YELLOW + "Reminder: Don't forget to log your weight today!" + RESET);
        }
    }

    public void checkGoalCompletion(String email) {
        if (goalTrackerService.isGoalCompleted(email)) {
            System.out.println(RED + "Your goal duration has ended!" + RESET);
        }
        goalTrackerService.isGoalCompleted(email);
    }

    public void getProTipPerWeek(String email) {
        System.out.print(CYAN);
        proTipService.provideWeeklyTip(email, goalTrackerService);
        System.out.print(RESET);
    }
}
