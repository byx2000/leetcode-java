package byx.leetcode.problem.合并排序的数组;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/sorted-merge-lcci/
 */
public class Solution {
    public void merge(int[] a, int m, int[] b, int n) {
        int k = m + n - 1, i = m - 1, j = n - 1;

        while (i >= 0 || j >= 0) {
            if (i < 0) {
                a[k--] = b[j--];
            } else if (j < 0) {
                a[k--] = a[i--];
            } else if (a[i] > b[j]) {
                a[k--] = a[i--];
            } else {
                a[k--] = b[j--];
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = new int[]{1, 2, 3, 0, 0, 0};
        int[] b = new int[]{2, 5, 6};
        solution.merge(a, 3, b, 3);
        System.out.println(Arrays.toString(a));
    }
}
