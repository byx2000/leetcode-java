package byx.leetcode.problem.最长连续序列;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/
 */
public class Solution2 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int maxLen = 0;
        for (int n : nums) {
            if (!set.contains(n - 1)) {
                int len = 1;
                int m = n + 1;
                while (true) {
                    if (set.contains(m)) {
                        len++;
                        m++;
                    } else {
                        break;
                    }
                }
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(solution.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
        System.out.println(solution.longestConsecutive(new int[]{}));
        System.out.println(solution.longestConsecutive(new int[]{1, 2, 0, 1}));
    }
}
