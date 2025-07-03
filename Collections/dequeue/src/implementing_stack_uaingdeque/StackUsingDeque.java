package implementing_stack_uaingdeque;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackUsingDeque {
    Deque<Integer> stack = new ArrayDeque<>();

    public void push(int x) {
        stack.addFirst(x);
    }

    public int pop() {
        return stack.removeFirst();
    }

    public int top() {
        return stack.peekFirst();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingDeque s = new StackUsingDeque();
        s.push(10);
        s.push(20);
        System.out.println("Top: " + s.top());
        System.out.println("Pop: " + s.pop());
        System.out.println("Is Empty: " + s.isEmpty());

    }
}
