package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {
    private static int idCounter = 1;
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
}
