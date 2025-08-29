package pr13;

public class Person {
    private String lastName;
    private String firstName;
    private String middleName;

    public Person(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    public String getShortName() {
        StringBuilder result = new StringBuilder();

        if (lastName != null && !lastName.isEmpty()) {
            result.append(lastName);
        }

        if (firstName != null && !firstName.isEmpty()) {
            result.append(" ");
            result.append(firstName.charAt(0)).append(".");
        }

        if (middleName != null && !middleName.isEmpty()) {
            result.append(middleName.charAt(0)).append(".");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Person person1 = new Person("Иванов", "Иван", "Иванович");
        Person person2 = new Person("Петров", "Петр", null);
        Person person3 = new Person("Сидоров", null, null);

        System.out.println(person1.getShortName());
        System.out.println(person2.getShortName());
        System.out.println(person3.getShortName());
    }
}
