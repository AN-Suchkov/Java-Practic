package pr8;

public class OddNum {
    public static void next() {
        java.util.Scanner in = new java.util.Scanner(System.in);
        int n = in.nextInt();
        if (n > 0) {
            int m = in.nextInt();
            System.out.println(n);
            if (m > 0) {
                next();
            }
        }
    }
    public static void main(String[] args) {
        next();
    }
}