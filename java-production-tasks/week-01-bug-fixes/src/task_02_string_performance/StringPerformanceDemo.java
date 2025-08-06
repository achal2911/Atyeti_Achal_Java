package task_02_string_performance;

import java.util.Arrays;
import java.util.List;

public class StringPerformanceDemo {
    public static String buildReport(List<String> items) {
        String result = "";
        for (String item : items) {
            result = result + item + ", ";
        }
        return result;
    }

    public static String buildReportWithStringBuilder(List<String> items) {
        StringBuilder result = new StringBuilder();

        for (String item : items) {
            if (item != null) {
                result.append(item).append(", ");
            }
        }
        return result.toString();
    }


    public static void main(String[] args) {
        List<String> items = Arrays.asList("Item1", "Item2", "Item3", "Item4", "Item5", "Item6", "Item7", "Item8", "Item9", "Item10");
        long start = System.currentTimeMillis();
        String s = buildReport(items);
        long time1 = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        String b = buildReportWithStringBuilder(items);
        long time2 = System.currentTimeMillis() - start;

        System.out.println("String concat time: " + time1 + " ms");
        System.out.println("StringBuilder time: " + time2 + " ms");


    }
}
