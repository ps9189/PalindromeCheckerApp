import java.util.Arrays;

public class PerformanceComparison {

    public static void main(String[] args) {
        String testString = "A man, a plan, a canal, Panama!";
        System.out.println("Performance Comparison of Palindrome Algorithms:\n");

        comparePerformance(testString);
    }

    private static void comparePerformance(String str) {
        // Remove non-alphanumeric characters and convert to lower case
        String cleanedString = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Measure performance of different algorithms
        long startTime, endTime;

        // Algorithm 1: Reverse method
        startTime = System.nanoTime();
        boolean isPalindrome1 = isPalindromeReverse(cleanedString);
        endTime = System.nanoTime();
        System.out.printf("Algorithm 1 (Reverse Method): %s, Time: %d ns\n", isPalindrome1, (endTime - startTime));

        // Algorithm 2: Two Pointer Method
        startTime = System.nanoTime();
        boolean isPalindrome2 = isPalindromeTwoPointer(cleanedString);
        endTime = System.nanoTime();
        System.out.printf("Algorithm 2 (Two Pointer Method): %s, Time: %d ns\n", isPalindrome2, (endTime - startTime));
    }

    private static boolean isPalindromeReverse(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }

    private static boolean isPalindromeTwoPointer(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}