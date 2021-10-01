package byx.leetcode.problem.长度最小的子数组;

/**
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 */
public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, j = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        while (j < nums.length) {
            if (sum < target) {
                sum += nums[j];
                j++;
            } else {
                minLen = Math.min(minLen, j - i);
                sum -= nums[i];
                i++;
            }
        }

        while (sum >= target) {
            minLen = Math.min(minLen, j - i);
            sum -= nums[i];
            i++;
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(solution.minSubArrayLen(4, new int[]{1, 4, 4}));
        System.out.println(solution.minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
    }
}
