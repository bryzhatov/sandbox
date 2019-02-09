import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Dmitry Bryzhatov
 * @since 2019-01-22
 */
public class Application {

    private static class AtomicityTest implements Runnable {
        private int i = 0;

        public int getValue() {
            return i;
        }

        private void eventIncrement() {
            synchronized (this) {
                i = 1;
                i = 2;
            }
        }

        @Override
        public void run() {
            while (true) {
                eventIncrement();
            }
        }

        public static void main(String[] args) {
            ExecutorService exec = Executors.newCachedThreadPool();
            AtomicityTest at = new AtomicityTest();
            exec.execute(at);

            while (true) {
                int val = at.getValue();
                if (val % 2 != 0) {
                    System.out.println(val);
                    System.exit(0);
                }
            }
        }
    }

    private static class DoubleCheckReordering {
        private Object object = null;

        public Object getObject() {
            if (object == null) {
                synchronized (this) {
                    if (object == null) {
                        object = new Object();
                    }
                }
            }
            return object;
        }
    }

    private static class ReorderingTest1 {
        private static boolean resultReady;
        private static int result;

        private static class Thread1 extends Thread {
            @Override
            public void run() {
                result = calc();
                resultReady = true;
            }
        }

        private static class Thread2 extends Thread {
            @Override
            public void run() {
                if (resultReady) {
                    takeDecision(result);
                }
            }
        }

        private static int calc() {
            return 1;
        }

        private static void takeDecision(int result) {
            System.out.println(result);
        }
    }

    public static class FinalTest1 {
        int a;
        int b;

        FinalTest1(int a, int b) {
            this.a = a;
            this.b = b;
        }

        private static class Holder {
            static final FinalTest1 FINAL_TEST_1 = new FinalTest1(1, 2);
        }

        public static FinalTest1 getInstance() {
            return Holder.FINAL_TEST_1;
        }
    }

    public static class FinalTest2 {
        int a;
        int b;

        FinalTest2(int a, int b) {
            this.a = a;
            this.b = b;
        }

        private static class Holder {
            static FinalTest2 FINAL_TEST_2 = new FinalTest2(3, 4);
        }

        public static FinalTest2 getInstance() {
            return FinalTest2.Holder.FINAL_TEST_2;
        }
    }
}
