package byx.leetcode.problem.四数之和;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/4sum/
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                int m = j + 1, n = nums.length - 1;
                while (m < n) {
                    int sum = nums[i] + nums[j] + nums[m] + nums[n];
                    if (sum < target) {
                        m++;
                    } else if (sum > target) {
                        n--;
                    } else {
                        List<Integer> list = new ArrayList<>(List.of(nums[i], nums[j], nums[m], nums[n]));
                        Collections.sort(list);
                        set.add(list);
                        m++;
                    }
                }
            }
        }

        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        System.out.println(solution.fourSum(new int[]{2, 2, 2, 2, 2}, 8));
    }
}
