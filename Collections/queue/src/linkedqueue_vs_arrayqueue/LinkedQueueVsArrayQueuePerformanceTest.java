package linkedqueue_vs_arrayqueue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class LinkedQueueVsArrayQueuePerformanceTest {
    public static void main(String[] args) {

        Queue<Integer> linkedQueue = new LinkedList<>();
        Queue<Integer> arrayQueue = new ArrayDeque<>();

        long start1 = System.nanoTime();

        for (int i = 1; i < 100000; i++) {
            linkedQueue.offer(i);
        }

        for (int i = 1; i < 100000; i++) {
            arrayQueue.poll();
        }

        long end1 = System.nanoTime();
        System.out.println("LinkedList Queue time: " + (end1 - start1) / 1_000_000.0 + " ms");

        Long start2 = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            arrayQueue.offer(i);
        }
        for (int i = 0; i < 1000000; i++) {
            arrayQueue.poll();
        }
        long end2 = System.nanoTime();
        System.out.println("ArrayDeque Queue time: " + (end2 - start2) / 1_000_000.0 + " ms");
    }
}
