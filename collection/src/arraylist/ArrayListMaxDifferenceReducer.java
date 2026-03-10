package arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/*
* Add elements in ArrayList
Find max element from the ArrayList and remove it from the ArrayList
Now again find the max element (which will be the second largest element in the original array) from the ArrayList and remove it
Take the difference of the two elements and add difference in the ArrayList
Run step 2 to step 4 till ArrayList.size() != 1
Return the last element left in ArrayList*/


public class ArrayListMaxDifferenceReducer {
    public static int reducingArrayList(List<Integer> integerList) {
        while (integerList.size() > 1) {
            int max1 = Collections.max(integerList);
            integerList.remove(Integer.valueOf(max1));

            int max2 = Collections.max(integerList);
            integerList.remove(Integer.valueOf(max2));

            int diff = max1 - max2;
            integerList.add(diff);

            System.out.println("Updated list: " + integerList);
        }
        return integerList.getFirst();
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(10, 5, 8, 4, 6, -9));

        int result = reducingArrayList(list);
        System.out.println("last element in the arraylist: " + result);

    }
}
