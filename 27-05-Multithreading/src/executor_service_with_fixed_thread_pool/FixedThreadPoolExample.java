package executor_service_with_fixed_thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FixedThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 10; i++) {
            final int taskId = i;
            executorService.submit(() ->
            {
                System.out.println("Task " + taskId + " is being executed by " + Thread.currentThread().getName());

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                    Thread.currentThread().interrupt();
                    System.err.println("Task " + taskId + " was interrupted");
                }
            });

        }
        executorService.shutdown();
        executorService.shutdown();
        try {
            // Wait for all tasks to complete or timeout after 60 seconds
            if (!executorService.awaitTermination(30, TimeUnit.SECONDS)) {
                executorService.shutdownNow(); // Force shutdown if tasks exceed timeout
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("All tasks finished.");

    }
}
