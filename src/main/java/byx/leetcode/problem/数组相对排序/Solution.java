package byx.leetcode.problem.数组相对排序;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/0H97ZC/
 */
public class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for (int n : arr2) {
            set.add(n);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr1) {
            if (set.contains(n)) {
                map.put(n, map.getOrDefault(n, 0) + 1);
            }
        }

        List<Integer> r1 = new ArrayList<>();
        for (int n : arr2) {
            if (map.containsKey(n)) {
                int cnt = map.get(n);
                for (int i = 0; i < cnt; ++i) {
                    r1.add(n);
                }
            }
        }

        List<Integer> r2 = new ArrayList<>();
        for (int n : arr1) {
            if (!set.contains(n)) {
                r2.add(n);
            }
        }
        Collections.sort(r2);

        List<Integer> result = new ArrayList<>(r1);
        result.addAll(r2);

        return result.stream().mapToInt(n -> n).toArray();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6})));
    }
}
