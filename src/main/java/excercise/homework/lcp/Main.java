package excercise.homework.lcp;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// lcp solution
public class Main {

    private static Scanner sc = new Scanner(new BufferedInputStream(System.in));
    private static List<String> strings = new ArrayList<String>();

    public static void inputData() {
        int n = sc.nextInt();
        for (int i = 0; i < n; i++)
            strings.add(sc.next());
    }

    public static void outputResult() {
        String result = lcp(0, strings.size() - 1);
        if (result == null)
            System.out.println("no lcp");
        else
            System.out.println(result);
    }

    public static String lcp(int low, int high) {
        if (high == low)
            return strings.get(low);

        int mid = (low + high) / 2;
        String leftLcp = lcp(low, mid);
        String rightLcp = lcp(mid + 1, high);
        if (leftLcp == null || rightLcp == null)
            return null;
        int p = 0;
        while (p < leftLcp.length() && p < rightLcp.length()) {
            if (leftLcp.charAt(p) == rightLcp.charAt(p))
                p++;
            else if (p == 0)
                return null;
        }

        return leftLcp.substring(0, p);
    }

//    public static void main(String[] args) {
//        inputData();
//        outputResult();
//    }

}
