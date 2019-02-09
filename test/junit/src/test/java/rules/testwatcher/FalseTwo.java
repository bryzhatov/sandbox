package rules.testwatcher;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

public class FalseTwo {
    @Rule
    public TestWatcherRule testWatcherRule = new TestWatcherRule();

    @Test
    public void example() {
        Assert.assertTrue(false);
    }
}
