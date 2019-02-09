import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors
                .newFixedThreadPool(4);

        Future future = executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return 1;
            }
        });
        System.out.println(future.get().getClass().getSimpleName());
        System.out.println(future.cancel(true));
    }
}

// invokeAll
// invokeAny
// Future<?> submit(Runnable task) - выполнение таски
// Future<?> submit(Runnable task, T result) - выполнение таски
// Future<?> submit(Callable task) - выполнение таски
// void execute(Runnable task) - выполнение таски без возвращения результата
// awaitTermination
// schedule

// Future
// cancel() прерывание таски
// get() возвращение результата (в случае использования Call