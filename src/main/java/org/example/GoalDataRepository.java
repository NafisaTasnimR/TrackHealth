package org.example;

import java.time.LocalDate;

public interface GoalDataRepository {
    GoalInformation getGoalData(String email);
    LocalDate getLastLoggedDate(String email);
    boolean saveGoalData(Goal goal);
    boolean deletePreviousGoal(String email);
}
