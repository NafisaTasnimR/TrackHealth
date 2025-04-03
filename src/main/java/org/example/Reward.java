package org.example;

public class Reward {
    public static final String RESET = "\u001B[0m";
    public static final String YELLOW = "\u001B[33m";
    public static final String CYAN = "\u001B[36m";
    public void displayCongratulatoryMessage() {
        String message =
                YELLOW + "\n" +

                        " ██████╗ ██████╗ ███╗   ██╗ ██████╗ ██████╗  █████╗ ████████╗██╗   ██╗██╗      █████╗ ████████╗██╗ ██████╗ ███╗   ██╗███████╗   ██╗\n" +
                        "██╔════╝██╔═══██╗████╗  ██║██╔════╝ ██╔══██╗██╔══██╗╚══██╔══╝██║   ██║██║     ██╔══██╗╚══██╔══╝██║██╔═══██╗████╗  ██║██╔════╝   ██║\n" +
                        "██║     ██║   ██║██╔██╗ ██║██║  ███╗██████╔╝███████║   ██║   ██║   ██║██║     ███████║   ██║   ██║██║   ██║██╔██╗ ██║███████╗   ██║\n" +
                        "██║     ██║   ██║██║╚██╗██║██║   ██║██╔══██╗██╔══██║   ██║   ██║   ██║██║     ██╔══██║   ██║   ██║██║   ██║██║╚██╗██║╚════██║   ╚═╝\n" +
                        "╚██████╗╚██████╔╝██║ ╚████║╚██████╔╝██║  ██║██║  ██║   ██║   ╚██████╔╝███████╗██║  ██║   ██║   ██║╚██████╔╝██║ ╚████║███████║   ██╗\n" +
                        " ╚═════╝ ╚═════╝ ╚═╝  ╚═══╝ ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝   ╚═╝    ╚═════╝ ╚══════╝╚═╝  ╚═╝   ╚═╝   ╚═╝ ╚═════╝ ╚═╝  ╚═══╝╚══════╝   ╚═╝\n"



                        + RESET;

        System.out.println(message);
    }
    public void displayAdditionalMessage() {
        String additionalMessage = CYAN + "\n" +
                "You've shown incredible dedication and perseverance in reaching your diet goal.\n" +
                "All your hard work and commitment have truly paid off, and you’ve " +
                "made remarkable progress towards a healthier lifestyle\n" +
                "Celebrate this achievement and Keep up the great work!!\n" + RESET;
        System.out.println(additionalMessage);
    }
    public void displayMessageForGoalNotAchieved() {
        String message = CYAN + "\n" +
                "It's Totally Fine That You Couldn't Achieve Your Goal.\n" +
                "Do Not Get Demotivated!\n" +
                YELLOW+ "“It does not matter how slowly you go as long as you do not stop.” – Confucius\n"
                + RESET;
        System.out.println(message);
    }
}
