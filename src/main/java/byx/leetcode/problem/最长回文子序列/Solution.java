package byx.leetcode.problem.最长回文子序列;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-subsequence/
 */
public class Solution {
    private Integer[][] cache;

    public int longestPalindromeSubseq(String s) {
        cache = new Integer[s.length()][s.length()];
        return dp(s, 0, s.length() - 1);
    }

    // s[i]~s[j]的最长回文子序列长度
    private int dp(String s, int i, int j) {
        if (cache[i][j] != null) {
            return cache[i][j];
        }

        if (i == j) {
            return cache[i][j] = 1;
        }

        if (i + 1 == j) {
            return cache[i][j] = (s.charAt(i) == s.charAt(j)) ? 2 : 1;
        }

        if (s.charAt(i) == s.charAt(j)) {
            return cache[i][j] = 2 + dp(s, i + 1, j - 1);
        } else {
            return cache[i][j] = Math.max(dp(s, i + 1, j), dp(s, i, j - 1));
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindromeSubseq("bbbab"));
        System.out.println(solution.longestPalindromeSubseq("cbbd"));
    }
}
