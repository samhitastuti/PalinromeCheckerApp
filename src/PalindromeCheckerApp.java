import java.util.*;

// 1️⃣ Strategy Interface
interface PalindromeStrategy {
    boolean checkPalindrome(String input);
}

// 2️⃣ Stack-Based Strategy
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean checkPalindrome(String input) {

        input = input.replaceAll("\\s+", "").toLowerCase();

        Stack<Character> stack = new Stack<>();
        char[] chars = input.toCharArray();

        for (char c : chars) {
            stack.push(c);
        }

        for (char c : chars) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

// 3️⃣ Deque-Based Strategy
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean checkPalindrome(String input) {

        input = input.replaceAll("\\s+", "").toLowerCase();

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }
}

// 4️⃣ Context Class
class PalindromeContext {

    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean execute(String input) {
        return strategy.checkPalindrome(input);
    }
}

// 5️⃣ Main Application
public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Strategy Pattern Palindrome Checker ===");
        System.out.println("Choose Algorithm:");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");
        System.out.print("Enter choice (1 or 2): ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        PalindromeContext context = new PalindromeContext();

        // Inject strategy dynamically at runtime
        if (choice == 1) {
            context.setStrategy(new StackStrategy());
        } else if (choice == 2) {
            context.setStrategy(new DequeStrategy());
        } else {
            System.out.println("Invalid choice.");
            scanner.close();
            return;
        }

        boolean result = context.execute(input);

        if (result) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}