package rules.externalreource;

import org.junit.Rule;
import org.junit.Test;

public class One {
    @Rule
    public ExternalResourceRule externalResourceRule = new ExternalResourceRule();

    @Test
    public void ex1() {
        System.out.println("ex1");
    }
}
