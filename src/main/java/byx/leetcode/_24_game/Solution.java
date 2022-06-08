package byx.leetcode._24_game;

// https://leetcode.cn/problems/24-game/

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Solution {
    public boolean judgePoint24(int[] cards) {
        LinkedList<Double> nums = new LinkedList<>();
        for (int n : cards) {
            nums.add((double) n);
        }
        return dfs(nums);
    }

    private boolean dfs(LinkedList<Double> nums) {
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - 24) < 1e-6;
        }

        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                if (i != j) {
                    LinkedList<Double> newNums = new LinkedList<>();
                    for (int k = 0; k < nums.size(); k++) {
                        if (k != i && k != j) {
                            newNums.add(nums.get(k));
                        }
                    }

                    double a = nums.get(i);
                    double b = nums.get(j);
                    newNums.add(a + b);
                    if (dfs(newNums)) {
                        return true;
                    }

                    newNums.removeLast();
                    newNums.add(a - b);
                    if (dfs(newNums)) {
                        return true;
                    }

                    newNums.removeLast();
                    newNums.add(a * b);
                    if (dfs(newNums)) {
                        return true;
                    }

                    if (b != 0) {
                        newNums.removeLast();
                        newNums.add(a / b);
                        if (dfs(newNums)) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.judgePoint24(new int[]{4, 1, 8, 7}));
        assertFalse(s.judgePoint24(new int[]{1, 2, 1, 2}));
    }
}
