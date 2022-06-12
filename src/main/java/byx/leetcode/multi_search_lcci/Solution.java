package byx.leetcode.multi_search_lcci;

// https://leetcode.cn/problems/multi-search-lcci/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[][] multiSearch(String big, String[] smalls) {
        int[][] result = new int[smalls.length][];
        for (int i = 0; i < smalls.length; i++) {
            if (smalls[i].length() == 0) {
                result[i] = new int[]{};
                continue;
            }

            List<Integer> idx = new ArrayList<>();
            int j = 0;
            while (true) {
                j = big.indexOf(smalls[i], j);
                if (j != -1) {
                    idx.add(j);
                    j++;
                } else {
                    break;
                }
            }
            result[i] = idx.stream().mapToInt(n -> n).toArray();
        }
        return result;
    }
}
