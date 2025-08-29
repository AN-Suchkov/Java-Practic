package pr8;

public class PrimeFactorization {
    public static void primeFactors(int n, int i) {
        // База
        if (i * i > n) {
            if (n > 1) {
                System.out.println(n);
            }
            return;
        }

        while (n % i == 0) {
            System.out.println(i);
            n /= i;
        }

        if (i == 2) {
            primeFactors(n, 3);
        } else {
            primeFactors(n, i + 2);
        }
    }

}
