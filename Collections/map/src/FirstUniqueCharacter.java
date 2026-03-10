import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueCharacter
{
    public static void main(String[] args) {
        String s = "swiss";
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println(entry.getKey());
                return;
            }
        }
    }
}
