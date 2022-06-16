package byx.leetcode.subsets;

// https://leetcode.cn/problems/subsets/

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, new LinkedList<>(), result);
        return result;
    }

    public void dfs(int[] nums, int index, LinkedList<Integer> set, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(set));
            return;
        }

        // 选择nums[index]
        set.add(nums[index]);
        dfs(nums, index + 1, set, result);
        set.removeLast();

        // 不选择nums[index]
        dfs(nums, index + 1, set, result);
    }

    @Test
    public void test() {
        Solution s = new Solution();
        verify(Set.of(
                List.of(),
                List.of(0)
        ), new HashSet<>(s.subsets(new int[]{0})));
        verify(Set.of(
                List.of(),
                List.of(1),
                List.of(2),
                List.of(3),
                List.of(1, 2),
                List.of(1, 3),
                List.of(2, 3),
                List.of(1, 2, 3)
        ), new HashSet<>(s.subsets(new int[]{1, 2, 3})));
    }

    private void verify(Set<List<Integer>> s1, Set<List<Integer>> s2) {
        assertEquals(s1.stream().map(HashSet::new).collect(Collectors.toSet()), s2.stream().map(HashSet::new).collect(Collectors.toSet()));
    }
}
