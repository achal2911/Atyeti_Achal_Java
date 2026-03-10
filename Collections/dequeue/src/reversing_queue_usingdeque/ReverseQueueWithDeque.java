package reversing_queue_usingdeque;

import java.util.*;

public class ReverseQueueWithDeque {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        Deque<Integer> deque = new ArrayDeque<>();

        while (!queue.isEmpty()) {
            deque.addFirst(queue.poll());
        }


        while (!deque.isEmpty()) {
            queue.offer(deque.pollFirst());
        }

        System.out.println("Reversed Queue: " + queue);
    }
}
