import java.util.Deque;
import java.util.LinkedList;

public class PalindromeCheckerUC7 {

    public static boolean isPalindrome(String str) {
        // Normalizing the string by removing spaces and converting to lower case
        str = str.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new LinkedList<>();

        // Adding characters to the deque
        for (char ch : str.toCharArray()) {
            deque.addLast(ch);
        }

        // Check characters from front and rear
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false; // Not a palindrome
            }
        }
        return true; // Is a palindrome
    }

    public static void main(String[] args) {
        String testString = "A man a plan a canal Panama";
        System.out.println(testString + " : " + (isPalindrome(testString) ? "is a palindrome" : "is not a palindrome"));
    }
}