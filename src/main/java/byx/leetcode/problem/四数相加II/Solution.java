package byx.leetcode.problem.四数相加II;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/4sum-ii/
 */
public class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n1 : nums1) {
            for (int n2 : nums2) {
                map.put(n1 + n2, map.getOrDefault(n1 + n2, 0) + 1);
            }
        }

        int cnt = 0;
        for (int n3 : nums3) {
            for (int n4 : nums4) {
                cnt += map.getOrDefault(-n3 - n4, 0);
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}));
    }
}
