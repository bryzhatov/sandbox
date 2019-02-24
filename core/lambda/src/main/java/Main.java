import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Example example = new Example();
        example.m((e) -> {
            System.out.println("adasas");
        });

        Runnable r = () -> System.out.println("d");
        r.run();
    }
}
