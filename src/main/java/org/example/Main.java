package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.example.Utility.updateConsole;

public class Main {
    private static boolean isRunning = true;

    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        while (isRunning) {
            System.out.println(" ".repeat(50) + "-----------------------}  TrackHealth  {-----------------------");
            System.out.println(" ".repeat(75) + "1. Login");
            System.out.println(" ".repeat(75) + "2. Sign Up");
            System.out.println(" ".repeat(75) + "3. Exit");
            System.out.print(" ".repeat(75) + "Enter Your Choice: ");
            String caseValue = scanner.nextLine();

            switch (caseValue) {
                case "1" -> loginMenu(scanner);

                case "2" -> {
                    updateConsole();
                    registrationMenu(scanner);
                    updateConsole();
                }
                case "3" -> exitApplication();
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
        mainMenu();
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
        updateConsole();
        if (authenticationService.login(email, password)) {
            System.out.println(" ".repeat(75) + "Welcome To TrackHealth!!");
            userMenu(scanner, email);
        }
    }

    private static void registrationMenu(Scanner scanner) {
        scanner.nextLine();
        System.out.print(" ".repeat(75) + "Enter Your Name: ");
        String name = scanner.nextLine();
        System.out.println();
        System.out.print(" ".repeat(75) + "Enter Your Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print(" ".repeat(75) + "Enter Your Gender(male/female): ");
        String gender = scanner.nextLine();
        String email = "";
        boolean validEmail = false;
        while (!validEmail) {
            System.out.print(" ".repeat(75) + "Enter Your Email: ");
            email = scanner.nextLine();

            if (Utility.isValidEmail(email)) {
                validEmail = true;
            } else {
                System.out.println(" ".repeat(75) + "Invalid email format! Please enter a valid email.");
            }
        }
        scanner.nextLine();
        System.out.print(" ".repeat(75) + "Enter Your Password: ");
        String password = scanner.nextLine();
        String userId = Utility.generateId();
        User user = new User(userId,name,age,gender, email, password);
        UserRepository userRepository = new CSVUserRepository();
        AuthenticationService authenticationService = new AuthenticationService(userRepository);
        if(authenticationService.register(user)) {
            System.out.println(" ".repeat(75) + "Registration Successful!!");
        }
        else {
            System.out.println(" ".repeat(75) + "Registration Failed!!");
        }
        System.out.print(" ".repeat(75) + "Press any key to return to the previous menu: ");
        scanner.nextLine();
    }

    private static void userMenu(Scanner scanner, String email) {
        GoalManager goalManager = new GoalManager();
        GoalTracker goalTracker = new GoalTracker();
        HealthTipService healthTipService = new HealthTipService();
        NotificationService notificationService = new NotificationService(goalTracker,healthTipService);
        Goal goal = null;
        GoalInformation goalInformation = goalManager.getUserGoal(email);
        if(goalInformation != null) {
            String goalType = goalInformation.getGoalType();

            switch (goalType.toLowerCase()) {
                case "weightgain" -> goal = new WeightGainGoal(goalInformation);
                case "weightloss" -> goal = new WeightLossGoal(goalInformation);
                case "weightmaintenance" -> goal = new WeightMaintenanceGoal(goalInformation);
                default -> System.out.println("Invalid goal type found in data!");
            }
        }

        while (true) {
            System.out.println(" ".repeat(50) + "----------------}  Welcome To TrackHealth  {----------------");
            notificationService.showGoalReminder(email);
            notificationService.getProTipPerWeek(email);
            notificationService.checkGoalCompletion(email);
            System.out.println(" ".repeat(75) + "1. Set Your Fitness Goal");
            System.out.println(" ".repeat(75) + "2. Watch Diet Plan According To Your Goal");
            System.out.println(" ".repeat(75) + "3. Watch Workout Plan According To Your Goal");
            System.out.println(" ".repeat(75) + "4. Watch Your Progress So Far");
            System.out.println(" ".repeat(75) + "5. Calculate Your BMI");
            System.out.println(" ".repeat(75) + "6. Logout");
            System.out.print(" ".repeat(75) + "Enter Your Choice: ");

            int caseValue = scanner.nextInt();
            scanner.nextLine();

            switch (caseValue) {
                case 1 -> {
                    updateConsole();
                    System.out.println(" ".repeat(50) + "----------------}  Set Your Fitness Goal  {----------------");
                    if(goalInformation == null) {
                        goal = setFitnessGoalMenu(scanner, email);
                    } else {
                        System.out.println(" ".repeat(50) + "You Have Set Your Goal Previously!");
                    }
                    handleUserNavigation(scanner);
                    updateConsole();
                }
                case 2 -> {
                    updateConsole();
                    if (goal != null) {
                        watchDietPlanMenu(scanner, goal);
                        handleUserNavigation(scanner);
                    } else {
                        showSetGoalReminder(scanner);
                    }
                    updateConsole();
                }
                case 3 -> {
                    updateConsole();
                    if (goal != null) {
                        watchWorkoutPlanMenu(goal);
                        handleUserNavigation(scanner);
                    } else {
                        showSetGoalReminder(scanner);
                    }
                    updateConsole();
                }
                case 4 -> {
                    updateConsole();
                    if(goal != null) {
                        watchProgressSoFarMenu(scanner, email,goalInformation);
                    } else {
                        showSetGoalReminder(scanner);
                    }
                    updateConsole();
                }
                case 5 -> {
                    updateConsole();
                    calculateBMIMenu(scanner);
                    updateConsole();
                }
                case 6 -> {
                    updateConsole();
                    logout();
                }
                default -> System.out.println(" ".repeat(50) + "Invalid choice!! Try Again");
            }
        }
    }

    private static void showSetGoalReminder(Scanner scanner) {
        System.out.println(" ".repeat(75) + "You Have To Set Your Goal First.");
        System.out.println(" ".repeat(75) + "1. Return To The User Menu");
        System.out.println(" ".repeat(75) + "2. Select Option (1) To Set Your Goal");
        System.out.println(" ".repeat(75) + "3. After Completing The Necessary Steps You Can View Your Diet Plan.");
        System.out.print(" ".repeat(75) + "Press Any Key To Return To The Previous Menu: ");
        scanner.nextLine();
    }

    private static Goal setFitnessGoalMenu(Scanner scanner, String email) {
        while (isRunning) {
            Goal goal = takeInformationToSetGoal(scanner, email);
            System.out.println(" ".repeat(50) + "Your goal has been successfully set!");

            while (true) {
                System.out.println(" ".repeat(50) + "1. Confirm and Continue");
                System.out.println(" ".repeat(50) + "2. Go Back");
                System.out.println(" ".repeat(50) + "3. Log Out");
                System.out.print(" ".repeat(50) + "Enter Your Choice: ");

                int choice;
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                } else {
                    System.out.println(" ".repeat(50) + "Invalid input! Please enter a number.");
                    scanner.nextLine();
                    continue;
                }

                switch (choice) {
                    case 1 -> {
                        return goal;
                    }
                    case 2 -> {
                        System.out.println(" ".repeat(50) + "Returning to the previous menu...");
                        return null;
                    }
                    case 3 -> logout();
                    default -> System.out.println(" ".repeat(50) + "Invalid choice! Please enter 1, 2, or 3.");
                }
            }
        }
        return null;
    }

    private static void watchDietPlanMenu(Scanner scanner, Goal goal) {
        System.out.println(" ".repeat(50) + "----------------}  Get Your Diet Chart  {----------------");
        List<Object> userInformation = takeInformationToSetDietPlan(scanner);
        goal.setDietPlan((String) userInformation.get(0), (int) userInformation.get(1), (String) userInformation.get(2));
    }

    private static void watchWorkoutPlanMenu(Goal goal) {
        System.out.println(" ".repeat(50) + "----------------}  Get some Workout Advice  {----------------");
        goal.setWorkoutPlan();
    }

    private static void watchProgressSoFarMenu(Scanner scanner, String email,GoalInformation goalInfo) {
        while (isRunning) {
            System.out.println(" ".repeat(50) + "----------------}  How Close Are You To Achieve Your Goal?  {----------------");
            System.out.println(" ".repeat(50) + "1. Log Your Weight Today");
            System.out.println(" ".repeat(50) + "2. View Your Progress History");
            System.out.println(" ".repeat(50) + "3. Go Back");
            System.out.println(" ".repeat(50) + "4. Log Out");
            System.out.print(" ".repeat(50) + "Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            ProgressTracker progressTracker = new ProgressTracker();
            updateConsole();
            switch (choice) {
                case 1:
                    TrackerFileHandler trackerFileHandler = new TrackerFileHandler("weight_log.csv");
                    handleWeightLogging(scanner,email,trackerFileHandler,goalInfo,progressTracker);
                    handleUserNavigation(scanner);
                    updateConsole();
                    break;
                case 2:
                    System.out.println(" ".repeat(50) + "----------------}  Weight History  {----------------");
                    progressTracker.showWeightHistory(email);
                    handleUserNavigation(scanner);
                    updateConsole();
                    break;
                case 3:
                    System.out.println(" ".repeat(50) + "Returning to the previous menu...");
                    return;
                case 4:
                    updateConsole();
                    logout();
                default:
                    System.out.println(" ".repeat(50) + "Invalid choice. Please select a valid option.");
            }
        }
    }
    private static void calculateBMIMenu(Scanner scanner) {
        System.out.println(" ".repeat(50) + "----------------}  BMI Calculator  {----------------");
        double currentWeight = getCurrentWeight(scanner);
        System.out.print(" ".repeat(60) + "Enter Your Current Height(cm): ");
        double height = scanner.nextDouble();
        displayBMIAndCategory(currentWeight, height);
        scanner.nextLine();
        System.out.print(" ".repeat(50) + "Press any key to return to the previous menu:");
        scanner.nextLine();
        updateConsole();
    }
    private static void displayBMIAndCategory(double currentWeight,double height) {
        double bmiValue = HealthMetricsCalculator.calculateBMI(currentWeight,height);
        String bmiCategory = HealthMetricsCalculator.getWeightCategory(bmiValue);

        System.out.println("\n" + " ".repeat(50) + "+----------------------------------------------------------------------------------+");
        System.out.printf(" ".repeat(50) + "| %-10s %-5.2f %-64s|\n","Your BMI: " , bmiValue , " (" + bmiCategory + ")");
        System.out.println(" ".repeat(50) + "+----------------------------------------------------------------------------------+");
    }
    private static Goal takeInformationToSetGoal(Scanner scanner, String email) {
        while (isRunning) {
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
            scanner.nextLine();

            String goalType;
            switch (choiceNumber) {
                case 1 -> goalType = "weightGain";
                case 2 -> goalType = "weightLoss";
                case 3 -> goalType = "weightMaintenance";
                default -> {
                    System.out.println("Invalid Choice!! Please enter a valid option.");
                    continue;
                }
            }

            System.out.print(" ".repeat(60) + "Enter Your Starting Date(yyyy-mm-dd): ");
            String startDate = scanner.nextLine();
            System.out.println(" ".repeat(50) + "Thank You For Entering All The Data!");
            System.out.println(" ".repeat(50) + "Tired??...Get Some Fresh Water! Water Keeps You Hydrated...");

            GoalInformation goalInfo = new GoalInformation(currentWeight, targetWeight, heightInCm, timeDuration, durationInWeek,
                    exercisePlace, goalType, startDate, email);
            //GoalFileHandler goalFileHandler = new GoalFileHandler();
            GoalManager goalManager =  new GoalManager();
            goalManager.setNewGoal(email,goalInfo);

            handleUserNavigation(scanner);
            updateConsole();

            return switch (goalType) {
                case "weightGain" -> new WeightGainGoal(goalInfo);
                case "weightLoss" -> new WeightLossGoal(goalInfo);
                case "weightMaintenance" -> new WeightMaintenanceGoal(goalInfo);
                default -> throw new IllegalStateException("Unexpected goal type: " + goalType);
            };
        }

        return null;
    }

    private static List<Object> takeInformationToSetDietPlan(Scanner scanner) {
        String gender;
        while (true) {
            System.out.print(" ".repeat(60) + "Enter Your Gender (male/female): ");
            gender = scanner.nextLine().trim().toLowerCase();

            if (gender.equals("male") || gender.equals("female")) {
                break;
            } else {
                System.out.println(" ".repeat(50) + "Invalid input. Please enter 'male' or 'female'.");
            }
        }

        int age;
        while (true) {
            System.out.print(" ".repeat(60) + "Enter Your Age: ");
            if (scanner.hasNextInt()) {
                age = scanner.nextInt();
                scanner.nextLine();
                if (age > 0) {
                    break;
                }
            }
            System.out.println(" ".repeat(50) + "Invalid age. Please enter a valid number.");
            scanner.nextLine();
        }

        System.out.println(" ".repeat(60) + "Choose Your Activity Level: ");
        System.out.println(" ".repeat(65) + "1. Sedentary");
        System.out.println(" ".repeat(65) + "2. Light Activity");
        System.out.println(" ".repeat(65) + "3. Moderate Activity");
        System.out.println(" ".repeat(65) + "4. Very Active");
        System.out.println(" ".repeat(65) + "5. Super Active");

        int activityChoice;
        while (true) {
            System.out.print(" ".repeat(50) + "Enter Your Selected Activity Level (1-5): ");
            if (scanner.hasNextInt()) {
                activityChoice = scanner.nextInt();
                scanner.nextLine();
                if (activityChoice >= 1 && activityChoice <= 5) {
                    break;
                }
            }
            System.out.println(" ".repeat(50) + "Invalid choice. Please enter a number between 1 and 5.");
            scanner.nextLine();
        }

        String activityLevel = switch (activityChoice) {
            case 2 -> "Light Activity";
            case 3 -> "Moderate Activity";
            case 4 -> "Very Active";
            case 5 -> "Super Active";
            default -> "Sedentary";
        };

        return Arrays.asList(gender, age, activityLevel);
    }

    private static double getCurrentWeight(Scanner scanner) {
        System.out.print(" ".repeat(60) + "Enter Your Current Weight: ");
        return scanner.nextDouble();
    }

    private static void handleUserNavigation(Scanner scanner) {
        System.out.println(" ".repeat(75) + "1. Go Back");
        System.out.println(" ".repeat(75) + "2. Log Out");
        System.out.print(" ".repeat(75) + "Enter your choice: ");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                updateConsole();
                return;
            case 2:
                updateConsole();
                logout();
            default:
                System.out.println(" ".repeat(50) + "Invalid choice. Please enter 1 or 2.");
        }
    }
    private static boolean displayReward(String email,ProgressCalculator progressCalculator) {
        RewardService rewardService = new RewardService();
        return rewardService.getRewardMessage(email,progressCalculator);
    }
    private static void handleWeightLogging(Scanner scanner, String email,
                                            TrackerFileHandler trackerFileHandler,GoalInformation goalInfo,
                                             ProgressTracker progressTracker) {
        System.out.println(" ".repeat(50) + "----------------}  Weight Log  {----------------");
        if (trackerFileHandler.canLogWeight(email)) {
            double currentWeight = getCurrentWeight(scanner);
            ProgressCalculator progress = new ProgressCalculator(goalInfo.getCurrentWeight(), goalInfo.getTargetWeight(), currentWeight, goalInfo.getTimeDuration());
            boolean loggedSuccessfully = progressTracker.logCurrentWeight(progress, currentWeight, email);
            if (loggedSuccessfully) {
                System.out.println(" ".repeat(50) + "Weight logged successfully!");
            } else {
                System.out.println(" ".repeat(50) + "Failed to log weight.");
            }
            scanner.nextLine();
            if(displayReward(email, progress)) {
                System.out.print(" ".repeat(50) + "Enter Any Key To Continue: ");
                scanner.nextLine();
                updateConsole();
            }
            progressTracker.displayProgress(progress,email);
        } else {
            System.out.println(" ".repeat(50) + "You have already logged your weight for today.");
        }
    }

}