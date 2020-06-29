package excercise.homework.OptimalMerge;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;


class NeedlemanWunschOrigin {

    private int[][] f = new int[5005][5005];
    private Long timeCost = 0L;

    private void compair(String strA, String strB, int G, int S, int F) {
        int n = strA.length();
        int m = strB.length();
        Long start = System.currentTimeMillis();
        for (int i = 0; i <= n; i++)
            f[i][0] = i * G;
        for (int j = 0; j <= m; j++)
            f[0][j] = j * G;

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                if (strA.charAt(i - 1) == strB.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + S;
                } else {
                    f[i][j] = Math.max(Math.max(f[i - 1][j - 1] + F, f[i - 1][j] + G), f[i][j - 1] + G);
                }

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                f[i][j] = Math.max(Math.max(f[i - 1][j - 1] + (strA.charAt(i - 1) == strB.charAt(j - 1) ? S : F), f[i - 1][j] + G), f[i][j - 1] + G);

        timeCost = System.currentTimeMillis() - start;
    }

    public Long work(String strA, String strB, int G, int S, int F) {
        compair(strA, strB, G, S, F);
        //return f[strA.length()][strB.length()];
        return timeCost;
    }

}

public class Main {

    public static void main(String[] args) throws IOException {
        Random random = new Random();
        StringBuffer stringBufferA = new StringBuffer();
        StringBuffer stringBufferB = new StringBuffer();
        for (int i = 0; i < 2500; i++) {
            int number = random.nextInt(4);
            switch (number) {
                case 0: stringBufferA.append('A'); break;
                case 1: stringBufferA.append('T'); break;
                case 2: stringBufferA.append('C'); break;
                case 3: stringBufferA.append('G'); break;
            }
            number = random.nextInt(4);
            switch (number) {
                case 0: stringBufferB.append('A'); break;
                case 1: stringBufferB.append('T'); break;
                case 2: stringBufferB.append('C'); break;
                case 3: stringBufferB.append('G'); break;
            }
        }
        stringBufferA.append('\n');
        stringBufferB.append('\n');

        FileOutputStream fileOutputStream = new FileOutputStream("out.txt");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        bufferedOutputStream.write(stringBufferA.toString().getBytes());
        bufferedOutputStream.write(stringBufferB.toString().getBytes());
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
    }

}
