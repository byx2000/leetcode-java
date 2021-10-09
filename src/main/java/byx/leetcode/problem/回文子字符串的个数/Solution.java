package byx.leetcode.problem.回文子字符串的个数;

/**
 * https://leetcode-cn.com/problems/a7VOhD/
 */
public class Solution {
    private Boolean[][] cache;

    public int countSubstrings(String s) {
        int cnt = 0;
        cache = new Boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); ++i) {
            for (int j = i; j < s.length(); ++j) {
                if (match(s, i, j)) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private boolean match(String s, int i, int j) {
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
            return cache[i][j] = match(s, i + 1, j - 1);
        } else {
            return cache[i][j] = false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countSubstrings("abc"));
        System.out.println(solution.countSubstrings("aaa"));
    }
}
