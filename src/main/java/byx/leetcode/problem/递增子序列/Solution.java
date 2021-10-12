package byx.leetcode.problem.递增子序列;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/increasing-subsequences/
 */
public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<Integer> seq = new ArrayList<>();
        Set<List<Integer>> result = new HashSet<>();
        dfs(nums, seq, result, 0);
        return new ArrayList<>(result);
    }

    private void dfs(int[] nums, List<Integer> seq, Set<List<Integer>> result, int index) {
        if (index == nums.length) {
            if (seq.size() >= 2) {
                result.add(new ArrayList<>(seq));
            }
            return;
        }

        dfs(nums, seq, result, index + 1);

        if (seq.size() == 0 || nums[index] >= seq.get(seq.size() - 1)) {
            seq.add(nums[index]);
            dfs(nums, seq, result, index + 1);
            seq.remove(seq.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findSubsequences(new int[]{4, 6, 7, 7}));
        System.out.println(solution.findSubsequences(new int[]{4,4,3,2,1}));
    }
}
