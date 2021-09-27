package byx.leetcode.problem.最小K个数;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/smallest-k-lcci/
 */
public class Solution {
    public int[] smallestK(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int n : nums) {
            pq.add(n);
            if (pq.size() > k) {
                pq.remove();
            }
        }

        return pq.stream().mapToInt(n -> n).toArray();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.smallestK(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4)));
    }
}
