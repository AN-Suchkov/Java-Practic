package pr11;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DeveloperInfo {
    public static void main(String[] args) {
        String developerSurname = "Сучков";
        String taskReceivedDate = "03.09.2024 12:40";

        Date submissionDate = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");

        System.out.println("Фамилия разработчика: " + developerSurname);
        System.out.println("Дата и время получения задания: " + taskReceivedDate);
        System.out.println("Дата и время сдачи задания: " + dateFormat.format(submissionDate));
    }
}
