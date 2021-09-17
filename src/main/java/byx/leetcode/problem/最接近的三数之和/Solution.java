package byx.leetcode.problem.最接近的三数之和;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/3sum-closest/
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int minDelta = Integer.MAX_VALUE;
        int sum = 0;

        for (int i = 0; i < nums.length; ++i) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int s = nums[i] + nums[j] + nums[k];
                if (s == target) {
                    return s;
                }

                if (Math.abs(s - target) < minDelta) {
                    minDelta = Math.abs(s - target);
                    sum = s;
                }

                if (s < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}
