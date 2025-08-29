package pr7;

public class Book implements Printable {

    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public void print() {
        System.out.println("Printing book: " + title);
    }

    public static void printBooks(Printable[] printable) {
        for (Printable item : printable) {
            if (item instanceof Book) {
                Book book = (Book) item;
                System.out.println(book.getTitle());
            }
        }
    }

    public static void main(String[] args) {
        Printable[] printables = {
                new Book("Java Programming"),
                new Book("Learning Python"),
                new Magazine("Tech Monthly")
        };

        printBooks(printables);
    }
}

interface Printable {
    void print();
}

class Magazine implements Printable {

    private String title;

    public Magazine(String title) {
        this.title = title;
    }

    @Override
    public void print() {
        System.out.println("Printing magazine: " + title);
    }
}
