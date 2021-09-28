package byx.leetcode.problem.找到K个最接近的元素;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/find-k-closest-elements/
 */
public class Solution {
    public List<Integer> findClosestElements(int[] nums, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if (Math.abs(a - x) == Math.abs(b - x)) {
                return b - a;
            }
            return Math.abs(b - x) - Math.abs(a - x);
        });

        for (int n : nums) {
            pq.add(n);
            if (pq.size() > k) {
                pq.remove();
            }
        }

        List<Integer> result = new ArrayList<>(pq);
        Collections.sort(result);

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3));
        System.out.println(solution.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, -1));
    }
}
