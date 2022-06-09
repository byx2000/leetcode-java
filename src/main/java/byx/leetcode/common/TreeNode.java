package byx.leetcode.common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树节点
 */
public class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode() {
        this(0, null, null);
    }

    public TreeNode(int val) {
        this(val, null, null);
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 判断两棵二叉树是否相等
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TreeNode t) {
            return equals(this, t);
        }
        return false;
    }

    private static boolean equals(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) {
            return t1 == null && t2 == null;
        }

        if (t1.val != t2.val) {
            return false;
        }

        return equals(t1.left, t2.left) && equals(t1.right, t2.right);
    }

    /**
     * 将二叉树转换为字符串（层序遍历序列），方便输出调试
     */
    @Override
    public String toString() {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this);
        List<String> values = new ArrayList<>();

        // 层序遍历
        while (!queue.isEmpty()) {
            TreeNode cur = queue.remove();
            if (cur == null) {
                values.add("null");
            } else {
                values.add(String.valueOf(cur.val));
                queue.add(cur.left);
                queue.add(cur.right);
            }
        }

        // 去掉末尾的null
        while (!values.isEmpty() && "null".equals(values.get(values.size() - 1))) {
            values.remove(values.size() - 1);
        }

        return "[" + String.join(", ", values) + "]";
    }

    /**
     * 从层序遍历序列构建二叉树
     */
    public static TreeNode build(Integer... nums) {
        if (nums.length == 0) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(nums[0]);
        queue.add(root);
        int index = 1;

        while (!queue.isEmpty()) {
            TreeNode cur = queue.remove();
            if (index == nums.length) break;
            if (nums[index] != null) {
                cur.left = new TreeNode(nums[index]);
                queue.add(cur.left);
            }
            index++;
            if (index == nums.length) break;
            if (nums[index] != null) {
                cur.right = new TreeNode(nums[index]);
                queue.add(cur.right);
            }
            index++;
        }

        return root;
    }
}
