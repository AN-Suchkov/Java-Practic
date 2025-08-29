package pr4;

public enum MenuOption {
    VIEW_CATALOGS(1, "Просмотр Каталогов"),
    VIEW_PRODUCTS(2, "Просмотр Товаров в Каталоге"),
    ADD_TO_CART(3, "Добавить Товар в Корзину"),
    VIEW_CART(4, "Просмотреть Корзину"),
    CHECKOUT(5, "Купить Товары в Корзине"),
    LOGOUT(6, "Выйти");

    private final int number;
    private final String description;

    MenuOption(int number, String description) {
        this.number = number;
        this.description = description;
    }

    public int getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }

    // Получение MenuOption по номеру
    public static MenuOption fromInt(int i) {
        for (MenuOption option : MenuOption.values()) {
            if (option.getNumber() == i) {
                return option;
            }
        }
        return null;
    }

    // Вывод меню
    public static void printMenu() {
        System.out.println("\n=== Главное Меню ===");
        for (MenuOption option : MenuOption.values()) {
            System.out.println(option.getNumber() + ". " + option.getDescription());
        }
        System.out.print("Выберите опцию: ");
    }
}
