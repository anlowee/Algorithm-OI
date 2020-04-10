package excercise.educational.round84.b;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(new BufferedInputStream(System.in));

    private static int[] queue = new int[100005];

    private static boolean[] isMarried = new boolean[100005];

    private static void work() {
        int t = sc.nextInt();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt(), unMarried = -1;
            Arrays.fill(isMarried, 1, n + 1, false);
            for (int j = 0; j < n; j++) {
                int k = sc.nextInt();
                Arrays.fill(queue,0, k, 0);
                for (int l = 0; l < k; l++)
                    queue[l] = sc.nextInt();

                int p = 0;
                while (isMarried[queue[p]] && p < k)
                    p++;
                if (p == k)
                    unMarried = j + 1;
                else
                    isMarried[queue[p]] = true;
            }

            if (unMarried == -1)
                stringBuffer.append("OPTIMAL").append('\n');
            else {
                for (int j = 1; j <= n; j++)
                    if (!isMarried[j]) {
                        stringBuffer.append("IMPROVE").append('\n');
                        stringBuffer.append(unMarried).append(' ').append(j).append('\n');
                        break;
                    }
            }
        }
        System.out.print(stringBuffer);
    }

    public static void main(String[] args) {
        work();
    }

}
