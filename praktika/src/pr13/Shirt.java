package pr13;

public class Shirt {
    private String id;
    private String description;
    private String color;
    private String size;

    public Shirt(String data) {
        String[] parts = data.split("\\s*,\\s*");
        this.id = parts[0];
        this.description = parts[1];
        this.color = parts[2];
        this.size = parts[3];
    }

    @Override
    public String toString() {
        return "ID: " + id + "\n" +
                "Description: " + description + "\n" +
                "Color: " + color + "\n" +
                "Size: " + size + "\n";
    }
}
