package pr8;

public class PrimeCheckTester {
    public static void main(String[] args) {
        int number = 29;
        if (PrimeCheck.isPrime(number)) {
            System.out.println(number + " — простое число.");
        } else {
            System.out.println(number + " — составное число.");
        }
    }
}
