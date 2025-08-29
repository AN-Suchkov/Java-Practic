package pr8;

public class SumOfDigits_Tester {
    public static void main(String[] args) {
        int N = 1234577; // Пример числа
        int result = SumOfDigits.sum_of_digits(N);
        System.out.println("Сумма цифр числа " + N + " равна " + result);
    }
}
