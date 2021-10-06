package byx.leetcode.problem.排序数组中只出现一次的数字;

/**
 * https://leetcode-cn.com/problems/skFtm2/
 */
public class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums[0] != nums[1]) {
            return nums[0];
        }

        if (nums[nums.length - 1] != nums[nums.length - 2]) {
            return nums[nums.length - 1];
        }

        for (int i = 1; i < nums.length - 1; ++i) {
            if (nums[i - 1] != nums[i] && nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }

        throw new RuntimeException();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
        System.out.println(solution.singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));
    }
}
