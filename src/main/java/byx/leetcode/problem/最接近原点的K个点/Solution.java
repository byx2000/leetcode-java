package byx.leetcode.problem.最接近原点的K个点;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/k-closest-points-to-origin/
 */
public class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> distance(p2) - distance(p1));
        for (int[] p : points) {
            pq.add(p);
            if (pq.size() > k) {
                pq.remove();
            }
        }

        int[][] result = new int[pq.size()][2];
        int index = 0;
        while (!pq.isEmpty()) {
            result[index] = pq.remove();
            index++;
        }

        return result;
    }

    private int distance(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.kClosest(new int[][]{{1, 3}, {-2, 2}}, 1)));
        System.out.println(Arrays.deepToString(solution.kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2)));
    }
}
