package com.chaos.study.powerset;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/**
 * <a href="http://zh.wikipedia.org/zh-cn/%E5%86%AA%E9%9B%86">Wiki - Power Set</a>
 * <a href="http://www.csie.ntnu.edu.tw/~u91029/Backtracking.html#1">Reference</a>
 */
public class PowerSet {
    //solution
    private BitSet pickOrNot;

    //For random-accessing by index
    private List<String> copy;

    public void powerSet(List<String> s) {
        copy = new ArrayList<String>(s);
        pickOrNot = new BitSet(s.size());
        powerSet(0);
    }

    private void powerSet(int n) {
        final int size = copy.size();
        if (n == size) {
            printSet();
            return;
        }

        pickOrNot.set(n, true);
        powerSet(n + 1);

        pickOrNot.set(n, false);
        powerSet(n + 1);
    }

    private void printSet() {
         StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < copy.size(); i++) {
            if (pickOrNot.get(i)) {
                sb.append(copy.get(i)).append(", ");
            }
        }

        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
        }

        System.out.println(sb.append('}'));
    }

    public static void main(String[] args) {
        PowerSet ps = new PowerSet();
        ps.powerSet(Arrays.asList("1", "2", "3", "4", "5"));
    }

}
