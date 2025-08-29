package pr20;

public class Test12 {
    public static void main(String[] args) {
        GenericTask<Integer, String, Double> object = new GenericTask<>(35, "Hello", 10.5);

        System.out.println("T: " + object.getT());
        System.out.println("V: " + object.getV());
        System.out.println("K: " + object.getK());

        System.out.println(object.toString());

        object.displayTypes();
    }
}