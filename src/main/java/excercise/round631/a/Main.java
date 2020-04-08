package excercise.round631.a;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 水题，不解释
 */
public class Main {

    private static Scanner sc = new Scanner(new BufferedInputStream(System.in));

    private static Integer[] integers = new Integer[105];

    private static void work() {
        int t, n, x;
        t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            n = sc.nextInt();
            x = sc.nextInt();
            integers[0] = 0;
            for (int j = 1; j <= n; j++)
                integers[j] = sc.nextInt();
            Arrays.sort(integers, 0, n + 1);
            int result = -1;
            for (int j = 1; j <= n; j++) {
                int dif = integers[j] - integers[j - 1] - 1;
                dif = Math.max(0, dif);
                if (x >= dif)
                    x -= dif;
                else {
                    result = integers[j - 1] + x;
                    break;
                }
            }
            if (result == -1)
                result = integers[n] + x;
            System.out.println(result);
        }
    }

//    public static void main(String[] args) {
//        work();
//    }

}
