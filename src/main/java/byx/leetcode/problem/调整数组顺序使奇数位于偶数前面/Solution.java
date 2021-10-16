package byx.leetcode.problem.调整数组顺序使奇数位于偶数前面;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 */
public class Solution {
    public int[] exchange(int[] nums) {
        int i = 0, j = 0;

        while (j < nums.length) {
            if (nums[j] % 2 == 0) {
                j++;
            } else {
                swap(nums, i, j);
                i++;
                j++;
            }
        }

        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.exchange(new int[]{1, 2, 3, 4})));
    }
}
