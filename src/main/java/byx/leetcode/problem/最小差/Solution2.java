package byx.leetcode.problem.最小差;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/smallest-difference-lcci/
 */
public class Solution2 {
    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int i = 0, j = 0;
        long minDiff = Long.MAX_VALUE;

        while (i < a.length &&  j < b.length) {
            minDiff = Math.min(minDiff, Math.abs((long) a[i] - (long) b[j]));
            if (a[i] < b[j]) {
                i++;
            } else {
                j++;;
            }
        }

        return (int) minDiff;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.smallestDifference(new int[]{1, 3, 15, 11, 2}, new int[]{23, 127, 235, 19, 8}));
    }
}
