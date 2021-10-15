package byx.leetcode.problem.最小差;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/smallest-difference-lcci/
 */
public class Solution1 {
    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        long minDiff = Long.MAX_VALUE;

        for (int n : a) {
            int pos = findFirstLargerPos(b, n);

            long d = Long.MAX_VALUE;
            if (pos == 0) {
                d = diff(n, b[0]);
                if (b.length > 1) {
                    d = Math.min(d, diff(n, b[1]));
                }
            } else if (pos == b.length - 1) {
                d = diff(n, b[b.length - 1]);
                if (b.length > 1) {
                    d = Math.min(d, diff(n, b[b.length - 2]));
                }
            } else if (pos == b.length) {
                d = diff(n, b[b.length - 1]);
            } else {
                d = diff(n, b[pos]);
                d = Math.min(d, diff(n, b[pos - 1]));
                d = Math.min(d, diff(n, b[pos + 1]));
            }

            minDiff = Math.min(minDiff, d);
        }

        return (int) minDiff;
    }

    // 找到第一个大于等于target的元素的位置
    private int findFirstLargerPos(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int result = nums.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                result = mid;
                right = mid - 1;
            }
        }

        return result;
    }

    private long diff(long a, long b) {
        return Math.abs(a - b);
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.smallestDifference(new int[]{1, 3, 15, 11, 2}, new int[]{23, 127, 235, 19, 8}));
    }
}
