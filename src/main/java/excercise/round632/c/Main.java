package excercise.round632.c;

import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 首先考虑dp思想，dp[k + 1]与dp[k]的关系仅仅在于以第k + 1位置结尾的子串是否满足条件
 * 因为子串是连续的，所以对于满足条件的长度为len的子串，小于len的一定满足；对于不满足
 * 条件的长度为len的子串，大于len的一定不满足。从0位置往后迭代，每次考察以当前位置结尾
 * 的子串是否满足，为此，考察前缀和数组（为了便于查询使用Map数据结构），当前缀和数组中
 * 两个元素相同，则说明他们之间的区间和为0，利用这个性质找到一个最左边的leftPos使得所有
 * 当前位置到leftPos之间的子串和均不为0（注意，这里的子串不一定是以当前位置结尾），将
 * 此次结果加入答案中。
 */
public class Main {

    private static Scanner sc = new Scanner(new BufferedInputStream(System.in));

    private static Map<Long, Integer> map = new HashMap<Long, Integer>();

    private static void work() {
        int n = sc.nextInt();
        map.put(0L, 0);
        long ans = 0L, sum = 0L;
        int leftPos = -1;  // 当前位置到leftPos的区间內没有区间和为0的最大的leftPos
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            sum += x;
            if (map.get(sum) != null)
                leftPos = Math.max(leftPos, map.get(sum));  // 注意此处是max，不能直接把map的值赋给它，因为可能会有不是以当前位置结尾的子串和为0
            map.put(sum, i + 1);
            ans += i - leftPos;
        }
        System.out.println(ans);
    }

//    public static void main(String[] args) {
//        work();
//    }

}
