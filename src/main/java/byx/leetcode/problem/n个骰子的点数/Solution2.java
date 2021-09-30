package byx.leetcode.problem.n个骰子的点数;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/
 */
public class Solution2 {
    private Double[][] cache;

    public double[] dicesProbability(int n) {
        double[] result = new double[5 * n + 1];
        cache = new Double[n + 1][6 * n + 1];
        for (int i = 0; i < 5 * n + 1; ++i) {
            result[i] = dp(n, n + i);
        }
        return result;
    }

    // n个骰子点数和为x的概率
    private double dp(int n, int x) {
        if (cache[n][x] != null) {
            return cache[n][x];
        }

        if (n == 1) {
            return cache[n][x] = x <= 6 ? 1.0 / 6.0 : 0.0;
        }

        double p = 0.0;
        int cnt = 0;
        for (int i = 1; i <= 6; ++i) {
            if (x - i >= 1) {
                p += dp(n - 1, x - i);
                cnt++;
            }
        }

        return cache[n][x] = p / 6.0;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(Arrays.toString(solution.dicesProbability(1)));
        System.out.println(Arrays.toString(solution.dicesProbability(2)));
    }
}
