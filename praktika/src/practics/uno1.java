package practics;
import java.util.Scanner;

public class uno1 {
    public static void main(String[] args) {
        System.out.print("Enter the size of array:\t");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n <= 0) System.exit(1);
        System.out.println("\nenter array:");
        int[] b = new int[n];
        int s = 0;
        float average;
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
//            System.out.printf("%d \t", b[i]);
            s+=b[i];
        }
        average= (float) s /n;
        System.out.printf("sum:\n%d\naverage:\n%.2f", s,average);

    }
}