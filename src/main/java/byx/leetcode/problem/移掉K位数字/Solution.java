package byx.leetcode.problem.移掉K位数字;

/**
 * https://leetcode-cn.com/problems/remove-k-digits/
 */
public class Solution {
    public String removeKdigits(String num, int k) {
        for (int i = 0; i < k; ++i) {
            boolean flag = false;
            for (int j = 0; j < num.length() - 1; ++j) {
                if (num.charAt(j) > num.charAt(j + 1)) {
                    num = num.substring(0, j) + num.substring(j + 1);
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                num = num.substring(0, num.length() - 1);
            }
        }

        if ("".equals(num)) {
            num = "0";
        }

        while (!"0".equals(num) && num.charAt(0) == '0') {
            num = num.substring(1);
        }

        return num;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeKdigits("1432219", 3));
        System.out.println(solution.removeKdigits("10200", 1));
        System.out.println(solution.removeKdigits("10", 2));
        System.out.println(solution.removeKdigits("10", 1));
    }
}
