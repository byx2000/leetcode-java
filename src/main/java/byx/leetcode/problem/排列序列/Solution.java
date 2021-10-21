package byx.leetcode.problem.排列序列;

/**
 * https://leetcode-cn.com/problems/permutation-sequence/
 */
public class Solution {
    private int k, cnt;
    private String result;

    public String getPermutation(int n, int k) {
        this.k = k;
        this.cnt = 0;

        try {
            int[] nums = new int[n];
            for (int i = 0; i < n; ++i) {
                nums[i] = i + 1;
            }
            dfs(nums, new boolean[nums.length], "", 0);
        } catch (RuntimeException e) {
            return result;
        }

        throw new RuntimeException();
    }

    private void dfs(int[] nums, boolean[] flag, String s, int index) {
        if (index == nums.length) {
            cnt++;
            if (cnt == k) {
                result = s;
                throw new RuntimeException();
            }
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (!flag[i]) {
                flag[i] = true;
                dfs(nums, flag, s + nums[i], index + 1);
                flag[i] = false;
            }
        }
    }
}
