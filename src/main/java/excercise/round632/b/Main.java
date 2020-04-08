package excercise.round632.b;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(new BufferedInputStream(System.in));

    private static int[] intsA = new int[100005];

    private static int[] intsB = new int[100005];

    private static void work() {
        int t = sc.nextInt();
        for (int k = 0; k < t; k++) {
            int n = sc.nextInt();
            int startPos = n - 1, endPos = n - 1;
            int startNum = 0, endNum = 0;
            for (int i = 0; i < n; i++) {
                intsA[i] = sc.nextInt();
                if (startNum == 0 && intsA[i] != 0) {
                    startPos = i;
                    startNum = intsA[i];
                }
                if (endNum == 0 && startNum != 0 && intsA[i] + startNum == 0) {
                    endPos = i;
                    endNum = intsA[i];
                }
            }
            for (int i = 0; i < n; i++) {
                intsB[i] = sc.nextInt();
            }

            boolean flag = true;
            for (int i = 0; i <= startPos; i++)
                if (intsA[i] != intsB[i]) {
                    System.out.println("NO");
                    flag = false;
                    break;
                }
            if (!flag)
                continue;
            for (int i = startPos + 1; i <= endPos; i++) {
                if (startNum == 1 && intsA[i] > intsB[i]) {
                    System.out.println("NO");
                    flag = false;
                    break;
                } else
                    if (startNum == -1 && intsA[i] < intsB[i]) {
                        System.out.println("NO");
                        flag = false;
                        break;
                    }
            }
            if (flag)
                System.out.println("YES");
        }
    }

    public static void main(String[] args) {
        work();
    }

}
