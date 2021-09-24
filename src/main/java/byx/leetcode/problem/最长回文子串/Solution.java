package byx.leetcode.problem.最长回文子串;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class Solution {
    private Boolean[][] cache;

    public String longestPalindrome(String s) {
        cache = new Boolean[s.length()][s.length()];
        int maxLen = -1;
        int start = -1, end = -1;

        for (int i = 0; i < s.length(); ++i) {
            for (int j = i; j < s.length(); ++j) {
                if (dp(s, i, j)) {
                    if (maxLen < j - i + 1) {
                        maxLen = j - i + 1;
                        start = i;
                        end = j;
                    }
                }
            }
        }

        return s.substring(start, end + 1);
    }

    // s[i]~s[j]是不是回文子串
    private boolean dp(String s, int i, int j) {
        if (cache[i][j] != null) {
            return cache[i][j];
        }

        if (i == j) {
            return cache[i][j] = true;
        }

        if (i + 1 == j) {
            return cache[i][j] = s.charAt(i) == s.charAt(j);
        }

        if (s.charAt(i) == s.charAt(j)) {
            return cache[i][j] = dp(s, i + 1, j - 1);
        } else {
            return cache[i][j] = false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("babad"));
        System.out.println(solution.longestPalindrome("cbbd"));
        System.out.println(solution.longestPalindrome("a"));
        System.out.println(solution.longestPalindrome("ac"));
    }
}
