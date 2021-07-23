package com.jiming.daily.commons;

/**
 * 二叉树
 */
@SuppressWarnings("all")
public class TreeNode<E> {

    public E val;          //结点值，泛型

    public TreeNode left;  // 左分支

    public TreeNode right; // 右分支

    public TreeNode(E x) { val = x; }  // 构造函数
}
