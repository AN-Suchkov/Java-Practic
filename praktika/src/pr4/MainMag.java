package pr4;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MainMag {
    static List<User> users = new ArrayList<>();
    static List<Catalog> catalogs = new ArrayList<>();

    public static void main(String[] args) {
        initializeData();
        Scanner scanner = new Scanner(System.in);
        User currentUser = null;

        // Аутентификация
        while (currentUser == null) {
            System.out.println("=== Аутентификация ===");
            System.out.print("Логин: ");
            String username = scanner.nextLine();
            System.out.print("Пароль: ");
            String password = scanner.nextLine();

            for (User user : users) {
                if (user.username.equals(username) && user.authenticate(password)) {
                    currentUser = user;
                    break;
                }
            }
            if (currentUser != null) {
                System.out.println("Успешный вход!");
            } else {
                System.out.println("Неверный логин или пароль. Попробуйте снова.");
            }
        }

        Cart cart = new Cart();
        boolean exit = false;

        // Главное меню
        while (!exit) {
            MenuOption.printMenu();
            String input = scanner.nextLine();
            int choice;

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите число от 1 до 6.");
                continue;
            }

            MenuOption option = MenuOption.fromInt(choice);
            if (option == null) {
                System.out.println("Неверная опция. Пожалуйста, выберите от 1 до 6.");
                continue;
            }

            switch (option) {
                case VIEW_CATALOGS:
                    viewCatalogs();
                    break;
                case VIEW_PRODUCTS:
                    viewProducts(scanner);
                    break;
                case ADD_TO_CART:
                    addToCart(scanner, cart);
                    break;
                case VIEW_CART:
                    cart.viewCart();
                    break;
                case CHECKOUT:
                    cart.checkout();
                    break;
                case LOGOUT:
                    System.out.println("Выход из системы. До свидания!");
                    exit = true;
                    break;
            }
        }

        scanner.close();
    }

    // Инициализация пользователей и каталогов
    static void initializeData() {
        // Пользователи
        users.add(new User("user1", "password1"));
        users.add(new User("user2", "password2"));

        // Каталог Электроника
        Catalog electronics = new Catalog(1, "Электроника");
        electronics.addProduct(new Product(1, "Смартфон", 699.99));
        electronics.addProduct(new Product(2, "Ноутбук", 999.99));

        // Каталог Книги
        Catalog books = new Catalog(2, "Книги");
        books.addProduct(new Product(4, "Java для начинающих", 39.99));
        books.addProduct(new Product(5, "Алгоритмы и структуры данных", 49.99));

        // Каталог Одежда
        Catalog clothing = new Catalog(3, "Одежда");
        clothing.addProduct(new Product(7, "Футболка", 19.99));
        clothing.addProduct(new Product(8, "Джинсы", 49.99));

        catalogs.add(electronics);
        catalogs.add(books);
        catalogs.add(clothing);
    }

    // Просмотр каталогов
    static void viewCatalogs() {
        System.out.println("\n=== Список Каталогов ===");
        for (Catalog catalog : catalogs) {
            System.out.println(catalog.id + ". " + catalog.name);
        }
    }

    // Просмотр товаров в выбранном каталоге
    static void viewProducts(Scanner scanner) {
        viewCatalogs();
        System.out.print("Введите номер каталога: ");
        String input = scanner.nextLine();
        int catalogId;

        try {
            catalogId = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Пожалуйста, введите корректный номер каталога.");
            return;
        }

        Catalog selected = null;
        for (Catalog catalog : catalogs) {
            if (catalog.id == catalogId) {
                selected = catalog;
                break;
            }
        }

        if (selected != null) {
            System.out.println("\n=== Товары в каталоге \"" + selected.name + "\" ===");
            for (Product product : selected.products) {
                System.out.println(product);
            }
        } else {
            System.out.println("Каталог с таким номером не найден.");
        }
    }
    static void addToCart(Scanner scanner, Cart cart) {
        System.out.print("Введите ID товара для добавления в корзину: ");
        String input = scanner.nextLine();
        int productId;

        try {
            productId = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Пожалуйста, введите корректный ID товара.");
            return;
        }

        Product found = null;
        for (Catalog catalog : catalogs) {
            for (Product product : catalog.products) {
                if (product.id == productId) {
                    found = product;
                    break;
                }
            }
            if (found != null) break;
        }

        if (found != null) {
            cart.addProduct(found);
        } else {
            System.out.println("Товар с таким ID не найден.");
        }
    }
}
