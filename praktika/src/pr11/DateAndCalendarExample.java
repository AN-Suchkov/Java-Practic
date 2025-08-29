package pr11;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DateAndCalendarExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Введите год:");
            int year = scanner.nextInt();

            System.out.println("Введите месяц (1-12):");
            int month = scanner.nextInt() - 1;

            System.out.println("Введите число (1-31):");
            int day = scanner.nextInt();

            System.out.println("Введите часы (0-23):");
            int hour = scanner.nextInt();

            System.out.println("Введите минуты (0-59):");
            int minute = scanner.nextInt();

            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month, day, hour, minute);

            Date date = calendar.getTime();

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");

            System.out.println("Сформированный объект Date: " + dateFormat.format(date));
            System.out.println("Сформированный объект Calendar: " + calendar.getTime());
        } catch (Exception e) {
            System.out.println("Ошибка ввода данных. Пожалуйста, проверьте введённые значения.");
        }
    }
}
