package pr22;

import java.util.Scanner;

public class RPNCalculatorTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите выражения в обратной польской нотации, разделяя элементы пробелами.");
        System.out.println("Введите пустую строку, чтобы завершить ввод.");

        while (true) {
            System.out.print("Выражение: ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Ввод завершен.");
                break;
            }

            String[] tokens = input.split(" ");
            testExpression(tokens);
        }

        scanner.close();
    }

    public static void testExpression(String[] expression) {
        try {
            System.out.println("Выражение: " + String.join(" ", expression));
            double result = RPNCalculator.evaluateRPN(expression);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println();
    }
}
