package byx.leetcode.problem.分数到小数;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/fraction-to-recurring-decimal/
 */
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long n1 = numerator, n2 = denominator;
        String sign = (n1 * n2 < 0) ? "-" : "";
        n1 = Math.abs(n1);
        n2 = Math.abs(n2);

        long d = n1 / n2;
        long r = n1 - d * n2;

        if (r == 0) {
            return sign + d;
        }

        String p1 = String.valueOf(d);
        String p2 = "";
        Map<Long, Integer> map = new HashMap<>();

        while (true) {
            if (r == 0) {
                break;
            }

            if (map.containsKey(r)) {
                break;
            }

            map.put(r, p2.length());
            d = r * 10 / n2;
            p2 += d;
            r = r * 10 - d * n2;
        }

        if (map.containsKey(r)) {
            int index = map.get(r);
            return sign + p1 + "." + p2.substring(0, index) + "(" + p2.substring(index) + ")";
        } else {
            return sign + p1 + "." + p2;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fractionToDecimal(1, 2));
        System.out.println(solution.fractionToDecimal(1, 3));
        System.out.println(solution.fractionToDecimal(1, 6));
    }
}
