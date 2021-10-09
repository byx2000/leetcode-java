package byx.leetcode.problem.含有重复元素集合的组合;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/4sjJUc/
 */
public class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<Integer> combine = new ArrayList<>();
        Set<List<Integer>> result = new HashSet<>();
        dfs(nums, target, combine, result, 0, 0);
        return new ArrayList<>(result);
    }

    private void dfs(int[] nums, int target, List<Integer> combine, Set<List<Integer>> result, int index, int sum) {
        if (sum == target) {
            List<Integer> t = new ArrayList<>(combine);
            Collections.sort(t);
            result.add(t);
            return;
        }

        if (sum > target) {
            return;
        }

        if (index == nums.length) {
            return;
        }

        dfs(nums, target, combine, result, index + 1, sum);

        combine.add(nums[index]);
        dfs(nums, target, combine, result, index + 1, sum + nums[index]);
        combine.remove(combine.size() - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(solution.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }
}
