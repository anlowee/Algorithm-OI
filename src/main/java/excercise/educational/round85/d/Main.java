package excercise.educational.round85.d;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * 构造样例：如n = 6时：
 * 1 2 1 3 1 4 1 5 1 6 // 2 3 2 4 2 5 2 6 // 3 4 3 5 3 6 // 4 5 4 6 // 5 6 // 1
 */
public class Main {

    private static Scanner sc = new Scanner(new BufferedInputStream(System.in));

//    public static void main(String[] args) {
//        work();
//    }

    private static void work() {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            long n = sc.nextLong();
            long l = sc.nextLong(), r = sc.nextLong();
            printResult(n, l, r);
        }
    }

    private static void printResult(long n, long l, long r) {
        StringBuffer stringBuffer = new StringBuffer();
        long k = (long) ((double) (2 * n - 1) - Math.sqrt((2 * n - 1) * (2 * n - 1) - 4 * l)) / 2;
        int cnt = 0;
        long  p = l, bias;
        while (cnt < r - l + 1) {
            if (p == n * (n - 1) + 1) {
                stringBuffer.append(1).append(' ');
                break;
            }
            bias = p - (2 * n - k - 1) * k;
            if (bias != 0) {
                if (bias % 2 == 1)
                    stringBuffer.append(k + 1).append(' ');
                else
                    stringBuffer.append(bias / 2 + k + 1).append(' ');
            } else {
                k--;
                stringBuffer.append(n).append(' ');
            }
            p++;
            cnt++;
            if (p > (2 * n - k - 2) * (k + 1))
                k++;
        }
        System.out.println(stringBuffer);
    }

}
