package labOne;

public class Palindrome {
    public static void main(String[] args) {
        for (String word : args) {
            System.out.println(word + " is " + (isPalindrome(word) ? "a palindrome." : "not a palindrome."));
        }
    }

    public static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static boolean isPalindrome(String s) {
        return s.equals(reverseString(s));
    }
}