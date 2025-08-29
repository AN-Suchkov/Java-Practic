package pr14;

import java.util.regex.Pattern;

public class reg1 {
    public static void main(String[] args) {
        String regex = "^abcdefghijklmnopqrstuv18340$";

        String correct = "abcdefghijklmnopqrstuv18340";
        String incorrect = "abcdefghijklmnoasdfasdpqrstuv18340";

        System.out.println(correct.matches(regex));
        System.out.println(incorrect.matches(regex));
    }
}
