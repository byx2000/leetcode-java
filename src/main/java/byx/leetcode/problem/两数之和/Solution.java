package byx.leetcode.problem.两数之和;

import byx.leetcode.common.Checker;
import byx.leetcode.common.Check;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/
 */
public class Solution {
    @Check
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int remain = target - nums[i];
            if (map.containsKey(remain)) {
                return new int[]{map.get(remain), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        Checker.check(Solution.class, new int[]{0, 1}, new int[]{2, 7, 11, 15}, 9);
        Checker.check(Solution.class, new int[]{1, 2}, new int[]{3, 2, 4}, 6);
        Checker.check(Solution.class, new int[]{0, 1}, new int[]{3, 3}, 6);
    }
}
