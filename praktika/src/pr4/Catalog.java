package pr4;
import java.util.ArrayList;
import java.util.List;

public class Catalog {
    int id;
    String name;
    List<Product> products = new ArrayList<>();

    Catalog(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void addProduct(Product product) {
        products.add(product);
    }
}
