package byx.leetcode.problem.子集II;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/subsets-ii/
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> subset = new ArrayList<>();
        Set<List<Integer>> result = new HashSet<>();
        dfs(nums, 0, subset, result);
        return new ArrayList<>(result);
    }

    private void dfs(int[] nums, int index, List<Integer> subset, Set<List<Integer>> result) {
        if (index == nums.length) {
            List<Integer> list = new ArrayList<>(subset);
            Collections.sort(list);
            result.add(list);
            return;
        }

        dfs(nums, index + 1, subset, result);

        subset.add(nums[index]);
        dfs(nums, index + 1, subset, result);
        subset.remove(subset.size() - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subsetsWithDup(new int[]{1, 2, 2}));
        System.out.println(solution.subsetsWithDup(new int[]{4, 4, 4, 1, 4}));
    }
}
