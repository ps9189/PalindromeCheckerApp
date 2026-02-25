// PalindromeCheckerService.java

/**
 * PalindromeCheckerService provides functionality to check if a given string is a palindrome.
 * This class adheres to the Single Responsibility Principle by encapsulating the palindrome-checking logic.
 */
public class PalindromeCheckerService {
    
    /**
     * Checks if the input string is a palindrome.
     * A palindrome is a word, phrase, number, or other sequence of characters that reads the same forward and backward.
     * 
     * @param input the string to check
     * @return true if the input string is a palindrome, false otherwise
     */
    public boolean isPalindrome(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        String cleanedInput = input.replaceAll("\\W+", "").toLowerCase();
        String reversedInput = new StringBuilder(cleanedInput).reverse().toString();
        return cleanedInput.equals(reversedInput);
    }
}