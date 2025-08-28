package stringproblems;


import java.util.*;

public class ReverseVowelsInString {

    //Given a string s, reverse only the vowels of the string and return it.
    // Input: s = "hello" Output: "holle"


    public static String reverseVowels(String str) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (vowels.contains(ch)) {
                stack.push(ch);
            }
        }

        StringBuilder builder = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (vowels.contains(ch)) {
                builder.append(stack.pop());
            } else {
                builder.append(ch);
            }
        }
        return builder.toString();
    }

    public static String reverseVowelsTwoPointer(String str) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] charArray = str.toCharArray();
        int left = 0, right = charArray.length - 1;

        while (left < right) {
            if (!vowels.contains(charArray[left])) {
                left++;
            } else if (!vowels.contains(charArray[right])) {
                right--;
            } else {
                char temp = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = temp;
                left++;
                right--;
            }
        }
        return new String(charArray);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String:");
        String s = sc.next();

        System.out.println("String with reversed vowels:");
        System.out.println(reverseVowelsTwoPointer(s));

    }
}
