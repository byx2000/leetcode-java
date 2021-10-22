package byx.leetcode.problem.统计比给定整数小的数的个数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.lintcode.com/problem/248/description
 */
public class Solution {
    public List<Integer> countOfSmallerNumber(int[] nums, int[] queries) {
        Arrays.sort(nums);

        List<Integer> result = new ArrayList<>();
        for (int q : queries) {
            result.add(find(nums, q));
        }

        return result;
    }

    // 查找nums中第一个大于等于target的下标
    private int find(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int result = nums.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}
