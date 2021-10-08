package byx.leetcode.problem.字符串解码;

/**
 * https://leetcode-cn.com/problems/decode-string/
 */
public class Solution {
    private String s;
    private int index;

    private char ch() {
        return s.charAt(index);
    }

    private boolean end() {
        return index == s.length();
    }

    // t1 = alpha | integer[t2]
    private String t1() {
        char c = ch();
        if (c >= 'a' && c <= 'z') {
            index++;
            return String.valueOf(c);
        } else {
            int cnt = 0;
            while (ch() >= '0' && ch() <= '9') {
                cnt = cnt * 10 + (ch() - '0');
                index++;
            }
            index++; // [
            String t = t2();
            index++; // ]
            return t.repeat(cnt);
        }
    }

    // t2 = t1 t1 ... t1
    private String t2() {
        String t = "";
        while (!end() && ch() != ']') {
            t += t1();
        }
        return t;
    }

    public String decodeString(String s) {
        this.s = s;
        this.index = 0;
        return t2();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.decodeString("3[a]2[bc]"));
        System.out.println(solution.decodeString("3[a2[c]]"));
        System.out.println(solution.decodeString("2[abc]3[cd]ef"));
        System.out.println(solution.decodeString("abc3[cd]xyz"));
    }
}
