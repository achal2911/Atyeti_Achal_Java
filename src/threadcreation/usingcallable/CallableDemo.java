package threadcreation.usingcallable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;

        for (int i = 1; i <= 10; i++) {
            sum += i;
        }

        return sum;
    }
}

public class CallableDemo {

    public static void main(String[] args) throws Exception {

        ExecutorService service = Executors.newSingleThreadExecutor();

        Future<Integer> result = service.submit(new MyCallable());

        System.out.println("Sum from Callable: " + result.get());

        service.shutdown();
    }
}
