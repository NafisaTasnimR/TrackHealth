import org.example.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GoalTest {
    @Test
    public void testSetDietPlanForWeightGain()
    {
        boolean expectedValue = true;
        GoalInformation goalInformation = new GoalInformation(54.90,58.00,155.58,
                30,3,"home","weightGain",
                "07/04/2025","nafisatasnim8855@gmail.com");
        Goal weightGain = new WeightGainGoal(goalInformation);
        boolean actualValue = weightGain.setDietPlan("female",21,"Light Activity");
        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void testSetDietPlanForWeightLoss()
    {
        boolean expectedValue = true;
        GoalInformation goalInformation = new GoalInformation(61.90,58.00,155.58,
                30,3,"home","weightLoss",
                "07/04/2025","nafisatasnim8855@gmail.com");
        Goal weightLossGoal = new WeightLossGoal(goalInformation);
        boolean actualValue = weightLossGoal.setDietPlan("female",21,"Light Activity");
        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void testSetDietPlanForWeightMaintenance()
    {
        boolean expectedValue = true;
        GoalInformation goalInformation = new GoalInformation(58.00,58.00,155.58,
                30,3,"home","weightMaintenance",
                "07/04/2025","nafisatasnim8855@gmail.com");
        Goal weightMaintenanceGoal = new WeightMaintenanceGoal(goalInformation);
        boolean actualValue = weightMaintenanceGoal.setDietPlan("female",21,"Light Activity");
        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void testSetWorkOutPlanForWeightMaintenance()
    {
        boolean expectedValue = true;
        GoalInformation goalInformation = new GoalInformation(58.00,58.00,155.58,
                30,3,"home","weightMaintenance",
                "07/04/2025","nafisatasnim8855@gmail.com");
        Goal weightMaintenanceGoal = new WeightMaintenanceGoal(goalInformation);
        boolean actualValue = weightMaintenanceGoal.setWorkoutPlan();
        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void testSetWorkOutPlanForWeightLoss()
    {
        boolean expectedValue = true;
        GoalInformation goalInformation = new GoalInformation(61.90,58.00,155.58,
                30,3,"gym","weightLoss",
                "07/04/2025","nafisatasnim8855@gmail.com");
        Goal weightLossGoal = new WeightLossGoal(goalInformation);
        boolean actualValue = weightLossGoal.setWorkoutPlan();
        assertEquals(expectedValue,actualValue);
    }
}
