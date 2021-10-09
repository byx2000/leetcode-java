package byx.leetcode.problem._0和1个数相同的子数组;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/A1NYOS/
 */
public class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; ++i) {
            sum += (nums[i] == 0) ? -1 : 1;
            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMaxLength(new int[]{0, 1}));
        System.out.println(solution.findMaxLength(new int[]{0, 1, 0}));
    }
}
