package excercise.homework.OptimalMerge;

import java.awt.*;
import java.io.BufferedInputStream;
import java.util.*;
import java.util.List;

class HuffmanNode {
    HuffmanNode leftSon;
    HuffmanNode rightSon;
    int value;

    public HuffmanNode(int value) { this.value = value; }
}

class Solution {

    int n;
    Queue<HuffmanNode> huffmanNodes = new PriorityQueue<>((e1, e2) -> e2.value - e1.value);
    Scanner sc = new Scanner(new BufferedInputStream(System.in));

    private void input() {
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            HuffmanNode huffmanNode = new HuffmanNode(sc.nextInt());
            huffmanNodes.add(huffmanNode);
        }
    }

    public HuffmanNode optimalMerge() {
        input();
        while (huffmanNodes.size() >= 2) {
            HuffmanNode leftSon = huffmanNodes.poll();
            HuffmanNode rightSon = huffmanNodes.poll();
            HuffmanNode afterMerging = new HuffmanNode(
                    leftSon.value + rightSon.value);
            afterMerging.leftSon = leftSon;
            afterMerging.rightSon = rightSon;
            huffmanNodes.add(afterMerging);
        }
        return huffmanNodes.poll();
    }

}

public class Main {

    public static void main(String[] args) {
        System.out.println(new Solution().optimalMerge().value);
    }

}
