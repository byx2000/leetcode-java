package byx.leetcode.problem.复原IP;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/0on3uN/
 */
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();

        for (int i = 1; i < s.length(); ++i) {
            for (int j = i + 1; j < s.length(); ++j) {
                for (int k = j + 1; k < s.length(); ++k) {
                    String s1 = s.substring(0, i);
                    String s2 = s.substring(i, j);
                    String s3 = s.substring(j, k);
                    String s4 = s.substring(k);

                    if (valid(s1) && valid(s2) && valid(s3) && valid(s4)) {
                        result.add(s1 + "." + s2 + "." + s3 + "." + s4);
                    }
                }
            }
        }

        return result;
    }

    private boolean valid(String s) {
        if (s.length() > 1 && s.charAt(0) == '0') {
            return false;
        }

        try {
            int val = Integer.parseInt(s);
            return val >= 0 && val <= 255;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.restoreIpAddresses("25525511135"));
        System.out.println(solution.restoreIpAddresses("0000"));
        System.out.println(solution.restoreIpAddresses("1111"));
        System.out.println(solution.restoreIpAddresses("010010"));
        System.out.println(solution.restoreIpAddresses("10203040"));
    }
}
