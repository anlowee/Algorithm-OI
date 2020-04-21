package excercise.leetcode;

import java.util.*;

class MinStack {

    private List<Integer> elements;

    /** initialize your data structure here. */
    public MinStack() {
        elements = new ArrayList<Integer>();
    }

    public void push(int x) {
        elements.add(x);
    }

    public void pop() {

        elements.remove(elements.size() - 1);
    }

    public int top() {
        return elements.get(elements.size() - 1);
    }

    public int getMin() {
        int min = elements.get(0);
        for (Integer i : elements)
            min = Math.min(min, i);
        return min;
    }
}

public class Main {

    public static void main(String[] args) {

    }

}
