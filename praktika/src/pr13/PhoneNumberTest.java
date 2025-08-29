package pr13;

public class PhoneNumberTest {
    public static void main(String[] args) {
        String[] phoneNumbers = {
                "+79175655655",
                "89175655655",
                "+104289652211",
                "+123456789012"
        };

        for (String number : phoneNumbers) {
            try {
                PhoneNumber phoneNumber = new PhoneNumber(number);
                System.out.println("Исходный: " + number);
                System.out.println("Форматированный: " + phoneNumber);
                System.out.println("------------");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
