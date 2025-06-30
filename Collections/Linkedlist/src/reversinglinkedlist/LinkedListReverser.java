package reversinglinkedlist;

import java.util.LinkedList;


public class LinkedListReverser
{
    public static <T> LinkedList<T> reverseManually(LinkedList<T> input)
    {
        LinkedList<T> reversed = new LinkedList<>();
        for (T item : input) {
            reversed.addFirst(item);
        }
        return reversed;
    }
}
