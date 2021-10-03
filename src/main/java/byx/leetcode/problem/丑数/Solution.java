package byx.leetcode.problem.丑数;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/chou-shu-lcof/
 */
public class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();

        pq.add(1L);
        set.add(1L);

        while (n > 1) {
            long top = pq.remove();
            if (!set.contains(2 * top)) {
                pq.add(2 * top);
                set.add(2 * top);
            }
            if (!set.contains(3 * top)) {
                pq.add(3 * top);
                set.add(3 * top);
            }
            if (!set.contains(5 * top)) {
                pq.add(5 * top);
                set.add(5 * top);
            }

            n--;
        }

        return pq.peek().intValue();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nthUglyNumber(10));
        System.out.println(solution.nthUglyNumber(1407));
    }
}
