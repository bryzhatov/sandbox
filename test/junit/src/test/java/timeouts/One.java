package timeouts;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class One {
    @Rule
    public Timeout timeout = Timeout.millis(250);

    @Test
    public void example() throws InterruptedException {
        Thread.sleep(220);
    }
}
