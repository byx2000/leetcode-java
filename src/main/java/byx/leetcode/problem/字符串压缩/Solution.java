package byx.leetcode.problem.字符串压缩;

/**
 * https://leetcode-cn.com/problems/compress-string-lcci/
 */
public class Solution {
    public String compressString(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;

        while (i < s.length()) {
            int cnt = 0, j = i;
            while (j < s.length() && s.charAt(j) == s.charAt(i)) {
                j++;
                cnt++;
            }
            sb.append(s.charAt(i)).append(cnt);
            i = j;
        }

        if (sb.length() >= s.length()) {
            return s;
        } else {
            return sb.toString();
        }
    }
}
