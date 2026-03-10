package stringproblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void longestSubstringWithoutRepeating_HashSet(String s) {
        HashSet<Character> set = new HashSet<>();
        int j = 0;
        int maxlength = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            while (set.contains(currentChar)) {
                set.remove(s.charAt(j));
                j++;
            }
            set.add(currentChar);

            if (i - j + 1 > maxlength) {
                maxlength = i - j + 1;
                start = j;
            }
        }
        String longestSubstring = s.substring(start, start + maxlength);
        System.out.println("Longest Substring: " + longestSubstring);
        System.out.println("Length: " + maxlength);
    }

    //optimized one
    public static String longestSubstringWithoutRepeating_HashMap(String s) {
        int n = s.length();
        int maxLength = 0;
        int start = 0;
        int j = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char currentChar = s.charAt(i);

            if (map.containsKey(currentChar)) {
                j = Math.max(j, map.get(currentChar) + 1);
            }
            map.put(currentChar, i);

            if (i - j + 1 > maxLength) {
                maxLength = i - j + 1;
                start = j;
            }
        }


        return s.substring(start, start + maxLength);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String s = sc.nextLine();

        longestSubstringWithoutRepeating_HashSet(s);

//        String res = longestSubstringWithoutRepeating_HashMap(s);
//        System.out.println("Longest substring without repeating characters: " + res);


    }
}

//Given a string s, find the length of the longest # substring # without repeating characters.
// # Example 1: # Input: s = "abcabcbb" # Output: 3 # Explanation: The answer is "abc", with the length of 3.
// # Example 2: # Input: s = "bbbbb" # Output: 1 # Explanation: The answer is "b", with the length of 1.
// # Example 3: # Input: s = "pwwkew" # Output: 3 # Explanation: The answer is "wke", with the length of 3.
// # Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
// # Constraints: # • 0 <= s.length <= 5 * 104 # • s consists of English letters, digits, symbols and spaces.
