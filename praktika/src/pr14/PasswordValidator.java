package pr14;

import java.util.regex.Pattern;

public class PasswordValidator {
    public static void main(String[] args) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d_]{8,}$";

        String[] passwords = {
                "F032_Password",
                "TrySpy1",
                "smart_pass",
                "A007"
        };

        for (String password : passwords) {
            System.out.println(password + " -> " + isSecurePassword(password, regex));
        }
    }

    public static boolean isSecurePassword(String password, String regex) {
        return Pattern.matches(regex, password);
    }
}
