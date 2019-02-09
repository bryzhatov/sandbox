public class Lesson2 {
    volatile static int i;
    static boolean b;

    public static void main(String[] args) {
        new Atomicity().start();
        new Atomicity().start();

        while (true) {
            System.out.println(i);
        }
    }

    private static class Atomicity extends Thread {
        public void run() {
            while (true) {
                if (b = !b) {
                    i++;
                } else {
                    i--;
                }
            }
        }
    }
}