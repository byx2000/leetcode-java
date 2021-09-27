package byx.leetcode.problem.数组中的第K个最大元素;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : nums) {
            pq.add(n);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(solution.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
