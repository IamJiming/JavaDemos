package com.jiming.daily.commons;

/**
 * 链表
 */
@SuppressWarnings("all")
public class  ListNode<E> {

    public E val;                       //结点值，泛型

    public ListNode<E> next = null;     //下一结点

    public ListNode(E x){ this.val = x; }   //构造函数

    /** —————————— private method —————————— */
    /**
     * 创建 - 测试用的 - 单向链表
     *
     * temp - 初始值，num - 长度
     *
     * 思路：
     *      前一个节点的next指向后一个节点的data，
     *      nextNode存储最后一个节点用，一直往后移。
     */
    public static ListNode createListNode(int num){
        ListNode relNode = new ListNode(0); //创建首结点
        ListNode nextNode;                      //创建首结点的下一个结点,指向首结点
        nextNode = relNode;
        //创建链表
        for(int i = 1;i < num;i++){
            ListNode newnode = new ListNode(i); //创建新的结点
            nextNode.next = newnode;            //把新结点连起来
            nextNode = nextNode.next;           //把结点往后移
        }
        return relNode;
    }

    public static ListNode createListNode(int temp, int num){
        ListNode relNode = new ListNode(temp); //创建首结点
        ListNode nextNode;                      //创建首结点的下一个结点,指向首结点
        nextNode = relNode;
        //创建链表
        for(int i = 1;i < num;i++){
            ListNode newnode = new ListNode(i+temp); //创建新的结点
            nextNode.next = newnode;            //把新结点连起来
            nextNode = nextNode.next;           //把结点往后移
        }
        return relNode;
    }
}
