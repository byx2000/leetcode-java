package byx.leetcode.permutations_ii;

// https://leetcode.cn/problems/permutations-ii/

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        // 首先对所有元素排序，以方便去重
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        boolean[] flag = new boolean[nums.length];
        dfs(nums, 0, flag, new LinkedList<>(), result);
        return new ArrayList<>(result);
    }

    private void dfs(int[] nums, int index, boolean[] flag, LinkedList<Integer> p, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(p));
            return;
        }

        int last = -100;
        for (int i = 0; i < nums.length; i++) {
            if (!flag[i] && nums[i] != last) {
                last = nums[i];
                flag[i] = true;
                p.add(nums[i]);
                dfs(nums, index + 1, flag, p, result);
                p.removeLast();
                flag[i] = false;
            }
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Set.of(
                List.of(1, 1, 2),
                List.of(1, 2, 1),
                List.of(2, 1, 1)
        ), new HashSet<>(s.permuteUnique(new int[]{1, 1, 2})));
        assertEquals(Set.of(
                List.of(1, 2, 3),
                List.of(1, 3, 2),
                List.of(2, 1, 3),
                List.of(2, 3, 1),
                List.of(3, 1, 2),
                List.of(3, 2, 1)
        ), new HashSet<>(s.permuteUnique(new int[]{1, 2, 3})));
    }
}
