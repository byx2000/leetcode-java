package byx.leetcode.problem.寻找重复数;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/find-the-duplicate-number/
 */
public class Solution {
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
}
