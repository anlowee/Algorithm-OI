package excercise.educational.whu2020.a;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(new BufferedInputStream(System.in));

    private static long[] cnt = new long[50];

    private static void work() {
        int n = sc.nextInt();
        Arrays.fill(cnt, 0);
        for (int i = 0; i < n; i++) {
            long x = sc.nextLong();
            if (x < 0)
                cnt[(int) (20 - x)]++;
            else
                cnt[(int) x]++;
        }
        long ans = cnt[0] * (cnt[0] - 1) / 2;
        for (int i = 1; i <= 20; i++) {
            ans += cnt[i] * cnt[i + 20];
        }
        System.out.println(ans);
    }

//    public static void main(String[] args) {
//        work();
//    }

}
