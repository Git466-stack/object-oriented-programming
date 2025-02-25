// PalindromeChecker.java
class PalindromeChecker {
    // Attribute
    private String text;

    // Constructor to initialize the PalindromeChecker object
    public PalindromeChecker(String text) {
        this.text = text;
    }

    // Method to check if the text is a palindrome
    public boolean isPalindrome() {
        // Convert text to lowercase and remove spaces for uniformity
        String processedText = text.toLowerCase().replaceAll("\\s+", "");
        int left = 0;
        int right = processedText.length() - 1;

        while (left < right) {
            if (processedText.charAt(left) != processedText.charAt(right)) {
                return false; // Not a palindrome
            }
            left++;
            right--;
        }
        return true; // It's a palindrome
    }

    // Method to display the result
    public void displayResult() {
        if (isPalindrome()) {
            System.out.println("\"" + text + "\" is a palindrome.");
        } else {
            System.out.println("\"" + text + "\" is not a palindrome.");
        }
    }
}


public class Palindrome {
    public static void main(String[] args) {
        // Create a PalindromeChecker object
        PalindromeChecker checker1 = new PalindromeChecker("A man a plan a canal Panama");

        // Display the result
        checker1.displayResult();

        // Another example
        PalindromeChecker checker2 = new PalindromeChecker("Hello");
        checker2.displayResult();
    }
}
