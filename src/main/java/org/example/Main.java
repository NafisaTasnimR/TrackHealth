package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static boolean isRunning = true;
    public static void main(String[] args) {
        mainMenu();
    }
    public static void mainMenu()
    {
        Scanner scanner = new Scanner(System.in);
        while(isRunning) {
            System.out.println(" ".repeat(50) + "-----------------------TrackHealth-----------------------");
            System.out.println(" ".repeat(75) + "1. Login");
            System.out.println(" ".repeat(75) + "2. Sign Up");
            System.out.println(" ".repeat(75) + "3. Exit");
            System.out.print(" ".repeat(75) + "Enter Your Choice: ");
            int caseValue = scanner.nextInt();

            switch (caseValue) {
                case 1 -> {
                    System.out.println("//////////////////////////////////////////////");
                    loginMenu(scanner);
                }
                case 2 -> {
                    System.out.println("//////////////////////////////////////////////");
                    registrationMenu(scanner);
                }
                case 3 -> exitApplication();
                default -> System.out.println("Invalid selection. Try again.");
            }
        }

    }
    private static void exitApplication() {
        System.out.println("Thank You For Using HireUp!");
        System.out.println("Exiting The System...");
        isRunning = false;
        System.exit(0);
    }

    private static void logout() {

    }
    private static void loginMenu(Scanner scanner) {
        scanner.nextLine();
        System.out.print(" ".repeat(75) + "Enter Your Email: ");
        String email = scanner.nextLine();
        System.out.println();
        System.out.print(" ".repeat(75) + "Enter Your Password: ");
        String password = scanner.nextLine();
        System.out.println();
        UserRepository userRepository = new CSVUserRepository();
        AuthenticationService authenticationService = new AuthenticationService(userRepository);
        if(authenticationService.login(email,password)) {
            System.out.println(" ".repeat(75) + "Welcome To TrackHealth!!");
            userMenu(scanner,email);
        }
    }

    private static void registrationMenu(Scanner scanner) {

    }

    private static void userMenu(Scanner scanner, String email) {
        boolean isRunning = true;
        NotificationService notificationService = new NotificationService();
        GoalFileHandler goalFileHandler = new GoalFileHandler();
        Goal goal = null; // Move it outside the loop

        while (isRunning) {
            System.out.println(" ".repeat(50) + "----------------Welcome To TrackHealth----------------");
            notificationService.showGoalReminder(email, goalFileHandler);
            System.out.println(" ".repeat(75) + "1. Set Your Fitness Goal");
            System.out.println(" ".repeat(75) + "2. Watch Diet Plan According To Your Goal");
            System.out.println(" ".repeat(75) + "3. Watch Workout Plan According To Your Goal");
            System.out.println(" ".repeat(75) + "4. Watch Your Progress So Far");
            System.out.println(" ".repeat(75) + "5. Logout");
            System.out.print(" ".repeat(75) + "Enter Your Choice: ");

            int caseValue = scanner.nextInt();
            scanner.nextLine();

            switch (caseValue) {
                case 1 -> {
                    goal = setFitnessGoalMenu(scanner, email);
                }
                case 2 -> {
                    if (goal != null) {
                        watchDietPlanMenu(scanner, goal);
                    } else {
                        showSetGoalReminder();
                    }
                }
                case 3 -> {
                    if (goal != null) {
                        watchWorkoutPlanMenu(scanner, goal);
                    } else {
                        showSetGoalReminder();
                    }
                }
                case 4 -> {
                    watchProgressSoFarMenu(scanner, email);
                }
                case 5 -> {
                    logout();
                }
                default -> System.out.println(" ".repeat(50) + "Invalid choice!! Try Again");
            }
        }
    }

    private static void showSetGoalReminder() {
        System.out.println(" ".repeat(50) + "You Have To Set Your Goal First.");
        System.out.println(" ".repeat(50) + "1. Return To The User Menu");
        System.out.println(" ".repeat(50) + "2. Select Option (1) To Set Your Goal");
        System.out.println(" ".repeat(50) + "3. After Completing The Necessary Steps You Can View Your Diet Plan.");
    }
    private static Goal setFitnessGoalMenu(Scanner scanner, String email)
    {
        System.out.println(" ".repeat(50) + "----------------Set Your Fitness Goal----------------");
        return takeInformationToSetGoal(scanner, email);

    }

    private static void watchDietPlanMenu(Scanner scanner, Goal goal)
    {
        System.out.println(" ".repeat(50) + "----------------Get Your Diet Chart----------------");
        List<Object> userInformation = takeInformationToSetDietPlan(scanner,goal);
        goal.setDietPlan((String) userInformation.get(0), (int) userInformation.get(1), (String) userInformation.get(2));
    }
    private static void watchWorkoutPlanMenu(Scanner scanner, Goal goal)
    {
        System.out.println(" ".repeat(50) + "----------------Get some Workout Advice----------------");
        goal.setWorkoutPlan();
    }
    private static void watchProgressSoFarMenu(Scanner scanner, String email) {
        System.out.println(" ".repeat(50) + "----------------How Close Are You To Achieve Your Goal?----------------");
        System.out.println(" ".repeat(50) + "1. Log Your Weight Today");
        System.out.println(" ".repeat(50) + "2. View Your Progress History");
        System.out.println(" ".repeat(50) + "3. Go Back");
        System.out.print(" ".repeat(50) + "Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        GoalFileHandler goalFileHandler = new GoalFileHandler();
        GoalInformation goalInfo = goalFileHandler.getGoalData(email);
        ProgressTracker progressTracker = new ProgressTracker();

        switch (choice) {
            case 1:
                double currentWeight = takeInputForProgressTracking(scanner);
                Progress progress = new Progress(goalInfo.getCurrentWeight(), goalInfo.getTargetWeight(), currentWeight, goalInfo.getTimeDuration());

                if (progressTracker.logCurrentWeight(progress, currentWeight, email)) {
                    System.out.println(" ".repeat(50) + "Weight logged successfully!");
                } else {
                    System.out.println(" ".repeat(50) + "Failed to log weight.");
                }
                break;

            case 2:
                progressTracker.showWeightHistory(email);
                break;

            case 3:
                System.out.println(" ".repeat(50) + "Returning to the previous menu...");
                return;

            default:
                System.out.println(" ".repeat(50) + "Invalid choice. Please select a valid option.");
        }
    }

    private static Goal takeInformationToSetGoal(Scanner scanner,String email)
    {
        System.out.println(" ".repeat(50) + "To Set Your Goal You Need To Enter Some Necessary Information First.");
        System.out.print(" ".repeat(60) + "Enter Your Current Weight: ");
        double currentWeight = scanner.nextDouble();
        System.out.print(" ".repeat(60) + "Enter Your Target Weight: ");
        double targetWeight = scanner.nextDouble();
        System.out.print(" ".repeat(60) + "Enter Your Height(Centi Meter): ");
        double heightInCm = scanner.nextDouble();
        System.out.print(" ".repeat(60) + "Enter Your Goal Time Duration(Days): ");
        int timeDuration = scanner.nextInt();
        System.out.print(" ".repeat(60) + "Enter Your Exercise Time Duration Per Week(Days): ");
        int durationInWeek = scanner.nextInt();
        System.out.print(" ".repeat(60) + "Prefer Your Exercise Place(home/gym): ");
        scanner.nextLine();
        String exercisePlace = scanner.nextLine();
        System.out.println(" ".repeat(60) + "Select Your Goal: ");
        System.out.println(" ".repeat(65) + "1. Weight Gain");
        System.out.println(" ".repeat(65) + "2. Weight Loss");
        System.out.println(" ".repeat(65) + "3. Weight Maintenance");
        System.out.print(" ".repeat(60) + "Enter Your Selection: ");
        int choiceNumber = scanner.nextInt();
        String goalType = null;
        switch (choiceNumber) {
            case 1 -> {
                goalType = "weightGain";
                break;
            }
            case 2 -> {
                goalType = "weightLoss";
                break;
            }
            case 3 -> {
                goalType = "weightMaintenance";
                break;
            }
            default -> System.out.println("Invalid Choice!!");
        }
        System.out.print(" ".repeat(60) + "Enter Your Starting Date(yyyy-mm-dd): ");
        scanner.nextLine();
        String startDate = scanner.nextLine();
        System.out.println(" ".repeat(50) + "Thank You For Entering All The Data!");
        System.out.println(" ".repeat(50) + "Tired??...Get Some Fresh Water! Water Keeps You Hydrated...");

        GoalInformation goalInfo = new GoalInformation(currentWeight, targetWeight, heightInCm, timeDuration, durationInWeek,
                exercisePlace, goalType, startDate, email);
        GoalFileHandler goalFileHandler = new GoalFileHandler();
        goalFileHandler.saveGoalData(goalInfo);
        assert goalType != null;
        return switch (goalType) {
            case "weightGain" -> new WeightGainGoal(goalInfo);
            case "weightLoss" -> new WeightLossGoal(goalInfo);
            case "weightMaintenance" -> new WeightMaintenanceGoal(goalInfo);
            default -> throw new IllegalStateException("Unexpected goal type: " + goalType);
        };
    }
    private static List<Object> takeInformationToSetDietPlan(Scanner scanner, Goal goal) {
        System.out.print(" ".repeat(50) + "Enter Your Gender (male/female): ");
        String gender = scanner.nextLine().trim().toLowerCase();

        System.out.print(" ".repeat(50) + "Enter Your Age: ");
        int age = scanner.nextInt();

        System.out.println(" ".repeat(50) + "Choose Your Activity Level: ");
        System.out.println(" ".repeat(50) + "1. Sedentary");
        System.out.println(" ".repeat(50) + "2. Light Activity");
        System.out.println(" ".repeat(50) + "3. Moderate Activity");
        System.out.println(" ".repeat(50) + "4. Very Active");
        System.out.println(" ".repeat(50) + "5. Super Active");

        System.out.print(" ".repeat(50) + "Enter Your Selected Activity Level (1-5): ");
        int activityChoice = scanner.nextInt();
        scanner.nextLine();

        String activityLevel = switch (activityChoice) {
            case 1 -> "Sedentary";
            case 2 -> "Light Activity";
            case 3 -> "Moderate Activity";
            case 4 -> "Very Active";
            case 5 -> "Super Active";
            default -> {
                System.out.println("Invalid choice. Defaulting to Sedentary.");
                yield "Sedentary";
            }
        };

        return Arrays.asList(gender, age, activityLevel);
    }
    private static double takeInputForProgressTracking(Scanner scanner) {
        System.out.print(" ".repeat(50) + "Enter Your Current Weight: ");
        return scanner.nextDouble();
    }

}