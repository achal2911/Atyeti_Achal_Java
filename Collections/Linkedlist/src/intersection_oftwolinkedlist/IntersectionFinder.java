package intersection_oftwolinkedlist;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class IntersectionFinder {
    public static void main(String[] args) {
        LinkedList<Integer> listA = new LinkedList<>(Arrays.asList(1, 2, 3, 6, 7, 8));
        LinkedList<Integer> listB = new LinkedList<>(Arrays.asList(9, 10, 6, 7, 8));

        System.out.println("List A: " + listA);
        System.out.println("List B: " + listB);

        Integer intersection = findIntersectionValue(listA, listB);

        if (intersection != null) {
            System.out.println("First common value: " + intersection);
        } else {
            System.out.println("No intersection found.");
        }
    }

    public static Integer findIntersectionValue(LinkedList<Integer> listA, LinkedList<Integer> listB) {
        Set<Integer> set = new HashSet<>(listA);
        for (int val : listB) {
            if (set.contains(val)) {
                return val;
            }
        }

        return null;
    }
}
