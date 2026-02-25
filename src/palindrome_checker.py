"""
UC5: Stack-Based Palindrome Checker
Goal: Use stack to reverse characters and validate palindrome.

Key Concepts:
- Stack: Linear data structure following LIFO (Last In First Out) principle
- Push Operation: Insert characters into the stack
- Pop Operation: Remove characters from the stack in reverse order
- Reversal Logic: Stack naturally reverses order for palindrome validation
"""

class Stack:
    """
    Stack implementation using a Python list.
    Follows LIFO (Last In First Out) principle.
    """
    
    def __init__(self):
        """Initialize an empty stack."""
        self.items = []
    
    def push(self, item):
        """
        Push operation: Insert an item onto the stack.
        
        Args:
            item: The character or element to push
        """
        self.items.append(item)
    
    def pop(self):
        """
        Pop operation: Remove and return the top item from the stack.
        
        Returns:
            The item at the top of the stack
            
        Raises:
            IndexError: If stack is empty
        """
        if not self.is_empty():
            return self.items.pop()
        return None
    
    def is_empty(self):
        """
        Check if the stack is empty.
        
        Returns:
            True if stack is empty, False otherwise
        """
        return len(self.items) == 0
    
    def peek(self):
        """
        View the top item without removing it.
        
        Returns:
            The top item or None if empty
        """
        if not self.is_empty():
            return self.items[-1]
        return None
    
    def size(self):
        """
        Get the number of items in the stack.
        
        Returns:
            The size of the stack
        """
        return len(self.items)
    
    def display(self):
        """Display all items in the stack."""
        return self.items


class PalindromeChecker:
    """
    Check if a string is a palindrome using a stack data structure.
    """
    
    def __init__(self):
        """Initialize the palindrome checker."""
        self.stack = Stack()
    
    def check_palindrome(self, text):
        """
        Check if a given text is a palindrome using stack reversal.
        
        Process:
        1. Push all characters from the first half into the stack
        2. Pop characters and compare with second half
        3. Return True if all match, False otherwise
        
        Args:
            text (str): The string to check for palindrome
            
        Returns:
            tuple: (is_palindrome: bool, original: str, reversed: str)
        """
        # Clean the input: convert to lowercase and remove spaces/special characters
        cleaned_text = ''.join(char.lower() for char in text if char.isalnum())
        
        if not cleaned_text:
            return True, text, "Empty string"
        
        # Calculate the midpoint
        length = len(cleaned_text)
        mid_point = length // 2
        
        # Push first half of characters onto stack
        print(f"\n--- Pushing characters into stack (first half) ---")
        for i in range(mid_point):
            char = cleaned_text[i]
            self.stack.push(char)
            print(f"Push '{char}' -> Stack: {self.stack.display()}")
        
        # Handle odd-length strings by skipping the middle character
        start_comparison = mid_point + (1 if length % 2 == 1 else 0)
        
        # Pop and compare with second half
        print(f"\n--- Popping characters and comparing with second half ---")
        reversed_chars = []
        is_palindrome = True
        
        for i in range(start_comparison, length):
            popped_char = self.stack.pop()
            current_char = cleaned_text[i]
            reversed_chars.append(popped_char)
            
            match = "✓" if popped_char == current_char else "✗"
            print(f"Pop '{popped_char}' vs Compare '{current_char}' {match} -> Stack: {self.stack.display()}")
            
            if popped_char != current_char:
                is_palindrome = False
        
        reversed_str = ''.join(reversed_chars)
        return is_palindrome, cleaned_text, reversed_str
    
    def print_result(self, text, is_palindrome, original, reversed_str):
        """
        Print the result of palindrome check in a formatted way.
        
        Args:
            text (str): Original input text
            is_palindrome (bool): Whether text is palindrome
            original (str): Cleaned original string
            reversed_str (str): Reversed string from stack
        """
        print(f"\n{'='*60}")
        print(f"PALINDROME CHECK RESULT")
        print(f"{'='*60}")
        print(f"Original Input:  '{text}'")
        print(f"Cleaned Text:    '{original}'")
        print(f"Reversed Text:   '{reversed_str}'")
        print(f"Is Palindrome:   {'YES ✓' if is_palindrome else 'NO ✗'}")
        print(f"{'='*60}\n")


def main():
    """Main function to demonstrate palindrome checking."""
    
    print("\n" + "="*60)
    print("UC5: STACK-BASED PALINDROME CHECKER")
    print("="*60)
    
    checker = PalindromeChecker()
    
    # Test cases
    test_cases = [
        "racecar",
        "hello",
        "A man, a plan, a canal: Panama",
        "12321",
        "12345",
        "Madam",
        "Was it a car or a cat I saw?",
        "Python",
        "noon",
        "world"
    ]
    
    for test_case in test_cases:
        # Reset stack for each test
        checker.stack = Stack()
        
        # Check palindrome
        is_palindrome, original, reversed_str = checker.check_palindrome(test_case)
        
        # Print result
        checker.print_result(test_case, is_palindrome, original, reversed_str)


if __name__ == "__main__":
    main()