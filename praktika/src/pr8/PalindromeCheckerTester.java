package pr8;

public class PalindromeCheckerTester {
    public static void main(String[] args) {
        String str = "racecar";
        if (PalindromeChecker.isPalindrome(str, 0, str.length() - 1)) {
            System.out.println(str + " является палиндромом.");
        } else {
            System.out.println(str + " не является палиндромом.");
        }
    }
}
