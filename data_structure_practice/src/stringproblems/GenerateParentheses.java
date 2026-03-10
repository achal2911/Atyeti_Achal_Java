package stringproblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
// Example 1: Input: n = 3Output: ["((()))","(()())","(())()","()(())","()()()"]
// Example 2: Input: n = 1Output: ["()"]


public class GenerateParentheses {
    public static List<String> generateValidParentheses(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private static void backtrack(List<String> result, String current, int openBracket, int closeBracket, int n) {
        //i.e. when String length is 2*n then we have valid combinations of parenthesis
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        if (openBracket < n) {
            backtrack(result, current + "(", openBracket + 1, closeBracket, n);
        }

        if (closeBracket < openBracket) {
            backtrack(result, current + ")", openBracket, closeBracket + 1, n);
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of pairs of parentheses (n): ");
        int n = sc.nextInt();

        List<String> result = generateValidParentheses(n);
        System.out.println("Well-formed parentheses for n = " + n + ":");
        System.out.println(result);

        sc.close();

    }
}
