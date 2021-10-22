package byx.leetcode.problem.分割数组的最大值;

/**
 * https://leetcode-cn.com/problems/split-array-largest-sum/
 */
public class Solution {
    public int splitArray(int[] nums, int m) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }

        int left = 0, right = sum;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(nums, m, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    private boolean check(int[] nums, int m, int maxSum) {
        int cnt = 0;
        int s = 0;

        for (int n : nums) {
            if (n > maxSum) {
                return false;
            }

            s += n;
            if (s > maxSum) {
                s = n;
                cnt++;
            }
        }

        return s <= maxSum && cnt + 1 <= m;
    }
}
