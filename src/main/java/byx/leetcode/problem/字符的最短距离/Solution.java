package byx.leetcode.problem.字符的最短距离;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/shortest-distance-to-a-character/
 */
public class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();

        int[] left = new int[n];
        left[0] = (s.charAt(0) == c) ? 0 : -1;
        for (int i = 1; i < n; ++i) {
            left[i] = (s.charAt(i) == c) ? i : left[i - 1];
        }

        int[] right = new int[s.length()];
        right[n - 1] = (s.charAt(n - 1) == c) ? n - 1 : -1;
        for (int i = n - 2; i >= 0; --i) {
            right[i] = (s.charAt(i) == c) ? i : right[i + 1];
        }

        int[] result = new int[n];
        for (int i = 0; i < n; ++i) {
            if (left[i] == -1) {
                result[i] = right[i] - i;
            } else if (right[i] == -1) {
                result[i] = i - left[i];
            } else {
                result[i] = Math.min(i - left[i], right[i] - i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.shortestToChar("loveleetcode", 'e')));
        System.out.println(Arrays.toString(solution.shortestToChar("aaab", 'b')));
    }
}
