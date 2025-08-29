package pr13;

public class PhoneNumber {
    private String formattedNumber;

    // Конструктор принимает строку с номером
    public PhoneNumber(String input) {
        this.formattedNumber = formatNumber(input);
    }

    // Метод для форматирования номера
    private String formatNumber(String input) {
        String cleanedNumber;
        String countryCode;

        if (input.startsWith("+")) {
            // Убираем символ '+' и выделяем код страны
            cleanedNumber = input.substring(1);
            countryCode = cleanedNumber.substring(0, cleanedNumber.length() - 10);
            cleanedNumber = cleanedNumber.substring(cleanedNumber.length() - 10);
        } else if (input.startsWith("8") && input.length() == 11) {
            // Для России заменяем '8' на '+7'
            countryCode = "7";
            cleanedNumber = input.substring(1);
        } else {
            throw new IllegalArgumentException("Некорректный формат номера: " + input);
        }

        // Используем StringBuilder для создания итоговой строки
        StringBuilder formatted = new StringBuilder();
        formatted.append("+").append(countryCode).append(" ")
                .append(cleanedNumber.substring(0, 3)).append("-")
                .append(cleanedNumber.substring(3, 6)).append("-")
                .append(cleanedNumber.substring(6));

        return formatted.toString();
    }


    // Метод для получения форматированного номера
    public String getFormattedNumber() {
        return formattedNumber;
    }

    // Переопределение toString для удобства
    @Override
    public String toString() {
        return formattedNumber;
    }
}
