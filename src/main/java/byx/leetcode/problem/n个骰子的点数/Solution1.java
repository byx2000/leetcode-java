package byx.leetcode.problem.n个骰子的点数;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/
 */
public class Solution1 {
    public double[] dicesProbability(int n) {
        int[] cnt = new int[5 * n + 1];
        dfs(0, n, 0, cnt);

        double[] result = new double[5 * n + 1];
        for (int i = 0; i < 5 * n + 1; ++i) {
            result[i] = cnt[i] / Math.pow(6, n);
        }

        return result;
    }

    private void dfs(int n, int maxn, int sum, int[] cnt) {
        if (n == maxn) {
            cnt[sum - maxn]++;
            return;
        }

        for (int i = 1; i <= 6; ++i) {
            dfs(n + 1, maxn, sum + i, cnt);
        }
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(Arrays.toString(solution.dicesProbability(1)));
        System.out.println(Arrays.toString(solution.dicesProbability(2)));
    }
}
