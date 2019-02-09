/**
 * В старой модели JMM запись в строчке 19 из за reordering могла
 * случиться ниже чем запись в строчке 21 и 22. Новая JMM запрещает
 * позволяет поднимать запись не в volatile переменные выше volatile
 * переменных, но запрещает опускать эти записи ниже volatile переменных.
 * В старой модели можно было поднимать выше записи и опускать ниже.
 * Таким образом в новой JMM гарантированно выведеться 1. В старой может
 * вывестить 1 или 0.
 *
 * Вывод: все изменения производимые до изменения volatile переменной будут
 * видны другому потоку.
 */
public class Lesson3 {
    private static int data = 0;
    private static volatile boolean run;

    public static void main(String[] args) throws InterruptedException {
        Reordering reordering = new Reordering();
        reordering.start();
        reordering.join();

        System.out.println(data);
    }

    private static class Reordering extends Thread {
        @Override
        public void run() {
            data = 1;
            run = false;
            while (run) { }
        }
    }
}
