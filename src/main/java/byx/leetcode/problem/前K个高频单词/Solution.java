package byx.leetcode.problem.前K个高频单词;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-words/
 */
public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((e1, e2) -> {
            if (e1.getValue().equals(e2.getValue())) {
                return e2.getKey().compareTo(e1.getKey());
            }
            return e1.getValue() - e2.getValue();
        });

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            pq.add(e);
            if (pq.size() > k) {
                pq.remove();
            }
        }

        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.remove().getKey());
        }
        Collections.reverse(result);

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
        System.out.println(solution.topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
    }
}
