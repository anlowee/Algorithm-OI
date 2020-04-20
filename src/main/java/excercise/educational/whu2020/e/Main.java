package excercise.educational.whu2020.e;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(new BufferedInputStream(System.in));

    private static void work() {
        int t = sc.nextInt();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < t; i++) {
            long n = sc.nextLong();
            if (n <= 1)
                stringBuffer.append(0).append('\n');
            else
                stringBuffer.append(n - 1).append('\n');
        }
        System.out.print(stringBuffer);
    }

//    public static void main(String[] args) {
//        work();
//    }

}
