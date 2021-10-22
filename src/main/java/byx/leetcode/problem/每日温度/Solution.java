package byx.leetcode.problem.每日温度;

/**
 * https://leetcode-cn.com/problems/daily-temperatures/
 */
public class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int[] result = new int[temp.length];
        result[result.length - 1] = 0;

        for (int i = result.length - 2; i >= 0; --i) {
            int j = i + 1;
            while (j < temp.length) {
                if (temp[i] < temp[j]) {
                    result[i] = j - i;
                    break;
                }
                if (result[j] == 0) {
                    result[i] = 0;
                    break;
                }
                j += result[j];
            }
        }

        return result;
    }
}
