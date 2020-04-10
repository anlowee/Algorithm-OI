package excercise.div2.round632.a;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(new BufferedInputStream(System.in));

    private static void work() {
        int t;
        t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n, m;
            n = sc.nextInt();
            m = sc.nextInt();
            StringBuffer stringBuffer = new StringBuffer();
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (n * m % 2 == 0 && j == 0 && k == 1) {
                        stringBuffer.append('B');
                        continue;
                    }
                    if ((j + k) % 2 == 0)
                        stringBuffer.append('B');
                    else
                        stringBuffer.append('W');
                }
                stringBuffer.append('\n');
            }
            System.out.print(stringBuffer);
        }
    }

//    public static void main(String[] args) {
//        work();
//    }

}
