package byx.leetcode.problem.寻找重复数;

import byx.leetcode.common.Check;
import byx.leetcode.common.Checker;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/find-the-duplicate-number/
 */
public class Solution {
    @Check
    public int findDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (int n : nums) {
            if (map.get(n) > 1) {
                return n;
            }
        }

        throw new RuntimeException();
    }

    public static void main(String[] args) {
        Checker.check(Solution.class, 2, new int[]{1, 3, 4, 2, 2});
        Checker.check(Solution.class, 3, new int[]{3, 1, 3, 4, 2});
        Checker.check(Solution.class, 1, new int[]{1, 1});
        Checker.check(Solution.class, 1, new int[]{1, 1, 2});
    }
}
