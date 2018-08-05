package thread;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

/**
 * Create by fengguofei
 * Date: 2018/5/20
 * Time: 13:05
 */
public class ExecutorServiceDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Future future = executorService.submit(new Callable(){
            @Override
            public Object call() throws Exception {
                System.out.println("Asynchonous Callable");
                return "Callable Result";
            }
        });

        System.out.println("future.get() = " + future.get());

        ExecutorService executorService1 = Executors.newSingleThreadExecutor();

        Set<Callable<String>> callables = new HashSet<>();

        callables.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Task 1";
            }
        });

        callables.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Task 2";
            }
        });

        callables.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Task 3";
            }
        });

        List<Future<String>> result = executorService1.invokeAll(callables);

        for(Future<String> future1:result){
            System.out.println("future.get = " + future1.get());
        }
        executorService1.shutdown();

    }
}

