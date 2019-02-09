package rules.externalreource;

import org.junit.Rule;
import org.junit.Test;

public class Two {
    @Rule
    public ExternalResourceRule externalResourceRule = new ExternalResourceRule();

    @Test
    public void ex2() {
        System.out.println("ex2");
    }
}
