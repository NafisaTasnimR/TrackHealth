package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {
    private static int idCounter;
    public static String generateId() {
        String formattedId = String.format("user%02d", idCounter);
        idCounter++;
        return formattedId;
    }
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public static void updateConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Error clearing the console.");
        }
    }
    public static String getValidStartDate(Scanner scanner) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate tempStartDate = null;
        String startDate = "";

        while (tempStartDate == null) {
            System.out.print(" ".repeat(60) + "Enter Your Starting Date (yyyy-MM-dd): ");
            startDate = scanner.nextLine();

            try {
                tempStartDate = LocalDate.parse(startDate, formatter);
            } catch (DateTimeParseException e) {
                System.out.println(" ".repeat(60) +
                        "Invalid date format! Please enter the date in 'yyyy-MM-dd' format.");
            }
        }

        return startDate;
    }
    public static String getValidExercisePlace(Scanner scanner) {
        String input;

        while (true) {
            System.out.print(" ".repeat(60) + "Prefer Your Exercise Place (home/gym): ");
            input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("home") || input.equals("gym")) {
                return input;
            } else {
                System.out.println(" ".repeat(60) + "Invalid choice! Please enter only 'home' or 'gym'.");
            }
        }
    }
}
