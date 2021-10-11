package byx.leetcode.problem.最短无序连续子数组;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/submissions/
 */
public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] t = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            t[i] = nums[i];
        }
        Arrays.sort(t);

        int i = 0;
        while (i < nums.length) {
            if (nums[i] != t[i]) {
                break;
            }
            i++;
        }

        int j = nums.length - 1;
        while (j >= 0) {
            if (nums[j] != t[j]) {
                break;
            }
            j--;
        }

        if (i > j) {
            return 0;
        }

        return j - i + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
        System.out.println(solution.findUnsortedSubarray(new int[]{1, 2, 3, 4}));
        System.out.println(solution.findUnsortedSubarray(new int[]{1}));
    }
}
