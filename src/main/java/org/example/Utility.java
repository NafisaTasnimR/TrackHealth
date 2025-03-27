package org.example;

public class Utility {
    private static int idCounter = 1;
    public static String generateId() {
        String formattedId = String.format("user%02d", idCounter);
        idCounter++;
        return formattedId;
    }
}
