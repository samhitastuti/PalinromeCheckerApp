import java.util.Scanner;
import java.util.Stack;

// Service class responsible only for palindrome logic
class PalindromeChecker {

    // Public method exposed to outside world
    public boolean checkPalindrome(String input) {

        // Normalize string (ignore case & spaces)
        input = input.replaceAll("\\s+", "").toLowerCase();

        Stack<Character> stack = new Stack<>();
        char[] charArray = input.toCharArray();

        // Push all characters into stack
        for (char ch : charArray) {
            stack.push(ch);
        }

        // Compare original string with reversed (using stack)
        for (char ch : charArray) {
            if (ch != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

// Main Application class
public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== OOPS Based Palindrome Checker ===");
        System.out.print("Enter a string: ");

        String input = scanner.nextLine();

        // Create object of service class
        PalindromeChecker checker = new PalindromeChecker();

        boolean result = checker.checkPalindrome(input);

        if (result) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}