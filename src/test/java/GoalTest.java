import org.example.Goal;
import org.example.WeightGainGoal;
import org.example.WeightLossGoal;
import org.example.WeightMaintenanceGoal;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GoalTest {
    @Test
    public void testSetDietPlanForWeightGain()
    {
        boolean expectedValue = true;
        Goal weightGain = new WeightGainGoal(61.90,155.58,12,"home");
        boolean actualValue = weightGain.setDietPlan("female",21,"Light Activity");
        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void testSetDietPlanForWeightLoss()
    {
        boolean expectedValue = true;
        Goal weightGain = new WeightLossGoal(61.90,155.58,12,"home");
        boolean actualValue = weightGain.setDietPlan("female",21,"Light Activity");
        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void testSetDietPlanForWeightMaintenance()
    {
        boolean expectedValue = true;
        Goal weightGain = new WeightMaintenanceGoal(61.90,155.58,12,"home");
        boolean actualValue = weightGain.setDietPlan("female",21,"Light Activity");
        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void testSetWorkOutPlanForWeightMaintenance()
    {
        boolean expectedValue = true;
        Goal weightMaintenanceGoal = new WeightMaintenanceGoal(61.90,155.58,12,"home");
        boolean actualValue = weightMaintenanceGoal.setWorkoutPlan();
        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void testSetWorkOutPlanForWeightLoss()
    {
        boolean expectedValue = true;
        Goal weightLossGoal = new WeightLossGoal(61.90,155.58,12,"gym");
        boolean actualValue = weightLossGoal.setWorkoutPlan();
        assertEquals(expectedValue,actualValue);
    }
}
