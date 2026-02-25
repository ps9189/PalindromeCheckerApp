import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PalindromeCheckerUC6 {

    public static void main(String[] args) {
        String str = "A man, a plan, a canal, Panama";
        System.out.println("Is \"" + str + "\" a palindrome? ");
        System.out.println(checkPalindrome(str));
    }

    public static boolean checkPalindrome(String str) {
        // Normalize the input string
        String cleanedStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for (char c : cleanedStr.toCharArray()) {
            queue.add(c);  // Enqueue operation
            stack.push(c);  // Push operation
        }

        // Compare elements from Queue and Stack
        while (!queue.isEmpty()) {
            char queueChar = queue.poll();  // Dequeue operation
            char stackChar = stack.pop();   // Pop operation

            if (queueChar != stackChar) {
                return false;
            }
        }
        return true;
    }
}