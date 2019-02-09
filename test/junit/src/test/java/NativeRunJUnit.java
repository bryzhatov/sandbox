import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class NativeRunJUnit {
    /**
     * В runClasses() указываем тестовые классы.
     */
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(CalculatorTest.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
    }
}
