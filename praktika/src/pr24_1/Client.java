package pr24_1;

public class Client {
    public static void main(String[] args) {
        ComplexAbstractFactory factory1 = new ConcreteFactory1();
        Complex complex1 = factory1.createComplex(1, 2);
        System.out.println("Complex 1: " + complex1);

        ComplexAbstractFactory factory2 = new ConcreteFactory2();
        Complex complex2 = factory2.createComplex(3, 4);
        System.out.println("Complex 2: " + complex2);
    }
}