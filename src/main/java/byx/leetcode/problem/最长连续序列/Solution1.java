package byx.leetcode.problem.最长连续序列;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/
 */
public class Solution1 {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int maxLen = 0;
        while (i < nums.length) {
            int j = i + 1;
            int last = nums[i];
            int cnt = 1;
            while (j < nums.length) {
                if (nums[j] == last) {
                    j++;
                    continue;
                } else if (nums[j] == last + 1) {
                    last = nums[j];
                    cnt++;
                    j++;
                } else {
                    break;
                }
            }
            maxLen = Math.max(maxLen, cnt);
            i = j;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(solution.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
        System.out.println(solution.longestConsecutive(new int[]{}));
        System.out.println(solution.longestConsecutive(new int[]{1, 2, 0, 1}));
    }
}
