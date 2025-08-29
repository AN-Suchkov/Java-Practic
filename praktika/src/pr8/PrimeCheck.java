package pr8;

public class PrimeCheck {

    public static boolean isPrime(int n) {
        return isPrimeHelper(n, 2);
    }

    private static boolean isPrimeHelper(int n, int divisor) {
        if (divisor * divisor > n) {
            return true;
        }
        if (n % divisor == 0) {
            return false;
        }
        return isPrimeHelper(n, divisor + 1);
    }


}
