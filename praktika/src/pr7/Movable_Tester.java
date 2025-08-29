package pr7;

public class Movable_Tester {
    public static void main(String[] args) {
        MovableRectangle rectangle = new MovableRectangle(0, 0, 5, 5, 2, 2);

        System.out.println(rectangle);

        rectangle.moveUp();
        rectangle.moveRight();
        System.out.println(rectangle);

        System.out.println("Проверка скоростей: " + rectangle.speedTest());
    }
}
