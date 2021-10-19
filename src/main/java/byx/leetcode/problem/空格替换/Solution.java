package byx.leetcode.problem.空格替换;

/**
 * https://www.lintcode.com/problem/212/
 */
public class Solution {
    public int replaceBlank(char[] s, int length) {
        int cnt = 0;
        for (int i = 0; i < length; ++i) {
            if (s[i] == ' ') {
                cnt++;
            }
        }

        int newLen = length + cnt * 2;
        int i = newLen - 1, j = length - 1;

        while (j >= 0) {
            if (s[j] == ' ') {
                s[i--] = '0';
                s[i--] = '2';
                s[i--] = '%';
            } else {
                s[i--] = s[j];
            }
            j--;
        }

        return newLen;
    }
}
