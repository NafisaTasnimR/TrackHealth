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
        }
    }

    private static void registrationMenu(Scanner scanner) {

    }

    private static void userMenu(Scanner scanner) {
        System.out.println(" ".repeat(50) + "----------------Welcome To TrackHealth----------------");
        System.out.println(" ".repeat(75) + "1. Set Your Fitness Goal");
        System.out.println(" ".repeat(75) + "2. Watch Diet Plan According To Your Goal");
        System.out.println(" ".repeat(75) + "3. Watch Workout Plan According To Your Goal");
        System.out.println(" ".repeat(75) + "4. Watch Your Progress So Far");
        System.out.println(" ".repeat(75) + "5. Logout");
    }
}