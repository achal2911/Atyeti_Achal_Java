import java.util.HashMap;
import java.util.Map;

public class MergingOfTwoMaps {
    public static void main(String[] args) {
        Map<String, Integer> m1 = new HashMap<>();
        m1.put("a", 2);
        m1.put("b", 3);
        Map<String, Integer> m2 = new HashMap<>();
        m2.put("b", 1);
        m2.put("c", 4);
        for (Map.Entry<String, Integer> e : m2.entrySet()) {
            m1.put(e.getKey(), m1.getOrDefault(e.getKey(), 0) + e.getValue());
        }
        System.out.println(m1);
    }
}
