package org.example;

public class NotificationService {
    private final GoalTracker goalTracker;
    private final HealthTipService proTipService;
    private static final String RED = "\u001B[31m";
    private static final String YELLOW = "\u001B[33m";
    private static final String CYAN = "\u001B[36m";
    private static final String RESET = "\u001B[0m";

    public NotificationService(GoalTracker goalTracker, HealthTipService proTipService) {
        this.goalTracker = goalTracker;
        this.proTipService = proTipService;
    }

    public void showGoalReminder(String email) {
        if (goalTracker.hasGoal(email) && goalTracker.shouldRemindToday(email)) {
            System.out.println(YELLOW + "Reminder: Don't forget to log your weight today!" + RESET);
        }
    }

    public void checkGoalCompletion(String email) {
        if (goalTracker.isGoalCompleted(email)) {
            System.out.println(RED + "Your goal duration has ended!" + RESET);
        }
        goalTracker.isGoalCompleted(email);
    }

    public void getProTipPerWeek(String email) {
        System.out.print(CYAN);
        proTipService.provideWeeklyTip(email, goalTracker);
        System.out.print(RESET);
    }
}
