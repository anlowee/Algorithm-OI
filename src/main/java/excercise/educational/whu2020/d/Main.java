package excercise.educational.whu2020.d;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(new BufferedInputStream(System.in));

    private static int[][] map = new int[2005][2005];

    public static int[][] ans = new int[2005][2005];

    private static int[][][] leftUp = new int[2005][2005][2];

    private static void work() {
        StringBuffer stringBuffer = new StringBuffer();
        int t = sc.nextInt();
        for (int k = 0; k < t; k++) {
            int n =sc.nextInt(), m = sc.nextInt();
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++) {
                    ans[i][j] = 1;
                }
            for (int i = 0; i < n; i++) {
                String string = sc.next();
                for (int j = 0; j < m; j++)
                    map[i][j] = string.charAt(j) - 'A';
            }


            for (int i = 1; i < n; i++)
                for (int j = 1; j < m; j++)
                    if (map[i][j] == map[i - 1][j - 1] && map[i][j] == map[i - 1][j] && map[i][j] == map[i][j - 1])
                        ans[i][j] = Math.min(Math.min(ans[i - 1][j], ans[i][j - 1]), ans[i - 1][j - 1]) + 1;


            int result = 0;
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    result = Math.max(result, ans[i][j]);
            stringBuffer.append(result).append('\n');
        }
        System.out.print(stringBuffer);
    }

    public static void main(String[] args) {
        work();
    }

}