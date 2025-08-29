package pr1_2;

public class Book {
    protected String author;
    protected String name;
    protected int year;
    protected String language;

    public Book(String author, String name, int year, String language){
        this.author = author;
        this.name = name;
        this.year = year;
        this.language = language;
    }

    @Override
    public String toString(){
        return "Book{" + "author: " + author +",\tname: " + name +
                ",\tyear: " + year + "\tlanguage: " + language + "}";
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


}
