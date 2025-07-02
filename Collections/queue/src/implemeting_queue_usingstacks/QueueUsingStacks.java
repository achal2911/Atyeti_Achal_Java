package implemeting_queue_usingstacks;

import java.util.Stack;

public class QueueUsingStacks {
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();


    public void enqueue(int x) {
        input.push(x);
    }

    public int dequeue() {
        if (output.isEmpty()) {
            while (!input.isEmpty())
                output.push(input.pop());
        }
        return output.isEmpty() ? -1 : output.pop();
    }

    @Override
    public String toString() {
        return "" + output;
    }

    public static void main(String[] args) {
        QueueUsingStacks stacks = new QueueUsingStacks();
        stacks.enqueue(10);
        stacks.enqueue(20);
        stacks.enqueue(20);

        System.out.println(stacks.dequeue());
        System.out.println(stacks);
    }
}
