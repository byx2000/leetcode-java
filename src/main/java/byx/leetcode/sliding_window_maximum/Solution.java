package byx.leetcode.sliding_window_maximum;

// https://leetcode.cn/problems/sliding-window-maximum/

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < k; i++) {
            pq.add(new int[]{nums[i], i});
        }

        int[] result = new int[nums.length - k + 1];
        result[0] = pq.peek()[0];

        for (int i = 1; i + k <= nums.length; i++) {
            pq.add(new int[]{nums[i + k - 1], i + k - 1});
            while (pq.peek()[1] < i) {
                pq.remove();
            }
            result[i] = pq.peek()[0];
        }

        return result;
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[]{3, 3, 5, 5, 6, 7}, s.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
        assertArrayEquals(new int[]{1}, s.maxSlidingWindow(new int[]{1}, 1));
    }
}
