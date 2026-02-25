/**
 * UC2: Print a Hardcoded Palindrome Result
 * 
 * Goal: Display whether a hardcoded string is a palindrome.
 * 
 * Key Concepts:
 * - Class: Container for program logic
 * - Main Method: Entry point with signature public static void main(String[] args)
 * - Static Keyword: Allows JVM to invoke main() without object instantiation
 * - String: Built-in Java class to store and manipulate textual data
 * - String Literal: Text enclosed within double quotes, stored in String constant pool
 * - Conditional Statement (if-else): Evaluates palindrome condition
 * - Console Output: System.out.println() for displaying results
 * 
 * Actor: User
 * Flow:
 * 1. Program starts
 * 2. Hardcoded string is checked for palindrome
 * 3. Result is printed
 * 4. Program exits
 * 
 * Data Structure: String
 */
public class PalindromeCheckerUC2 {
    
    /**
     * Main method - Entry point of the Java application
     * Signature: public static void main(String[] args)
     * 
     * @param args Command line arguments (not used in UC2)
     */
    public static void main(String[] args) {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("UC2: HARDCODED PALINDROME RESULT");
        System.out.println("=".repeat(70) + "\n");
        
        // Step 1: Define hardcoded strings to check
        String[] hardcodedStrings = {
            "madam",
            "racecar",
            "hello",
            "noon",
            "level",
            "world",
            "civic",
            "python"
        };
        
        // Step 2: Check each hardcoded string
        System.out.println("Checking Hardcoded Palindromes:\n");
        
        for (String str : hardcodedStrings) {
            // Call method to check palindrome
            boolean isPalindrome = checkPalindrome(str);
            
            // Step 3: Print result
            String result = isPalindrome ? "YES ✓ (PALINDROME)" : "NO ✗ (NOT A PALINDROME)";
            System.out.println("String: \"" + str + "\" => " + result);
        }
        
        System.out.println("\n" + "=".repeat(70));
        System.out.println("Program executed successfully. Exiting...");
        System.out.println("=".repeat(70) + "\n");
        
        // Step 4: Program exits
    }
    
    /**
     * Method to check if a string is a palindrome
     * 
     * Logic:
     * - Compare the string with its reverse
     * - If they are equal, it's a palindrome
     * - Otherwise, it's not a palindrome
     * 
     * @param str The string to check
     * @return true if palindrome, false otherwise
     */
    private static boolean checkPalindrome(String str) {
        // Convert to lowercase for case-insensitive comparison
        String original = str.toLowerCase();
        
        // Reverse the string using StringBuilder
        String reversed = new StringBuilder(original).reverse().toString();
        
        // Use if-else conditional statement to evaluate palindrome condition
        if (original.equals(reversed)) {
            return true;  // String is a palindrome
        } else {
            return false; // String is not a palindrome
        }
    }
}