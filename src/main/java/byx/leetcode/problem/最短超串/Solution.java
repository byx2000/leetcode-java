package byx.leetcode.problem.最短超串;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/shortest-supersequence-lcci/
 */
public class Solution {
    public int[] shortestSeq(int[] big, int[] small) {
        Set<Integer> set = new HashSet<>();
        for (int n : small) {
            set.add(n);
        }

        Map<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int minLen = Integer.MAX_VALUE;
        int left = -1, right = -1;

        while (j < big.length) {
            if (map.size() < set.size()) {
                if (set.contains(big[j])) {
                    map.put(big[j], map.getOrDefault(big[j], 0) + 1);
                }
                j++;
            } else {
                if (j - i < minLen) {
                    minLen = j - i;
                    left = i;
                    right = j - 1;
                }

                if (set.contains(big[i])) {
                    int cnt = map.get(big[i]);
                    if (cnt == 1) {
                        map.remove(big[i]);
                    } else {
                        map.put(big[i], cnt - 1);
                    }
                }
                i++;
            }
        }

        while (map.size() == set.size()) {
            if (j - i < minLen) {
                minLen = j - i;
                left = i;
                right = j - 1;
            }

            if (set.contains(big[i])) {
                int cnt = map.get(big[i]);
                if (cnt == 1) {
                    map.remove(big[i]);
                } else {
                    map.put(big[i], cnt - 1);
                }
            }
            i++;
        }

        if (left < 0) {
            return new int[]{};
        } else {
            return new int[]{left, right};
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.shortestSeq(new int[]{7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7}, new int[]{1, 5, 9})));
        System.out.println(Arrays.toString(solution.shortestSeq(new int[]{1, 2, 3}, new int[]{4})));
    }
}
