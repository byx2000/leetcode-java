package byx.leetcode.problem.二叉搜索树的后序遍历序列;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 */
public class Solution {
    public boolean verifyPostorder(int[] postorder) {
        int[] inorder = Arrays.copyOf(postorder, postorder.length);
        Arrays.sort(inorder);
        return check(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private boolean check(int[] inorder, int[] postorder, int b1, int e1, int b2, int e2) {
        if (b1 > e1) {
            return true;
        }

        if (b1 == e1) {
            return inorder[b1] == postorder[b2];
        }

        int root = postorder[e2];
        int index = find(inorder, root, b1, e1);
        if (index == -1) {
            return false;
        }

        int cLeft = index - b1;
        int cRight = e1 - index;

        return check(inorder, postorder, b1, index - 1, b2, b2 + cLeft - 1)
                && check(inorder, postorder, index + 1, e1, e2 - cRight, e2 - 1);
    }

    private int find(int[] nums, int val, int left, int right) {
        for (int i = left; i <= right; ++i) {
            if (nums[i] == val) {
                return i;
            }
        }
        return -1;
    }
}
