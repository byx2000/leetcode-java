package byx.leetcode.problem.分割数组的最大值;

/**
 * https://leetcode-cn.com/problems/split-array-largest-sum/
 */
public class Solution2 {
    public int splitArray(int[] nums, int m) {
        Integer[][] cache = new Integer[nums.length][m + 1];
        return dp(nums, cache, nums.length - 1, m);
    }

    // 将nums[0]~nums[index]分成m个子数组
    private int dp(int[] nums, Integer[][] cache, int index, int m) {
        if (cache[index][m] != null) {
            return cache[index][m];
        }

        if (m == 1) {
            int sum = 0;
            for (int i = 0; i <= index; ++i) {
                sum += nums[i];
            }
            return cache[index][m] = sum;
        }

        if (index + 1 == m) {
            int maxVal = nums[0];
            for (int i = 1; i <= index; ++i) {
                maxVal = Math.max(maxVal, nums[i]);
            }
            return cache[index][m] = maxVal;
        }

        int sum = nums[index];
        int result = Integer.MAX_VALUE;

        for (int i = index - 1; i >= 0 && i + 1 >= m - 1; --i) {
            result = Math.min(result, Math.max(sum, dp(nums, cache, i, m - 1)));
            sum += nums[i];
        }

        return cache[index][m] = result;
    }
}
