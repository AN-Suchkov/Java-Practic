package pr4_1;

public class ShapeTester {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);
        Shape square = new Square(4);

        System.out.println(circle);
        System.out.println(rectangle);
        System.out.println(square);

        // Demonstrate calling methods using a parent reference
        System.out.println("Circle Type: " + circle.getType() + ", Area: " + circle.getArea() + ", Perimeter: " + circle.getPerimeter());
        System.out.println("Rectangle Type: " + rectangle.getType() + ", Area: " + rectangle.getArea() + ", Perimeter: " + rectangle.getPerimeter());
        System.out.println("Square Type: " + square.getType() + ", Area: " + square.getArea() + ", Perimeter: " + square.getPerimeter());
    }
}
