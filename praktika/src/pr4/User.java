package pr4;

public class User {
    String username;
    String password;

    User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    boolean authenticate(String password) {
        return this.password.equals(password);
    }
}
