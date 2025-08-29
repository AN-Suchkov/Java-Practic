package pr19;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;



public class LabClassUI {
    private LabClass labClass = new LabClass();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("\n1. Добавить студента");
            System.out.println("2. Найти студента");
            System.out.println("3. Отсортировать студентов по среднему баллу");
            System.out.println("4. Показать всех студентов");
            System.out.println("5. Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> findStudent();
                case 3 -> sortStudents();
                case 4 -> showAllStudents();
                case 5 -> {
                    System.out.println("Выход из программы...");
                    return;
                }
                default -> System.out.println("Неверный выбор, попробуйте снова.");
            }
        }
    }

    private void addStudent() {
        System.out.println("Введите ФИО студента:");
        String fullName = scanner.nextLine();

        try {
            if (fullName.trim().isEmpty()) {
                throw new EmptyStringException("Ошибка: ФИО не может быть пустым.");
            }

            if (!fullName.matches("[a-zA-Zа-яА-ЯёЁ ]+")) {
                System.out.println("Ошибка: ФИО может содержать только буквы и пробелы.");
                return;
            }

        } catch (EmptyStringException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("Введите средний балл студента:");

        try {
            double averageScore = scanner.nextDouble();

            if (averageScore < 0 || averageScore > 100) {
                throw new IllegalArgumentException("Средний балл должен быть в пределах от 0 до 100.");
            }

            labClass.addStudent(new Student(fullName, averageScore));
            System.out.println("Студент добавлен.");

        } catch (InputMismatchException e) {
            System.out.println("Ошибка: Пожалуйста, введите число для среднего балла.");
            scanner.nextLine();  // Очищаем буфер ввода
        } catch (IllegalArgumentException e){
            System.out.println("Ошибка: Пожалуйста, введите число от 0 до 100");
            scanner.nextLine();
        }
    }

    private void findStudent() {
        System.out.println("Введите ФИО студента для поиска:");
        String fullName = scanner.nextLine();
        try {
            Student student = labClass.findStudent(fullName);
            System.out.println("Найден студент: " + student);
        } catch (StudentNotFoundException | EmptyStringException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    private void sortStudents() {
        labClass.sortStudentsByAverageScore();
        System.out.println("Студенты отсортированы по среднему баллу.");
    }

    private void showAllStudents() {
        List<Student> students = labClass.getStudents();
        if (students.isEmpty()) {
            System.out.println("Список студентов пуст.");
        } else {
            students.forEach(System.out::println);
        }
    }
}



