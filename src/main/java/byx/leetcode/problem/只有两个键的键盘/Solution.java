package byx.leetcode.problem.只有两个键的键盘;

/**
 * https://leetcode-cn.com/problems/2-keys-keyboard/
 */
public class Solution {
    public int minSteps(int n) {
        return dp(n, new Integer[n][n], 1, 0);
    }

    // 一共需要输出n个a，当前已输出current个a，剪切板有clipboard个a
    private int dp(int n, Integer[][] cache, int current, int clipboard) {
        if (current == n) {
            return 0;
        }

        if (current > n) {
            return 99999;
        }

        if (cache[current][clipboard] != null) {
            return cache[current][clipboard];
        }

        if (clipboard > 0) {
            return cache[current][clipboard] = Math.min(
                    1 + dp(n, cache, current + clipboard, clipboard),
                    2 + dp(n, cache, current * 2, current)
            );
        } else {
            return cache[current][clipboard] = 2 + dp(n, cache, current * 2, current);
        }
    }
}
