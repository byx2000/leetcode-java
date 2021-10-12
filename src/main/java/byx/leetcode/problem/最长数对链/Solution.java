package byx.leetcode.problem.最长数对链;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/maximum-length-of-pair-chain/
 */
public class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);

        int cnt = 1;
        int end = pairs[0][1];

        for (int i = 1; i < pairs.length; ++i) {
            if (pairs[i][0] > end) {
                cnt++;
                end = pairs[i][1];
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findLongestChain(new int[][]{{1, 2}, {2, 3}, {3, 4}}));
    }
}
