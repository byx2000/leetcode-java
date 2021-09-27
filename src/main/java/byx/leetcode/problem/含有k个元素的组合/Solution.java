package byx.leetcode.problem.含有k个元素的组合;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/uUsW3B/
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = i + 1;
        }

        List<Integer> comb = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, k, comb, result, 0);

        return result;
    }

    private void dfs(int[] nums, int k, List<Integer> comb, List<List<Integer>> result, int index) {
        if (comb.size() == k) {
            result.add(new ArrayList<>(comb));
            return;
        }

        if (index == nums.length) {
            return;
        }

        dfs(nums, k, comb, result, index + 1);

        comb.add(nums[index]);
        dfs(nums, k, comb, result, index + 1);
        comb.remove(comb.size() - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combine(4, 2));
        System.out.println(solution.combine(1, 1));
    }
}
