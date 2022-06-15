package byx.leetcode.shortest_supersequence_lcci;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

// https://leetcode.cn/problems/shortest-supersequence-lcci/

public class Solution {
    public int[] shortestSeq(int[] big, int[] small) {
        Map<Integer, Integer> s1 = new HashMap<>();
        for (int n : small) {
            s1.put(n, s1.getOrDefault(n, 0) + 1);
        }

        Map<Integer, Integer> s2 = new HashMap<>();
        int i = 0;
        int j = 0;
        int minLen = Integer.MAX_VALUE;
        int begin = -1;
        int end = -1;

        while (j < big.length) {
            while (j < big.length && !cover(s1, s2)) {
                s2.put(big[j], s2.getOrDefault(big[j], 0) + 1);
                j++;
            }

            while (cover(s1, s2)) {
                if (j - i < minLen) {
                    minLen = j - i;
                    begin = i;
                    end = j - 1;
                }
                s2.put(big[i], s2.get(big[i]) - 1);
                i++;
            }
        }

        return begin < 0 ? new int[]{} : new int[]{begin, end};
    }

    // 判断s2能否覆盖s1
    private boolean cover(Map<Integer, Integer> s1, Map<Integer, Integer> s2) {
        for (Integer k : s1.keySet()) {
            if (!s2.containsKey(k) || s2.get(k) == 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[]{7, 10}, s.shortestSeq(new int[]{7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7}, new int[]{1, 5, 9}));
        assertArrayEquals(new int[]{}, s.shortestSeq(new int[]{1, 2, 3}, new int[]{4}));
    }
}
