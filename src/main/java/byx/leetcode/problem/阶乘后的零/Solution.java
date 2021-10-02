package byx.leetcode.problem.阶乘后的零;

/**
 * https://leetcode-cn.com/problems/factorial-trailing-zeroes/
 */
public class Solution {
    public int trailingZeroes(int n) {
        int cnt = 0;
        for (int i = 1; i <= n; ++i) {
            cnt += factor5(i);
        }
        return cnt;
    }

    private int factor5(int n) {
        int cnt = 0;
        while (n % 5 == 0) {
            n /= 5;
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.trailingZeroes(100));
    }
}
