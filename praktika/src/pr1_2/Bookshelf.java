package pr1_2;

public class Bookshelf {
    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if (this.books.length <= capacity) this.capacity = capacity;
    }

    private Book[] books;
    private int capacity;

    public Bookshelf(Book[] books){
        this.books = books;
        this.capacity = Math.max(books.length, 4);
    }
    public Bookshelf(Book[] books, int size){
        this.books = books;
        this.capacity = size;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder("Bookshelf{capacity: " + this.books.length + '/' + this.capacity + "\t Books:\n");
        for (Book book : this.books) {
            res.append(book.toString()).append("\n");
        }
        res.append('}');
        return res.toString();
    }

}
