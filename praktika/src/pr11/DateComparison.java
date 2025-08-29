package pr11;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateComparison {
    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        dateFormat.setLenient(false);

        Date currentDate = new Date();

        System.out.println("Текущая дата и время: " + dateFormat.format(currentDate));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дату и время в формате dd.MM.yyyy HH:mm:");
        String userInput = scanner.nextLine();

        try {
            Date userDate = dateFormat.parse(userInput);

            if (userDate.before(currentDate)) {
                System.out.println("Введённая дата раньше текущей.");
            } else if (userDate.after(currentDate)) {
                System.out.println("Введённая дата позже текущей.");
            } else {
                System.out.println("Введённая дата совпадает с текущей.");
            }
        } catch (ParseException e) {
            System.out.println("Ошибка: введённая дата имеет неверный формат.");
        }
    }
}
