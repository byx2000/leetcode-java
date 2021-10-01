package byx.leetcode.problem.绝对差不超过限制的最长连续子数组;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
 */
public class Solution {
    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<Integer> minVal = new PriorityQueue<>();
        PriorityQueue<Integer> maxVal = new PriorityQueue<>((a, b) -> b - a);
        int i = 0, j = 1;
        minVal.add(nums[0]);
        maxVal.add(nums[0]);
        int maxLen = 1;

        while (j < nums.length) {
            if (maxVal.peek() - minVal.peek() <= limit) {
                maxLen = Math.max(maxLen, j - i);
                maxVal.add(nums[j]);
                minVal.add(nums[j]);
                j++;
            } else {
                maxVal.remove(nums[i]);
                minVal.remove(nums[i]);
                i++;
            }
        }

        if (maxVal.peek() - minVal.peek() <= limit) {
            maxLen = Math.max(maxLen, j - i);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestSubarray(new int[]{8, 2, 4, 7}, 4));
        System.out.println(solution.longestSubarray(new int[]{10,1,2,4,7,2}, 5));
        System.out.println(solution.longestSubarray(new int[]{4,2,2,2,4,4,2,2}, 0));
    }
}
