package byx.leetcode.problem.比较版本号;

/**
 * https://leetcode-cn.com/problems/compare-version-numbers/
 */
public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int i = 0, j = 0;
        while (i < v1.length || j < v2.length) {
            int a = (i < v1.length) ? Integer.parseInt(v1[i]) : 0;
            int b = (j < v2.length) ? Integer.parseInt(v2[j]) : 0;
            if (a < b) {
                return -1;
            } else if (a > b) {
                return 1;
            } else {
                i++;
                j++;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.compareVersion("1.01", "1.001"));
        System.out.println(solution.compareVersion("1.0", "1.0.0"));
        System.out.println(solution.compareVersion("0.1", "1.1"));
        System.out.println(solution.compareVersion("1.0.1", "1"));
        System.out.println(solution.compareVersion("7.5.2.4", "7.5.3"));
    }
}
