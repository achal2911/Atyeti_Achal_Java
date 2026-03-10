import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] words = {"cat", "tac", "dog", "god", "act"};
        Map<String, List<String>> map = new HashMap<>();
        for (String word : words) {
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }
        System.out.println(new ArrayList<>(map.values()));
    }
}
