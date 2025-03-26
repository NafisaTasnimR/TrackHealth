import org.example.Progress;
import org.example.ProgressTracker;
import org.junit.Assert;
import org.junit.Test;

public class ProgressTrackerTest {
    @Test
    public void testLogCurrentProgress()
    {
        boolean expectedValue = true;
        Progress progress = new Progress(62.00,58.00,60.00,30);
        ProgressTracker progressTracker = new ProgressTracker();
        boolean actualValue = progressTracker.logCurrentWeight(progress,60.00,"nafisatasnim8855@gmail.com");
        Assert.assertEquals(expectedValue,actualValue);
    }

    @Test
    public void testLogCurrentProgress2()
    {
        boolean expectedValue = true;
        Progress progress = new Progress(62.00,58.00,59.00,30);
        ProgressTracker progressTracker = new ProgressTracker();
        boolean actualValue = progressTracker.logCurrentWeight(progress,59.00,"nafisatasnim8855@gmail.com");
        Assert.assertEquals(expectedValue,actualValue);
    }

    @Test
    public void testShowWeightHistory()
    {
        boolean expectedValue = true;
        ProgressTracker progressTracker = new ProgressTracker();
        boolean actualValue = progressTracker.showWeightHistory("nafisatasnim8855@gmail.com");
        Assert.assertEquals(expectedValue,actualValue);
    }
}
