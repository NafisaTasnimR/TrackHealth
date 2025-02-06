import org.example.Goal;
import org.example.WeightGainGoal;
import org.example.WeightLossGoal;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GoalTest {
    @Test
    public void testSetGoalForWeightGain()
    {
        boolean expectedValue = true;
        Goal weightGain = new WeightGainGoal(61.90,57.00,
                155.58,12,"home");
        boolean actualValue = weightGain.setDietPlan("female",21,"Light Activity");
        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void testSetGoalForWeightLoss()
    {
        boolean expectedValue = true;
        Goal weightGain = new WeightLossGoal(61.90,57.00,
                155.58,12,"home");
        boolean actualValue = weightGain.setDietPlan("female",21,"Light Activity");
        assertEquals(expectedValue,actualValue);
    }
}
