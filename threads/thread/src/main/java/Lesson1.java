import java.util.ArrayList;
import java.util.List;

/**
 * Двести потоков увеличивают переменную counter на 1000 раз.
 * По соображениям должно вывестись число 200000.
 * <p>
 * Проблема: операция инкремента не атамарна. Это значит что
 * Поток-1 может прочитать значение 42, выполнить с 1 по 3 операцию инкремента
 * и уснуть. Поток-2 прочитает значение 42 и выполнит с 1 по 5 операцию
 * инкремента. Поток-1 довыполнит инкремента. Получим: два
 * значения по 42.
 * <p>
 * 1. Положить старое значение в стэк.
 * 2. Положить еденицу в стэк.
 * 3. Сложить из стэка два первых числа.
 * 4. Положить результат в стэк
 * 5. Присвоить новое значение переменной
 */
public class Lesson1 {
    private static int counter;

    public static void main(String[] args) throws InterruptedException {
        List<IncrementThread> list = new ArrayList<>();

        // 1
        for (int i = 0; i < 200; i++) {
            list.add(new IncrementThread());
        }

        // 2
        for (int i = 0; i < 200; i++) {
            list.get(i).start();
        }

        // 3
        for (int i = 0; i < 200; i++) {
            list.get(i).join();
        }

        System.out.println(counter);
    }

    private static class IncrementThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                counter++;
            }
        }
    }
}
