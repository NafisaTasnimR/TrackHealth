package org.example;

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

    private static void userMenu(Scanner scanner,String email) {
        while (isRunning) {
            NotificationService notificationService = new NotificationService();
            GoalFileHandler goalFileHandler = new GoalFileHandler();
            System.out.println(" ".repeat(50) + "----------------Welcome To TrackHealth----------------");
            notificationService.showGoalReminder(email,goalFileHandler);
            System.out.println(" ".repeat(75) + "1. Set Your Fitness Goal");
            System.out.println(" ".repeat(75) + "2. Watch Diet Plan According To Your Goal");
            System.out.println(" ".repeat(75) + "3. Watch Workout Plan According To Your Goal");
            System.out.println(" ".repeat(75) + "4. Watch Your Progress So Far");
            System.out.println(" ".repeat(75) + "5. Logout");
            System.out.print(" ".repeat(75) + "Enter Your Choice: ");
            int caseValue = scanner.nextInt();
            switch (caseValue) {
                case 1 -> {
                    setFitnessGoalMenu(scanner,email);
                    break;
                }
                case 2 -> {
                    watchDietPlanMenu(scanner,email);
                    break;
                }
                case 3 -> {
                    watchWorkoutPlanMenu(scanner,email);
                    break;
                }
                case 4 -> {
                    watchProgressSoFarMenu(scanner,email);
                    break;
                }
                case 5 -> logout();
                default -> System.out.println(" ".repeat(50) + "Invalid choice!! Try Again");
            }
        }
    }

    private static void setFitnessGoalMenu(Scanner scanner, String email)
    {
        System.out.println(" ".repeat(50) + "----------------Set Your Fitness Goal----------------");
        takeInformationToSetGoal(scanner,email);

    }

    private static void watchDietPlanMenu(Scanner scanner, String email)
    {
        System.out.println(" ".repeat(50) + "----------------Get Your Diet Chart----------------");

    }
    private static void watchWorkoutPlanMenu(Scanner scanner, String email)
    {
        System.out.println(" ".repeat(50) + "----------------Get some Workout Advice----------------");

    }
    private static void watchProgressSoFarMenu(Scanner scanner, String email)
    {
        System.out.println(" ".repeat(50) + "----------------How Close Are You To Achieve Your Goal?----------------");
    }
    private static void takeInformationToSetGoal(Scanner scanner,String email)
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
        String goalType;
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
        System.out.print(" ".repeat(60) + "Enter Your Starting Date(dd/mm/yyyy): ");
        scanner.nextLine();
        String startDate = scanner.nextLine();
        System.out.println(" ".repeat(50) + "Thank You For Entering All The Data!");
        System.out.println(" ".repeat(50) + "Tired??...Get Some Fresh Water! Water Keeps You Hydrated...");
    }

}