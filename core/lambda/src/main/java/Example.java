import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Example {
    public void comparator() {
        List<String> list = new ArrayList<>();

        // Old
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });

        // New
        list.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

        /*
         * В пакете java.util.function есть набор функциональных
         * интерфейсов. Как например параметр метода comparingInt(ToIntFunction).
         * :: - ссылка на метод.
         */
        list.sort(Comparator.comparingInt(String::length));
    }

    private String a;


    public void m(FuncExample m) {
        m.method(3);
        System.out.println("asdasdsa");
    }

    @FunctionalInterface
    interface FuncExample {
        void method(Integer name);
    }
}