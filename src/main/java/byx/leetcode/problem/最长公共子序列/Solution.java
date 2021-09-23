package byx.leetcode.problem.最长公共子序列;

/**
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 */
public class Solution {
    private Integer[][] cache;

    public int longestCommonSubsequence(String s1, String s2) {
        cache = new Integer[s1.length()][s2.length()];
        return dp(s1, s1.length() - 1, s2, s2.length() - 1);
    }

    private int dp(String s1, int i, String s2, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (cache[i][j] != null) {
            return cache[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return cache[i][j] = 1 + dp(s1, i - 1, s2, j - 1);
        } else {
            return cache[i][j] = Math.max(dp(s1, i - 1, s2, j), dp(s1, i, s2, j - 1));
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonSubsequence("abcde", "ace"));
        System.out.println(solution.longestCommonSubsequence("abc", "abc"));
        System.out.println(solution.longestCommonSubsequence("abc", "def"));
        System.out.println(solution.longestCommonSubsequence("mhunuzqrkzsnidwbun", "szulspmhwpazoxijwbq"));
    }
}
