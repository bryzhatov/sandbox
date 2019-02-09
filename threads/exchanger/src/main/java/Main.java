import java.util.concurrent.Exchanger;

public class Main {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        Thread1 t1 = new Thread1(exchanger);
        Thread2 t2 = new Thread2(exchanger);
    }

    private static class Thread1 extends Thread {
        private Exchanger<String> exchanger;

        public Thread1(Exchanger<String> exchanger) {
            this.exchanger = exchanger;
            start();
        }

        @Override
        public void run() {
            try {
                exchanger.exchange("It is Dima!");
                sleep(3000);
                exchanger.exchange("Second message");
            } catch (InterruptedException e) {

            }
        }
    }

    private static class Thread2 extends Thread {
        private Exchanger<String> exchanger;

        public Thread2(Exchanger<String> exchanger) {
            this.exchanger = exchanger;
            start();
        }

        @Override
        public void run() {
            try {
                while (true) {
                    String message = exchanger.exchange(null);
                    if (message != null) {
                        System.out.println(message);
                    }
                    System.out.println(1);
                }
            } catch (InterruptedException e) {

            }
        }
    }
}
