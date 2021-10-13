package byx.leetcode.problem.分割等和子集;

/**
 * https://leetcode-cn.com/problems/NUPfPr/
 */
public class Solution {
    private Boolean[][] cache;

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }

        if (sum % 2 == 1) {
            return false;
        }

        cache = new Boolean[nums.length][sum / 2 + 1];
        return dp(nums, sum / 2, nums.length - 1);
    }

    // nums[0]~nums[index]是否具有和为sum的子集
    private boolean dp(int[] nums, int sum, int index) {
        if (sum < 0) {
            return false;
        }

        if (cache[index][sum] != null) {
            return cache[index][sum];
        }

        if (index == 0) {
            return cache[index][sum] = sum == 0 || sum == nums[0];
        }
        return cache[index][sum] = dp(nums, sum, index - 1) || dp(nums, sum - nums[index], index - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(solution.canPartition(new int[]{1, 2, 3, 5}));
    }
}
