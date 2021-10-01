package byx.leetcode.problem.最大连续1的个数III;

/**
 * https://leetcode-cn.com/problems/max-consecutive-ones-iii/
 */
public class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0, j = 0;
        int cnt = 0;
        int maxLen = 0;

        while (j < nums.length) {
            if (nums[j] == 1) {
                j++;
            } else {
                if (cnt < k) {
                    cnt++;
                    j++;
                } else {
                    maxLen = Math.max(maxLen, j - i);
                    if (nums[i] == 0) {
                        cnt--;
                    }
                    i++;
                }
            }
        }

        maxLen = Math.max(maxLen, j - i);

        return maxLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        System.out.println(solution.longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
    }
}
