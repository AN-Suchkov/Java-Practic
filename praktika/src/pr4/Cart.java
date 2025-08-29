package pr4;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<Product> products = new ArrayList<>();

    void addProduct(Product product) {
        products.add(product);
        System.out.println(product.name + " добавлен в корзину.");
    }

    void viewCart() {
        if (products.isEmpty()) {
            System.out.println("Ваша корзина пуста.");
            return;
        }
        double total = 0;
        System.out.println("Ваши товары в корзине:");
        for (Product p : products) {
            System.out.println(p);
            total += p.price;
        }
        System.out.println("Итого: $" + total);
    }

    void checkout() {
        if (products.isEmpty()) {
            System.out.println("Ваша корзина пуста.");
            return;
        }
        double total = 0;
        System.out.println("Покупка выполнена. Вы купили:");
        for (Product p : products) {
            System.out.println(p);
            total += p.price;
        }
        System.out.println("Общая сумма: $" + total);
        products.clear();
    }
}
