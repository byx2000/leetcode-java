package byx.leetcode.problem.多数元素;

import java.util.Random;

/**
 * https://leetcode-cn.com/problems/majority-element/
 */
public class Solution2 {
    private static final Random random = new Random();

    public int majorityElement(int[] nums) {
        while (true) {
            int index = random.nextInt(nums.length);
            int cnt = 0;

            for (int n : nums) {
                if (n == nums[index]) {
                    cnt++;
                }
            }

            if (cnt > nums.length / 2) {
                return nums[index];
            }
        }
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.majorityElement(new int[]{3, 2, 3}));
        System.out.println(solution.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}
