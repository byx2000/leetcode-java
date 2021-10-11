package byx.leetcode.problem.格雷编码;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/gray-code/
 */
public class Solution {
    public List<Integer> grayCode(int n) {
        if (n == 0) {
            return List.of(0);
        }

        List<Integer> r = grayCode(n - 1);
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < r.size(); ++i) {
            result.add(r.get(i) * 2);
        }
        for (int i = r.size() - 1; i >= 0; --i) {
            result.add(r.get(i) * 2 + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.grayCode(2));
    }
}
