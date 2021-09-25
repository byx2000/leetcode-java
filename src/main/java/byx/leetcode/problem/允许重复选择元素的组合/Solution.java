package byx.leetcode.problem.允许重复选择元素的组合;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/Ygoe9J/
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> choose = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, target, 0, 0, choose, result);
        return result;
    }

    private void dfs(int[] nums, int target, int index, int sum, List<Integer> choose, List<List<Integer>> result) {
        if (sum == target) {
            result.add(new ArrayList<>(choose));
            return;
        }

        if (sum > target) {
            return;
        }

        if (index == nums.length) {
            return;
        }

        dfs(nums, target, index + 1, sum, choose, result);

        choose.add(nums[index]);
        dfs(nums, target, index, sum + nums[index], choose, result);
        choose.remove(choose.size() - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(solution.combinationSum(new int[]{2, 3, 5}, 8));
        System.out.println(solution.combinationSum(new int[]{2}, 1));
        System.out.println(solution.combinationSum(new int[]{1}, 1));
        System.out.println(solution.combinationSum(new int[]{1}, 2));
    }
}
