package byx.leetcode.problem.打乱数组;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * https://leetcode-cn.com/problems/shuffle-an-array/
 */
public class Solution {
    private final int[] nums;
    private final static Random random = new Random();

    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        List<Integer> list = new ArrayList<>();
        for (int n : nums) {
            list.add(n);
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            int index = random.nextInt(list.size());
            result[i] = list.get(index);
            list.remove(index);
        }

        return result;
    }
}
