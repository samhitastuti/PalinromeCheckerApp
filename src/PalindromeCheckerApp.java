import java.util.*;

public class PalindromeCheckerApp {

    // 1️⃣ Two-Pointer Approach
    public static boolean twoPointerCheck(String input) {
        int left = 0;
        int right = input.length() - 1;

        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 2️⃣ Stack Approach
    public static boolean stackCheck(String input) {
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    // 3️⃣ Deque Approach
    public static boolean dequeCheck(String input) {
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

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== UC13: Performance Comparison ===");
        System.out.print("Enter a string: ");

        String input = scanner.nextLine();

        // Normalize input (ignore spaces & case)
        input = input.replaceAll("\\s+", "").toLowerCase();

        // 🔹 Measure Two-Pointer
        long start1 = System.nanoTime();
        boolean result1 = twoPointerCheck(input);
        long end1 = System.nanoTime();
        long time1 = end1 - start1;

        // 🔹 Measure Stack
        long start2 = System.nanoTime();
        boolean result2 = stackCheck(input);
        long end2 = System.nanoTime();
        long time2 = end2 - start2;

        // 🔹 Measure Deque
        long start3 = System.nanoTime();
        boolean result3 = dequeCheck(input);
        long end3 = System.nanoTime();
        long time3 = end3 - start3;

        // 🔹 Display Results
        System.out.println("\nResults:");
        System.out.println("Two-Pointer Result: " + result1 + " | Time: " + time1 + " ns");
        System.out.println("Stack Result:       " + result2 + " | Time: " + time2 + " ns");
        System.out.println("Deque Result:       " + result3 + " | Time: " + time3 + " ns");

        scanner.close();
    }
}