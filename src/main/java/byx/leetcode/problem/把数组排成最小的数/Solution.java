package byx.leetcode.problem.把数组排成最小的数;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
 */
public class Solution {
    public String minNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int n : nums) {
            list.add(n);
        }

        list.sort((a, b) -> {
            String n1 = a.toString() + b.toString();
            String n2 = b.toString() + a.toString();
            return n1.compareTo(n2);
        });

        StringBuilder sb = new StringBuilder();
        for (Integer n : list) {
            sb.append(n.toString());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minNumber(new int[]{10, 2}));
        System.out.println(solution.minNumber(new int[]{3, 30, 34, 5, 9}));
    }
}
