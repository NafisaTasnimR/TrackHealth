package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HealthTipService {
    private final List<String> proTips;

    public HealthTipService() {
        this.proTips = loadProTips();
    }

    private List<String> loadProTips() {
        List<String> tips = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("pro_tips.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                tips.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tips;
    }

    public void provideWeeklyTip(String email, GoalTracker goalTracker) {
        int daysPassed = goalTracker.calculateDaysPassed(email);
        if (daysPassed > 0 && daysPassed % 7 == 0) {
            int weekNumber = daysPassed / 7;
            if (weekNumber <= proTips.size()) {
                System.out.println("Pro Tip for Week " + weekNumber + ": " + proTips.get(weekNumber - 1));
            }
        }
    }
}
