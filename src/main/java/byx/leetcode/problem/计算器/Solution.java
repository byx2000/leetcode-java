package byx.leetcode.problem.计算器;

/**
 * https://leetcode-cn.com/problems/calculator-lcci/
 */
public class Solution {
    private String expr;
    private int index;

    private char ch() {
        return expr.charAt(index);
    }

    private boolean end() {
        return index == expr.length();
    }

    // t1 = integer
    private int t1() {
        int result = 0;
        while (!end() && ch() >= '0' && ch() <= '9') {
            result = result * 10 + (ch() - '0');
            index++;
        }
        return result;
    }

    // t2 = t1 (*|/) t1 (*|/) t1 ...
    private int t2() {
        int result = t1();
        while (!end() && (ch() == '*' || ch() == '/')) {
            char op = ch();
            index++;
            if (op == '*') {
                result = result * t1();
            } else {
                result = result / t1();
            }
        }
        return result;
    }

    // t3 = t2 (+|-) t2 (+|-) t2 ...
    private int t3() {
        int result = t2();
        while (!end() && (ch() == '+' || ch() == '-')) {
            char op = ch();
            index++;
            if (op == '+') {
                result = result + t2();
            } else {
                result = result - t2();
            }
        }
        return result;
    }

    public int calculate(String s) {
        this.expr = s.replace(" ", "");
        this.index = 0;

        return t3();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.calculate("3+2*2"));
        System.out.println(solution.calculate(" 3/2 "));
        System.out.println(solution.calculate(" 3+5 / 2 "));
    }
}
