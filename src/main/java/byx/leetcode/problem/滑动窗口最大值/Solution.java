package byx.leetcode.problem.滑动窗口最大值;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int i = 0, j = 0;
        int[] maxVal = new int[nums.length - k + 1];

        while (j < nums.length) {
            if (j - i < k) {
                pq.add(nums[j]);
                j++;
            } else {
                maxVal[i] = pq.peek();
                pq.remove(nums[i]);
                pq.add(nums[j]);
                i++;
                j++;
            }
        }

        maxVal[i] = pq.peek();

        return maxVal;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
