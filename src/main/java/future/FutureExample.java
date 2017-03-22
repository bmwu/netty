package future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by michael on 3/22/17.
 */
public class FutureExample {

    public static void main(String[] args) throws Exception {

        ExecutorService executorService = Executors.newCachedThreadPool();

        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable");
            }
        };

        // 等同于task1
        Runnable task2 = () -> System.out.println("runnable+lambda");

        Callable<Integer> task3 = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return new Integer(100);
            }
        };

        // 等同于task3
        Callable<Integer> task4 = () -> new Integer(200);

        Future<?> future = executorService.submit(task1);
        Future future1 = executorService.submit(task2);

        Future<Integer> future2 = executorService.submit(task3);
        Future<Integer> future3 = executorService.submit(task4);

        while(future.isDone()) {
            System.out.println("task1 done");
            break;
        }

        while(future1.isDone()) {
            System.out.println("task2 done");
            break;
        }

        while(future2.isDone()) {
            System.out.println("task3 done: " + future2.get());
            break;
        }

        while(future3.isDone()) {
            System.out.println("task4 done: " + future3.get());
            break;
        }

    }
}
