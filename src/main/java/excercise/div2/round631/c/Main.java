package excercise.div2.round631.c;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 从后往前首先算出每次操作可以涂的最左边的位置borden
 * 如果borden[0] <= 0，则说明不可能
 * 如果borden[0] == 1，则说明borden已经符合条件（即所有操作都取其能取得最左端位置）
 * 否则，需要计算bias，bias根据每次操作可以活动的区间rest计算
 * 最后的答案就是borden减去bias
 */
public class Main {

    private static Scanner sc = new Scanner(new BufferedInputStream(System.in));

    private static int[] ints = new int[100005];

    private static int[] borden = new int[100005];

    private static int[] rest = new int[100005];

    private static int[] bias = new int[100005];

    private static void work() {
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            ints[i] = sc.nextInt();
        }
        process(ints, n, m);
        if (validate(borden, rest, n, m)) {
            printResult(borden, bias, m);
        } else
            System.out.println(-1);
    }

    private static void process(int[] ints, int n, int m) {
        borden[m - 1] = n - ints[m - 1] + 1;
        rest[m - 1] = 0;
        for (int i = m - 2; i >= 0; i--) {
            borden[i] = Math.min(borden[i + 1] - 1, n - ints[i] + 1);
            rest[i] = ints[i] - borden[i + 1] + borden[i];
            bias[i] = borden[i];
        }
    }

    private static boolean validate(int[] borden, int[] rest, int n, int m) {
        Arrays.fill(bias, 0, m, 0);
        if (borden[0] <= 0)
            return false;
        int totRest = borden[0] - 1;
        if (totRest == 0)
            return true;
        boolean flag = false;
        for (int i = 0; i < m - 1; i++) {
            totRest -= rest[i];
            if (totRest <= 0) {
                flag = true;
                bias[i] = totRest + rest[i];
                break;
            } else
                bias[i] = rest[i];
        }
        for (int i = m - 2; i >= 0; i--) {
            bias[i] += bias[i + 1];
        }
        return flag;
    }

    private static void printResult(int[] borden, int[] bias, int m) {
        for (int i = 0; i < m - 1; i++) {
            int pos = borden[i] - bias[i];
            System.out.print(pos + " ");
        }
        System.out.println(borden[m - 1]);
    }

//    public static void main(String[] args) {
//        work();
//    }

}
