package pr6;

import java.util.ArrayList;

public class Nameable_Tester {
    public static void main(String[] args) {
        Nameable car = new Car("Tesla Model S");
        Nameable dog = new Animal("Buddy");

        ArrayList<Nameable> items = new ArrayList<>();
        items.add(car);
        items.add(dog);

        for (Nameable item : items) {
            System.out.println("Name: " + item.getName());
        }
    }
}