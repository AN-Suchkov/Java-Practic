package pr14;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Reg2 {
    public static void main(String[] args) {
        String regex = "\\d(?!\\s*\\+)";

        String correct = "(1 + 8) – 9 / 4";
        String incorrect = "6 / 5 – 2 * 9";

        System.out.println(containsNumberWithoutPlus(correct, regex));  // true
        System.out.println(containsNumberWithoutPlus(incorrect, regex)); // false
    }

    public static boolean containsNumberWithoutPlus(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }
}

