package byx.leetcode.problem.最大平均值和的分组;

/**
 * https://leetcode-cn.com/problems/largest-sum-of-averages/
 */
public class Solution {
    private Double[][] cache;

    public double largestSumOfAverages(int[] nums, int k) {
        cache = new Double[nums.length][k + 1];
        return dp(nums, nums.length - 1, k);
    }

    // 将nums[0]~nums[index]分成k份
    private double dp(int[] nums, int index, int k) {
        if (cache[index][k] != null) {
            return cache[index][k];
        }

        if (k == 1) {
            double sum = 0;
            for (int i = 0; i <= index; ++i) {
                sum += nums[i];
            }
            return cache[index][k] = sum / (index + 1);
        }

        if (k == index + 1) {
            double sum = 0;
            for (int i = 0; i <= index; ++i) {
                sum += nums[i];
            }
            return cache[index][k] = sum;
        }

        double sum = nums[index];
        double maxScore = Double.MIN_VALUE;
        for (int i = index - 1; i >= 0 && i >= k - 2; --i) {
            maxScore = Math.max(maxScore, sum / (index - i) + dp(nums, i, k - 1));
            sum += nums[i];
        }

        return cache[index][k] = maxScore;
    }
}
