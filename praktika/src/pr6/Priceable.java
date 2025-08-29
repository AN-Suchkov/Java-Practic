package pr6;

interface Priceable {
    double getPrice();
}

class Product implements Priceable {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}

class Device implements Priceable {
    private String model;
    private double price;

    public Device(String model, double price) {
        this.model = model;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public String getModel() {
        return model;
    }
}

class Service implements Priceable {
    private String description;
    private double price;

    public Service(String description, double price) {
        this.description = description;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}

