package byx.leetcode.problem.两个数组的交集;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        List<Integer> result = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                if (result.size() == 0 || nums1[i] != result.get(result.size() - 1)) {
                    result.add(nums1[i]);
                }
                i++;
                j++;
            }
        }

        return result.stream().mapToInt(n -> n).toArray();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(solution.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }
}
