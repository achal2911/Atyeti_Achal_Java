package multi_threaded_counter_app;

import java.util.Scanner;

public class MultiThreadedCounter {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number Of Threads:");
        int numOfThread = sc.nextInt();

        SharedCounter counter = new SharedCounter();
        Thread[] threads = new Thread[numOfThread];
        for (int i = 0; i < numOfThread; i++) {
            threads[i] = new Thread(new IncrementTask(counter));
            threads[i].start();
        }


        // Wait for all threads to finish
        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Final count: " + counter.getCount());
        System.out.println("Expected count: " + (numOfThread * 1000));

//using ExecutorService
//        // Executor service to manage threads
//        ExecutorService executor= Executors.newFixedThreadPool(numOfThread);
//
//        SharedCounter counter=new SharedCounter();
//
//        // Submit N tasks to the executor
//        for(int i=0;i<numOfThread;i++)
//        {
//            executor.submit(new IncrementTask(counter));
//        }
//
//        // Shutdown the executor and wait for all tasks to finish
//        executor.shutdown();
//        while (!executor.isTerminated()) {
//            Thread.sleep(100);
//        }


    }
}
