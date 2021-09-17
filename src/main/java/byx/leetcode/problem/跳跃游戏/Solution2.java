package byx.leetcode.problem.跳跃游戏;

/**
 * https://leetcode-cn.com/problems/jump-game/
 */
public class Solution2 {
    public boolean canJump(int[] nums) {
        int cur = 0;
        for (int i = 0; i < nums.length; ++i) {
            cur = Math.max(cur, nums[i]);
            if (cur == 0) {
                return i == nums.length - 1;
            }
            cur--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(solution.canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(solution.canJump(new int[]{2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6}));

    }
}
