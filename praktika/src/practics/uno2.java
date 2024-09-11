package practics;

import java.util.Scanner;
import java.util.HashMap;

public class uno2 {
    static HashMap<Integer, Long> cache = new HashMap<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();
        cache.put(0, 1L);
        cache.put(1, 1L);
        System.out.printf("factorial of %d:\n%d", n,factorial(n));
    }
    public static long factorial(int num){
        if (cache.containsKey(num)) return cache.get(num);
        else {
            cache.put(num, factorial(num-1)*num);
            return cache.get(num);
        }
    }
}