package pr1_2;

import java.lang.*;
import java.util.Scanner;


public class TestAuthor {
    public static void main(String[] args) {
        String name = "Aleksey";
        Author k1 = new Author(name, "qwerty@zxc.com", 'M');
        System.out.println(k1);
        System.out.println("NAME:\t" + k1.getName());
        Scanner source = new Scanner(System.in);
        System.out.println("Введите email:\t");
        String ema = source.next();
        k1.setEmail(ema);
        System.out.println(k1);
    }

}