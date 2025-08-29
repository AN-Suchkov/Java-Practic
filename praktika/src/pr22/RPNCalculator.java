package pr22;

import java.util.Stack;

public class  RPNCalculator {
    public static double evaluateRPN(String[] tokens) throws Exception {
        Stack<Double> stack = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "+":
                case "-":
                case "*":
                case "/":
                    if (stack.size() < 2) {
                        throw new Exception("Недостаточно элементов в стеке для операции '" + token + "'");
                    }
                    double b = stack.pop();
                    double a = stack.pop();
                    switch (token) {
                        case "+":
                            stack.push(a + b);
                            break;
                        case "-":
                            stack.push(a - b);
                            break;
                        case "*":
                            stack.push(a * b);
                            break;
                        case "/":
                            if (b == 0) {
                                throw new Exception("Деление на ноль невозможно");
                            }
                            stack.push(a / b);
                            break;
                    }
                    break;
                default:
                    try {
                        stack.push(Double.parseDouble(token));
                    } catch (NumberFormatException e) {
                        throw new Exception("Некорректный токен: '" + token + "'");
                    }
            }
        }

        if (stack.size() != 1) {
            throw new Exception("Некорректное выражение: остаток элементов в стеке " + stack.size());
        }

        return stack.pop();
    }
}
