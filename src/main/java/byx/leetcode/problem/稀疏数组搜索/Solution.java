package byx.leetcode.problem.稀疏数组搜索;

/**
 * https://leetcode-cn.com/problems/sparse-array-search-lcci/
 */
public class Solution {
    public int findString(String[] words, String s) {
        int left = 0, right = words.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if ("".equals(words[mid])) {
                int t = mid;
                while (t < right && "".equals(words[t])) {
                    t++;
                }
                if (t == right) {
                    right = mid - 1;
                    continue;
                } else {
                    mid = t;
                }
            }

            int cmp = words[mid].compareTo(s);
            if (cmp < 0) {
                left = mid + 1;
            } else if (cmp > 0) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findString(new String[]{"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""}, "ta"));
        System.out.println(solution.findString(new String[]{"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""}, "ball"));
    }
}
