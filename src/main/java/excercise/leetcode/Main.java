package excercise.leetcode;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    private Scanner sc = new Scanner(new BufferedInputStream(System.in));

    @Test
    public boolean isHappy(int n) {
        Set<Integer> squareSums = new HashSet<Integer>();
        int squareSum = Integer.MIN_VALUE
        while (true) {
            squareSum = 0;
            while (n > 0) {
                squareSum += (n % 10) * (n % 10);
                n /= 10;
            }
            n = squareSum;
            if (squareSums.contains(squareSum))
                break;
            else
                squareSums.add(squareSum);
        }
        return squareSum == 1;
    }

}
