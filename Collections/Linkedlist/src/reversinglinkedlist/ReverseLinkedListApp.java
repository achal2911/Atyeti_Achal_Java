package reversinglinkedlist;

import java.util.Arrays;
import java.util.LinkedList;

public class ReverseLinkedListApp
{
    public static void main(String[] args)
    {
        LinkedList<Integer> original = new LinkedList<>();
        original.add(10);
        original.add(20);
        original.add(30);

        LinkedList<Integer> reversed = LinkedListReverser.reverseManually(original);
        System.out.println(reversed);

    }
}
