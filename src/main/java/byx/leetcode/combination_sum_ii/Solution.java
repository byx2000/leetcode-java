package byx.leetcode.combination_sum_ii;

// https://leetcode.cn/problems/combination-sum-ii/

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        // 首先对所有元素排序，以方便去重
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, 0, target, new LinkedList<>(), result);
        return result.stream().map(ArrayList::new).collect(Collectors.toList());
    }

    private void dfs(int[] nums, int index, int sum, int target, LinkedList<Integer> path, List<List<Integer>> result) {
        if (index == nums.length) {
            if (sum == target) {
                result.add(new ArrayList<>(path));
            }
            return;
        }

        // 不选择nums[index]，直接跳到下一个不同的数字
        int i = index;
        while (i < nums.length && nums[i] == nums[index]) {
            i++;
        }
        dfs(nums, i, sum, target, path, result);

        // 选择nums[index]
        if (sum + nums[index] <= target) {
            path.add(nums[index]);
            dfs(nums, index + 1, sum + nums[index], target, path, result);
            path.removeLast();
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Set.of(
                List.of(1, 1, 6),
                List.of(1, 2, 5),
                List.of(1, 7),
                List.of(2, 6)
        ), new HashSet<>(s.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8)));
        assertEquals(Set.of(
                List.of(1, 2, 2),
                List.of(5)
        ), new HashSet<>(s.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5)));
    }
}
