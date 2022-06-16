package byx.leetcode.subsets_ii;

// https://leetcode.cn/problems/subsets-ii/

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 首先对nums排序，以方便去重
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, new LinkedList<>(), result);
        return new ArrayList<>(result);
    }

    private void dfs(int[] nums, int index, LinkedList<Integer> set, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(set));
            return;
        }

        // 不选择nums[i]
        int i = index;
        while (i < nums.length && nums[i] == nums[index]) {
            i++;
        }
        dfs(nums, i, set, result);

        // 选择nums[i]
        set.add(nums[index]);
        dfs(nums, index + 1, set, result);
        set.removeLast();
    }

    @Test
    public void test() {
        Solution s = new Solution();
        verify(Set.of(
                List.of(),
                List.of(0)
        ), new HashSet<>(s.subsetsWithDup(new int[]{0})));
        verify(Set.of(
                List.of(),
                List.of(1),
                List.of(1, 2),
                List.of(1, 2, 2),
                List.of(2),
                List.of(2, 2)
        ), new HashSet<>(s.subsetsWithDup(new int[]{1, 2, 2})));
    }

    private void verify(Set<List<Integer>> s1, Set<List<Integer>> s2) {
        assertEquals(s1.stream().map(HashSet::new).collect(Collectors.toSet()), s2.stream().map(HashSet::new).collect(Collectors.toSet()));
    }
}
