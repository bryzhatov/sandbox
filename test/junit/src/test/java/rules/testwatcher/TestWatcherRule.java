package rules.testwatcher;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

/**
 * Нужен что бы собрать какую-то информацию о тесте, залогировать.
 */
public class TestWatcherRule extends TestWatcher {

    /**
     * В случае если тест прошел.
     */
    @Override
    protected void succeeded(Description description) {
        System.out.println("Success pass: " + description.getMethodName() + "()");
    }

    /**
     * Если тест не прошел. Объект ислючения который возник в тестовом методе
     * можно получить здесь. Может понадобиться что бы настроить логирование ошибок.
     */
    @Override
    protected void failed(Throwable e, Description description) {
        System.out.println("Failed test: " + description.getDisplayName() + ". Because: " + e.toString());
    }

    /**
     * Тест только начал свою проверку.
     */
    @Override
    protected void starting(Description description) {
        System.out.println("Starting test: " + description.getMethodName() + "()");
    }

    /**
     * Тест заканчивает свою работу.
     */
    @Override
    protected void finished(Description description) {
        System.out.println("Finished test: " + description.getMethodName() + "()");
    }
}
