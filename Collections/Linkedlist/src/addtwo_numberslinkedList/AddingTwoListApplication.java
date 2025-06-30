package addtwo_numberslinkedList;

import java.util.Arrays;
import java.util.LinkedList;

public class AddingTwoListApplication
{
    public static void main(String[] args)
    {
    LinkedList<Integer> l1 = new LinkedList<>(Arrays.asList(2, 4,3));
    LinkedList<Integer> l2 = new LinkedList<>(Arrays.asList(5, 6, 4));

    LinkedListAddition addition = new LinkedListAddition();

    System.out.print("List 1: ");
    addition.printList(l1);

    System.out.print("List 2: ");
    addition.printList(l2);

    LinkedList<Integer> result = addition.addTwoLists(l1, l2);

    System.out.print("Result : ");
    addition.printList(result);
    }


}
