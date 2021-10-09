package byx.leetcode.problem.和为k的子数组;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/QTMn0o/
 */
public class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int cnt = 0;

        for (int n : nums) {
            sum += n;
            if (map.containsKey(sum - k)) {
                cnt += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return cnt;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(solution.subarraySum(new int[]{1, 2, 3}, 3));
    }
}
