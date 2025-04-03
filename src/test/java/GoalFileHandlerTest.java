import org.example.Goal;
import org.example.GoalFileHandler;
import org.example.GoalInformation;
import org.example.WeightLossGoal;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GoalFileHandlerTest {
    @Test
    public void testSaveData() {
        boolean expectedValue = true;
        GoalInformation goalInformation = new GoalInformation(62.75,57.00,
                156.55,1,2,"gym","weightLoss",
                "2025-04-02","tasfiarahman@gmail.com");
        GoalFileHandler goalFileHandler = new GoalFileHandler();
        Goal goal = new WeightLossGoal(goalInformation);
        boolean actualValue = goalFileHandler.saveGoalData(goal);
        assertEquals(expectedValue,actualValue);
    }
    @Test
    public void testDeleteUserDataFromFile() {
        boolean expectedValue = true;
        GoalFileHandler goalFileHandler = new GoalFileHandler();
        boolean actualValue = goalFileHandler.deletePreviousGoal("tasfiarahman@gmail.com");
        assertEquals(expectedValue,actualValue);
    }
}
