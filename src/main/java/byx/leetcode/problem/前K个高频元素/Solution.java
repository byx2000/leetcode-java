package byx.leetcode.problem.前K个高频元素;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((e1, e2) -> e1.getValue() - e2.getValue());

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            pq.add(e);
            if (pq.size() > k) {
                pq.remove();
            }
        }

        return pq.stream().map(e -> e.getKey()).mapToInt(n -> n).toArray();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1}, 1)));
    }
}
