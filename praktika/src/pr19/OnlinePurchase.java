package pr19;

import java.util.Scanner;

class InvalidInnException extends Exception {
    public InvalidInnException(String message, Throwable err) {
        super(message, err);
    }
}

public class OnlinePurchase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Введите ваше ФИО:");
            String fullName = scanner.nextLine();

            System.out.println("Введите ваш номер ИНН:");
            String inn = scanner.nextLine();

            if (!isValidInn(inn)) {
                throw new InvalidInnException("Введен недействительный номер ИНН!", new IllegalArgumentException("Номер ИНН должен содержать только цифры и быть длиной 10 или 12 символов."));
            }

            System.out.println("Заказ успешно оформлен на имя: " + fullName);

        } catch (InvalidInnException e) {
            System.err.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static boolean isValidInn(String inn) {
        return inn.matches("\\d{10}|\\d{12}");
    }
}
