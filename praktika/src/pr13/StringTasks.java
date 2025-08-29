package pr13;

public class StringTasks {
    public static void main(String[] args) {
        String input = "I like Java!!!";

        System.out.println("Последний символ строки: " + input.charAt(input.length() - 1));

        System.out.println("Заканчивается на \"!!!\": " + input.endsWith("!!!"));

        System.out.println("Начинается с \"I like\": " + input.startsWith("I like"));

        System.out.println("Содержит \"Java\": " + input.contains("Java"));

        int javaPosition = input.indexOf("Java");
        System.out.println("Позиция \"Java\": " + javaPosition);

        String replacedString = input.replace('a', 'o');
        System.out.println("После замены \"a\" на \"o\": " + replacedString);

        String upperCaseString = input.toUpperCase();
        System.out.println("В верхнем регистре: " + upperCaseString);

        String lowerCaseString = input.toLowerCase();
        System.out.println("В нижнем регистре: " + lowerCaseString);

        String subString = input.substring(javaPosition, javaPosition + "Java".length());
        System.out.println("Вырезанная подстрока \"Java\": " + subString);
    }
}
