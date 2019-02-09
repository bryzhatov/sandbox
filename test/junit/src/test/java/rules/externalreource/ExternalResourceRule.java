package rules.externalreource;

import org.junit.rules.ExternalResource;

/**
 * Для повторяющихся @Before или @After в разных учатках кода можно сделать данный @Rule.
 */
public class ExternalResourceRule extends ExternalResource {

    @Override
    protected void before() throws Throwable {
        System.out.println("before()");
    }

    @Override
    protected void after() {
        System.out.println("after()");
    }
}
