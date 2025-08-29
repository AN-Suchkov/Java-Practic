package pr1_2;

public class BookTest {
    public static void main(String[] args) {
        Book bk1 = new Book("Сунь-цзы", "Искусство войны", -500, "Китайский");
        System.out.println(bk1);
        System.out.println(bk1.getAuthor());
        Book bk2 = new Book("Чак Паланик", "Бойцовский клуб", 1996, "Английский");
        Book bk3 = new Book("Джордж Оруэлл", "1984", 1949, "Английский");
        Book bk4 = new Book("Аркадий Натанович Стругацкий и Борис Натанович Стругацкий",
                "Понедельник начинается в субботу", 1965, "Русский");
        System.out.println(bk4.getLanguage());
        System.out.println(bk2.getYear());
        System.out.println(bk3);
        Book[] ccc = new Book[] {bk1, bk2, bk3};
        Bookshelf a1 = new Bookshelf(ccc, 3);
        System.out.println(a1);
        bk3.setName("1985");
        a1.setCapacity(2);
        System.out.println(a1.getCapacity());
        a1.setCapacity(99);
        System.out.println(a1);
    }
}
