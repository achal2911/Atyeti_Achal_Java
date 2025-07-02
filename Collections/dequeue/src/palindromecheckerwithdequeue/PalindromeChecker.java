package palindromecheckerwithdequeue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PalindromeChecker {
    public static boolean isPalindrome(String input) {
        Deque<Character> deque = new ArrayDeque<>();
        String clean = input.toLowerCase();

        for (char c : clean.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();
            if (front != rear) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print(" Enter a string to check for palindrome: ");
        String input = sc.nextLine();

        boolean result = isPalindrome(input);
        System.out.println(result ? " It IS a palindrome!" : " Not a palindrome.");
    }
}
