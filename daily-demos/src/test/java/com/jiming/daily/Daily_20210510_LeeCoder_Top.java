package com.jiming.daily;

import com.alibaba.fastjson.JSON;
import com.jiming.daily.commons.ListNode;
import com.jiming.daily.commons.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 牛客网TOP算法练习
 *
 * @author Mr.tjm
 * @date 2021-5-10 09:25
 */
public class Daily_20210510_LeeCoder_Top {
    /**
     * 114：二叉树展开为链表
     *
     * 将二叉树展开为单链表之后，单链表中的节点顺序即为二叉树的前序遍历访问各节点的顺序。
     * 因此，可以对二叉树进行前序遍历，获得各节点被访问到的顺序。
     * 由于将二叉树展开为链表之后会破坏二叉树的结构，因此在前序遍历结束之后更新每个节点的左右子节点的信息，将二叉树展开为单链表。
     */
    @Test
    void test_114() {
        TreeNode root = new TreeNode(null);
        // 递归法
        this.flatten(root);
    }
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        preorderTraversal(root, list);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    public void preorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }

    /**
     * 129：求根到叶子节点数字之和（这道题的背下来了）
     *
     * 二叉树的每条从根节点到叶子节点的路径都代表一个数字。
     * 其实，每个节点都对应一个数字，等于其父节点对应的数字乘以 1010 再加上该节点的值（这里假设根节点的父节点对应的数字是 00）。
     * 只要计算出每个叶子节点对应的数字，然后计算所有叶子节点对应的数字之和，即可得到结果。
     * 可以通过深度优先搜索和广度优先搜索实现。
     *
     */
    @Test
    void test_129() {
        // 深度优先搜索
        TreeNode<Integer> root = new TreeNode(null);
        this.dfs(root, 0);
    }

    public int dfs(TreeNode<Integer> root, int prevSum) {
        if (root == null) {
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }

}
