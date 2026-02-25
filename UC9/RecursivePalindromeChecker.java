public class RecursivePalindromeChecker {
    public static void main(String[] args) {
        String testString = "A man a plan a canal Panama";
        boolean isPalindrome = isPalindrome(testString.replaceAll("\\s+", "").toLowerCase());
        System.out.println("Is the string a palindrome? " + isPalindrome);
    }

    public static boolean isPalindrome(String str) {
        // Base condition: If the length is 0 or 1, it's a palindrome
        if (str.length() <= 1) {
            return true;
        }
        // Check the first and last characters
        if (str.charAt(0) != str.charAt(str.length() - 1)) {
            return false;
        }
        // Recursive call removing the first and last character
        return isPalindrome(str.substring(1, str.length() - 1));
    }
}