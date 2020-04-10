package excercise.educational.round84.a;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(new BufferedInputStream(System.in));

    private static void work() {
        int t = sc.nextInt();
        for (int i = 0;i < t; i++) {
            long n = sc.nextLong(), k = sc.nextLong();
            if (n < k * k)
                System.out.println("NO");
            else
                if (n % 2 == k % 2)
                    System.out.println("YES");
                else
                    System.out.println("NO");
        }
    }

//    public static void main(String[] args) {
//        work();
//    }

}
