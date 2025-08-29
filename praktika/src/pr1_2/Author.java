package pr1_2;

public class Author {
    private final String name;
    private String email;
    private char gender;

    public Author(String name, String email, char gender)
    {
        this.email = email;
        this.name = name;
        this.gender = gender;
    }


    @Override
    public String toString() {
        return "Author{" +
                "name: " + name +",\temail: " + email +
                ",\tgender: " + gender + "}";
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
