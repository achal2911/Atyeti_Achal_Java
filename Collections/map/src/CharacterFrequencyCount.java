import java.util.HashMap;
import java.util.Map;

public class CharacterFrequencyCount {
    public static void main(String[] args) {
        String input = "Hello World";
        Map<Character, Integer> map = new HashMap<>();
        for (char c : input.toLowerCase().toCharArray()) {
            if (c != ' ')
                map.put(c, map.getOrDefault(c, 0) + 1);
        }
        System.out.println(map);
    }
}
