import java.util.LinkedList;

public class LinkedListPalindromeChecker {

    // Function to check if the linked list is a palindrome
    public boolean isPalindrome(LinkedList<Integer> list) {
        if (list.isEmpty()) {
            return true;
        }

        // Use fast and slow pointers to find the middle of the linked list
        int slow = 0, fast = 0;
        while (fast < list.size() - 1 && fast + 1 < list.size()) {
            slow++;
            fast += 2;
        }

        // If the list has an odd length, skip the middle element
        if (fast == list.size() - 1) {
            slow++;
        }

        // Reverse the second half of the list
        LinkedList<Integer> secondHalf = new LinkedList<>();
        for (int i = slow; i < list.size(); i++) {
            secondHalf.addFirst(list.get(i));
        }

        // Compare the first half and the second half
        for (int i = 0; i < slow; i++) {
            if (!list.get(i).equals(secondHalf.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LinkedListPalindromeChecker checker = new LinkedListPalindromeChecker();
        LinkedList<Integer> list = new LinkedList<>();
        // Example usage
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(1);
        System.out.println("Is palindrome: " + checker.isPalindrome(list)); // Should print true
    }
}