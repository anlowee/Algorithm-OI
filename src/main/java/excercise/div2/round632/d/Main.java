package excercise.div2.round632.d;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 统计出最小转向次数（每一次将所有能转的都转）和最大转向次数（每次转向次数之和）
 * 如果k在这个区间内则构造，构造方法就是先预留出min步，然后每次转一个，直到把多余的
 * 步数用完，再一次一整行地转。
 *
 * ps: Java输出非常慢，要用StringBuffer构造输出流后一起输出
 */
public class Main {

    private static Scanner sc = new Scanner(new BufferedInputStream(System.in));

    private static List<List<Integer>> op = new ArrayList<List<Integer>>();

    private static void solution(int min, int k) {
        StringBuffer stringBuffer = new StringBuffer();
        int p = 0, pp = 0, cnt = min;
        // 这里用了k - min + p步
        while (cnt < k) {
            stringBuffer.append("1 ").append(op.get(p).get(pp)).append('\n');
            pp++;
            if (pp == op.get(p).size()) {
                p++;
                pp = 0;
            } else
                cnt++;
        }

        // 这里用了1步
        stringBuffer.append(op.get(p).size() - pp);
        for (; pp < op.get(p).size(); pp++)
            stringBuffer.append(' ').append(op.get(p).get(pp));
        stringBuffer.append('\n');
        p++;
        // 这里用了min - (p + 1)步
        for (; p < min; p++) {
            stringBuffer.append(op.get(p).size());
            for (pp = 0; pp < op.get(p).size(); pp++)
                stringBuffer.append(' ').append(op.get(p).get(pp));
            stringBuffer.append('\n');
        }
        // 总计k步，正好用完
        System.out.print(stringBuffer);
    }

    private static void check(StringBuffer stringBuffer) {
        List<Integer> cur = new ArrayList<Integer>();
        for (int i = 0; i + 1 < stringBuffer.length();) {
            if (stringBuffer.charAt(i) == 'R' && stringBuffer.charAt(i + 1) == 'L') {
                stringBuffer.setCharAt(i, 'L');
                stringBuffer.setCharAt(i + 1, 'R');
                cur.add(i + 1);
                i += 2;
            } else
                i++;
        }
        op.add(cur);
    }

    private static void work() {
        int n = sc.nextInt(), k =sc.nextInt();
        StringBuffer queue = new StringBuffer(sc.next());
        check(queue);
        int min = 0, max = 0;
        while (!op.get(min).isEmpty() && min <= k) {
            max += op.get(min).size();
            min++;
            check(queue);
        }
        if (k >= min && k <= max)
            solution(min, k);
        else
            System.out.println("-1");
    }

//    public static void main(String[] args) {
//        work();
//    }

}