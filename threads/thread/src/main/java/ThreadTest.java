import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Dmitry Bryzhatov
 * @since 2019-01-24
 */
public class ThreadTest {
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();

    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        thread1.setName("Thread-1");
        Thread2 thread2 = new Thread2();
        thread2.setName("Thread-2");

        thread1.start();
        thread2.start();
    }

    private static class Thread1 extends Thread {
        @Override
        public void run() {
            try {
                lock.lock();
                condition.signal();
                System.out.println("signal");
            } finally {
                lock.unlock();
            }
        }
    }

    private static class Thread2 extends Thread {
        @Override
        public void run() {
            try {
                lock.lock();
                condition.await();
                System.out.println("un wait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}
