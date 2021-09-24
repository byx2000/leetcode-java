package byx.leetcode.problem.全排列II;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/permutations-ii/
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] flag = new boolean[nums.length];
        List<Integer> p = new ArrayList<>();
        Set<List<Integer>> result = new HashSet<>();
        dfs(nums, 0, flag, p, result);
        return new ArrayList<>(result);
    }

    private void dfs(int[] nums, int index, boolean[] flag, List<Integer> p, Set<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(p));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (!flag[i]) {
                flag[i] = true;
                p.add(nums[i]);
                dfs(nums, index + 1, flag, p, result);
                p.remove(p.size() - 1);
                flag[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.permuteUnique(new int[]{1, 1, 2}));
        System.out.println(solution.permuteUnique(new int[]{1, 2, 3}));
    }
}
