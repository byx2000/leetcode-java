package byx.leetcode.problem.最大连续1的个数;

/**
 * https://leetcode-cn.com/problems/max-consecutive-ones/
 */
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxLen = 0;
        int i = 0;

        while (i < nums.length) {
            if (nums[i] == 1) {
                int j = i;
                while (j < nums.length && nums[j] == 1) {
                    j++;
                }
                maxLen = Math.max(maxLen, j - i);
                i = j;
            } else {
                i++;
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
    }
}
