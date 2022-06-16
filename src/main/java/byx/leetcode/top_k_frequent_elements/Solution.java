package byx.leetcode.top_k_frequent_elements;

// https://leetcode.cn/problems/top-k-frequent-elements/

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 计算所有数字出现的次数
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int n : nums) {
            cnt.put(n, cnt.getOrDefault(n, 0) + 1);
        }

        // 维护k个元素的小根堆，堆中存放当前出现频率最大的k个元素
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> e : cnt.entrySet()) {
            if (pq.size() < k) {
                pq.add(e);
            } else {
                if (pq.peek().getValue() < e.getValue()) {
                    pq.remove();
                    pq.add(e);
                }
            }
        }

        return pq.stream().mapToInt(Map.Entry::getKey).toArray();
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Set.of(1, 2), Arrays.stream(s.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)).boxed().collect(Collectors.toSet()));
        assertEquals(Set.of(1), Arrays.stream(s.topKFrequent(new int[]{1}, 1)).boxed().collect(Collectors.toSet()));
    }
}
