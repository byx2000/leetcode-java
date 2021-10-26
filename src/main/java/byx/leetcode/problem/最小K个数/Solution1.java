package byx.leetcode.problem.最小K个数;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/smallest-k-lcci/
 */
public class Solution1 {
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
}
