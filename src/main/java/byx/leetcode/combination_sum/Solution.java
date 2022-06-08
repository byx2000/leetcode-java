package byx.leetcode.combination_sum;

// https://leetcode.cn/problems/combination-sum/

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, 0, target, new LinkedList<>(), result);
        return result;
    }

    private void dfs(int[] nums, int index, int sum, int target, LinkedList<Integer> path, List<List<Integer>> result) {
        if (index == nums.length) {
            if (sum == target) {
                result.add(new ArrayList<>(path));
            }
            return;
        }

        // 不选择nums[index]
        dfs(nums, index + 1, sum, target, path, result);

        // 选择nums[index]
        if (sum + nums[index] <= target) {
            path.add(nums[index]);
            dfs(nums, index, sum + nums[index], target, path, result);
            path.removeLast();
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Set.of(
                List.of(2, 2, 3),
                List.of(7)
        ), new HashSet<>(s.combinationSum(new int[]{2, 3, 6, 7}, 7)));
        assertEquals(Set.of(
                List.of(2, 2, 2, 2),
                List.of(2, 3, 3),
                List.of(3, 5)
        ), new HashSet<>(s.combinationSum(new int[]{2, 3, 5}, 8)));
        assertEquals(Set.of(), new HashSet<>(s.combinationSum(new int[]{2}, 1)));
    }
}
