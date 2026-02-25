public class PalindromeCheckerUC3 {
    public static boolean isPalindrome(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }

    public static void main(String[] args) {
        String testString = "racecar";
        System.out.println("Is \"" + testString + "\" a palindrome? " + isPalindrome(testString));
    }
}