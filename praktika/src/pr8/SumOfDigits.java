package pr8;

public class SumOfDigits {
    public static int sum_of_digits(int n){
        if (n/10 == 0) return n%10;
        return n%10 + sum_of_digits(n/10);
    }
}
