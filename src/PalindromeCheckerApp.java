import java.util.Scanner;

public class PalindromeCheckerApp {

    // Method to check palindrome (iterative logic)
    public static boolean isPalindrome(String str) {

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {

            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Case-Insensitive & Space-Ignored Palindrome Checker ===");
        System.out.print("Enter a string: ");

        String input = scanner.nextLine();

        // 🔹 Step 1: Normalize string
        // Remove spaces using Regular Expression
        input = input.replaceAll("\\s+", "");

        // Convert to lowercase (ignore case)
        input = input.toLowerCase();

        // 🔹 Step 2: Apply palindrome logic
        boolean result = isPalindrome(input);

        if (result) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}