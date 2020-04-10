package excercise.div2.round631.b;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 首先正向检查，利用不重复且最小值为1最大值为长度的特性筛选出所有符合正向条件的位置
 * 然后反向检查，检查条件比上面多一个check[i-1]是true，修改check数组，此时check[i]表示i~n和1~i-1分别符合条件
 * 结果就是check中为true的数量
 */
public class Main {

    private static Scanner sc = new Scanner(new BufferedInputStream(System.in));

    private static Integer[] integers = new Integer[200005];

    private static int[][] result = new int[200005][2];

    private static int[] cnt = new int[200005];

    private static boolean[] check = new boolean[200005];

    private static void checkPos(int n) {
        Arrays.fill(cnt, 0, n, 0);
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            cnt[integers[i]]++;
            if (cnt[integers[i]] > 1)
                flag = false;
            max = Math.max(max, integers[i]);
            min = Math.min(min, integers[i]);
            if (flag && max == i + 1 && min == 1)
                check[i] = true;
        }
    }

    private static void checkNeg(int n) {
        Arrays.fill(cnt, 0, n, 0);
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        boolean flag= true;
        for (int i = n - 1; i >= 0; i--) {
            cnt[integers[i]]++;
            if (cnt[integers[i]] > 1)
                flag = false;
            max = Math.max(max, integers[i]);
            min = Math.min(min, integers[i]);
            check[i] = flag && check[i - 1] && max == n - i && min == 1;
        }
    }

//    public static void main(String[] args) {
//        int t = sc.nextInt();
//        for (int i = 0; i < t; i++) {
//            int n = sc.nextInt();
//            Arrays.fill(check, 0, n, false);
//            for (int j = 0; j < n; j++)
//                integers[j] = sc.nextInt();
//            checkPos(n);
//            checkNeg(n);
//            int ans = 0;
//            for (int j = 0; j < n; j++)
//                if (check[j]) {
//                    result[ans][0] = j;
//                    result[ans][1] = n - j;
//                    ans++;
//                }
//            System.out.println(ans);
//            for (int j = 0; j < ans; j++)
//                System.out.println(result[j][0] + " " + result[j][1]);
//        }
//
//    }

}
