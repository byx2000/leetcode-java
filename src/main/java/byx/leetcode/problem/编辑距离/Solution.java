package byx.leetcode.problem.编辑距离;

/**
 * https://leetcode-cn.com/problems/edit-distance/
 */
public class Solution {
    public int minDistance(String s1, String s2) {
        return dp(s1, s2, new Integer[s1.length()][s2.length()], 0, 0);
    }

    private int dp(String s1, String s2, Integer[][] cache, int i, int j) {
        if (i == s1.length()) {
            return s2.length() - j;
        }

        if (j == s2.length()) {
            return s1.length() - i;
        }

        if (cache[i][j] != null) {
            return cache[i][j];
        }

        int result = dp(s1, s2, cache, i + 1, j + 1);
        if (s1.charAt(i) != s2.charAt(j)) {
            result++;
            result = Math.min(result, 1 + dp(s1, s2, cache, i + 1, j));
            result = Math.min(result, 1 + dp(s1, s2, cache, i, j + 1));
        }

        return cache[i][j] = result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minDistance("horse", "ros"));
        System.out.println(solution.minDistance("intention", "execution"));
        System.out.println(solution.minDistance("dinitrophenylhydrazine", "acetylphenylhydrazine"));
    }
}
