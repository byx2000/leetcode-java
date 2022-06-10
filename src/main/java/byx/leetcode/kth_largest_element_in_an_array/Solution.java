package byx.leetcode.kth_largest_element_in_an_array;

// https://leetcode.cn/problems/kth-largest-element-in-an-array/

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : nums) {
            if (pq.size() < k) {
                pq.add(n);
            } else if (n > pq.peek()) {
                pq.remove();
                pq.add(n);
            }
        }
        return pq.peek();
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(5, s.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        assertEquals(4, s.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
