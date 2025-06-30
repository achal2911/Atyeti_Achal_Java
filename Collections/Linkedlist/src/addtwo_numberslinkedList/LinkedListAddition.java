package addtwo_numberslinkedList;

import java.util.LinkedList;

public class LinkedListAddition
{
    public LinkedList<Integer> addTwoLists(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        LinkedList<Integer> result = new LinkedList<>();

        int carry = 0;
        int i = 0, j = 0;

        while (i < l1.size() || j < l2.size() || carry > 0) {
            int val1 = i < l1.size() ? l1.get(i) : 0;
            int val2 = j < l2.size() ? l2.get(j) : 0;

            int sum = val1 + val2 + carry;
            result.add(sum % 10);
            carry = sum / 10;

            i++;
            j++;
        }

        return result;
    }

    public void printList(LinkedList<Integer> list) {
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
