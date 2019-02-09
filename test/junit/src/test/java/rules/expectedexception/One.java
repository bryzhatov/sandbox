package rules.expectedexception;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Проверяет, выбрасывается ли исключение в тесте. Дополнительно
 * проверяет сообщение исключения (может быть полезно JDBC где все
 * исключения это SQLException отличающиеся только своими сообщениями.
 */
public class One {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void example() {
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("text");
        throw new NullPointerException("text");
    }
}
