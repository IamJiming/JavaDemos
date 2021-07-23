package com.jiming.daily;

import com.alibaba.fastjson.JSON;
import com.jiming.daily.commons.ListNode;
import com.jiming.daily.commons.TreeNode;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 剑指offer算法练习
 *
 * @author Mr.tjm
 * @date 2021-5-11 09:25
 */
public class Daily_20210511_ToOffer {
    /**
     * 单利模式：雷中直接静态new出来，不管用没用到
     */
    private static class SingletonHodler {
        private static Daily_20210511_ToOffer ourInstance = new Daily_20210511_ToOffer();
    }

    /**
     * 4.替换字符串中的空格
     *
     * 将一个字符串中的空格替换成“%20”。
     * 例如：当字符串为 We Are Happy.则经过替换之后的字符串为 We%20Are%20Happy
     */
    @Test
    void test_4() {
        String str1 = "We Are Happy";
        String retStr1 = str1.replaceAll(" ", "%20");
        System.out.println("data1："+ JSON.toJSONString(retStr1));
        // 练习一下正则
        // \s 是匹配所有空白符,包括换行,\S 非空白符,不包括换行
        String str2 = "We Are Happy";
        String retStr2 = str2.replaceAll("\\s", "%20");
        System.out.println("data2："+ JSON.toJSONString(retStr2));
    }

    /**
     * 5.从尾到头打印链表
     *
     * 思路：
     *      借助栈实现；递归也可以，但是我不考虑，因为时间，空间复杂度较大，很容易溢出。
     *
     *  注意：
     *      栈判断空要用stack.empty()方法，因为stack.peek() == null 会抛出异常
     */
    @Test
    void test_5() {
        ListNode pHead = this.createListNode(3);
        // 链表入栈
        Stack<ListNode> stack = new Stack<>();
        while (pHead != null) {
            stack.push(pHead);  // 这里改成：pHead.val也不错，list可以直接add了
            pHead = pHead.next;
        }
        // 遍历栈
        List list = new ArrayList();
        while (!stack.empty()){
            list.add(stack.pop().val);
        }
        System.out.println("data："+ JSON.toJSONString(list));
    }

    /**
     * 7.用两个栈实现队列
     *
     * 用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作。 队列中的 元素为 int 类型。
     *
     * 思路：
     *      stack1和stack2倒下手就可以了，但是要留意stack2为null时候才可以倒手，否则直接取值
     */
    @Test
    void test_7() {
    }

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    // 入栈
    public void push(int node) {
        stack1.push(node);      // a,b,c
    }
    // 出栈
    public Integer pop() {
        // 只有stack2等于null时，才倒一下，否则就直接从stack2顶取值
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    /**
     * 9.1 输出斐波那契数列的第 n 项
     *
     * 现在要求输入一个整数 n，请你输出斐波那契数列的第 n 项。n<=39
     *
     * 注意：
     *      书上写的思路是不使用list存储，这样把list.get(i-1) 和 list.get(i-2) 两个值存起来就好了
     */
    @Test
    void test_9_1() {
        int num = 5;
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(1);
        if (num <= 0) {
            return;
        }
        if(num <= 2){
            System.out.println("data："+ JSON.toJSONString(list.get(num - 1)));
            return;
        }
        for (int i = 2; i < num; i++) {
            list.add(list.get(i-1) + list.get(i-2));
        }
        System.out.println("data："+ JSON.toJSONString(list.get(num - 1)));
    }
    // 青蛙跳台阶(1 或 2 级)
    // 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。求该青蛙跳上一 个 n 级的台阶总共有多少种跳法。
    @Test
    void test_9_2() {
        int n = 3;
        if(n < 3) {
            System.out.println("num："+ JSON.toJSONString(n));
            return;
        }
        int num = 0;
        int one = 1;
        int two = 2;
        for (int i = 3; i <= n; i++) {
            num = one + two;
            one = two;
            two = num;
        }
        System.out.println("num："+ JSON.toJSONString(num));
    }

    /**
     * 二进制中 1 的个数
     *
     * a&(a-1)的结果会将 a 最右边的 1 变为 0，直到 a = 0，
     * 还可以先将 a&1 != 0，然后右移 1 位，但不能计算负数的值，
     */
    @Test
    void test_10() {
        int n = 123456;
        int count = 0;
        while (n != 0) {
            System.out.println("n："+ JSON.toJSONString(n));
            count++;
            n = (n-1) & n;
        }
        System.out.println("num："+ JSON.toJSONString(count));
        // 我的想法，转成二级制遍历计算
        String str = Integer.toBinaryString(123456);
        System.out.println("str："+ JSON.toJSONString(str));
        String str1 = str.replaceAll("0", "");
        System.out.println("num1："+ JSON.toJSONString(str1.length()));
    }

    /**
     * 数值的整数次方
     *
     * 给定一个 double 类型的浮点数 base 和 int 类型的整数 exponent。
     * 求 base 的 exponent 次方。不得使用库函数，不需要考虑大数问题
     */
    @Test
    void test_11() {
        Double base = 3.4567;
        int exponent = 5;
        if("0".equals(String.valueOf(base))){
            System.out.println("num："+ JSON.toJSONString(0));
            return;
        }
        if (exponent == 0){
            System.out.println("num："+ JSON.toJSONString(1.0));
            return;
        }
        Double d = this.mutiply(base, exponent);
        System.out.println("num："+ JSON.toJSONString(d));
    }

    public double mutiply(double base, int e) {
        Double sum = 1D;
        for (int i = 0; i < e; i++) {
            sum = sum * base;
        }
        return sum;
    }

    /**
     * 求 1 到最大的 n 位数
     *
     * 输入数字 n，按顺序打印从 1 到最大的 n 位数十进制数，比如：输入 3，打印出 1 到 999.
     */
    @Test
    void test_12() {
        int n = 2;
        String str = "";
        for (int i = 0; i < n; i++) {
            str += "9";
        }
        int len = Integer.valueOf(str);
        int[] arr = new int[len];
        int num = 1;
        while (String.valueOf(num).length() <= n){
            arr[num-1] = num;
            num ++;
        }
        System.out.println("arr："+ JSON.toJSONString(arr));
    }

    /**
     * O(1)时间删除链表节点
     * 给定单向链表的头指针和一个节点指针，在 O(1)时间复杂度内删除该节点
     *
     * 思路：
     *      将要删除节点的下一个节点的值赋给要删除的节点，然后指向下下一个节点
     */
    @Test
    void test_13() {
        ListNode head = null;
        ListNode deListNode = null;
    }

    public ListNode deleteNode(ListNode head, ListNode deListNode) {
        if (deListNode == null || head == null){
            return null;
        }
        if (head == deListNode) {
            return null;
        } else {
            // 若删除节点是末尾节点，往后移一个（这里貌似不满足时间复杂度O(1)了，哎）
            if (deListNode.next == null) {
                ListNode pointListNode = head;
                while (pointListNode.next.next != null) {
                    pointListNode = pointListNode.next;
                }
                pointListNode.next = null;
            } else {
                //这里是核心思想
                deListNode.val = deListNode.next.val;
                deListNode.next = deListNode.next.next;
            }
        }
        return head;
    }

    /**
     * 将数组中的奇数放在偶数前
     *
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
     * 并保证奇 数和奇数，偶数和偶数之间的相对位置不变
     *
     * 思路：
     *      如果不考虑时间空间因素，我会新建一个数据，然后遍历arr两次，处理奇数偶数问题；
     *      考虑时间复杂度 O（n)，空间复杂度 O（1)的话，使用双指针。！！
     */
    @Test
    void test_14() {
        int[] array = {1,2,3,4,5,6,7,8,9};

        if (array == null || array.length == 0) {
            return;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            while (left < right && array[left] % 2 != 0) {
                left++;
            }
            while (left < right && array[right] % 2 == 0) {
                right--;
            }
            if (left < right) {
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;
            }
        }
        // arr：[1,9,3,7,5,6,4,8,2]
        System.out.println("arr："+ JSON.toJSONString(array));
    }
    // 考虑时间复杂度 O（n)，空间复杂度 O（1)的话
    // 我的想法：冒泡，把奇数一个一个冒到最前面
    @Test
    void test_14_1() {
        int[] array = {1,2,3,4,5,6,7,8,9};
        for (int i = 0; i < array.length; i++) {
            if (array[i]%2 != 0) {
                int j = i;
                while (j > 0 && array[j-1]%2 == 0) {
                    int tmp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = tmp;
                    j--;
                }
            }
        }
        // rr：[1,3,5,7,9,2,4,6,8]
        System.out.println("arr："+ JSON.toJSONString(array));
    }

    /**
     * 求链表中倒数第 K 个节点
     *
     * 思路：
     *      前后指针法，前面指针先走K步，然后一起走，前指针为null时候，返回后指针
     */
    @Test
    void test_15() {
        ListNode node = this.findKthToTail(null, 2);
    }

    public ListNode findKthToTail(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k; i++) {
            // 验证 K 超过链表深度的情况
            if (fast.next == null) {
                return null;
            }
            fast = fast.next;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 输出反转后的链表
     * 思路：
     *      定义两个指针，反向输出
     */
    @Test
    void test_16() {
        ListNode head = this.createListNode(5);
        ListNode pre = null;
        ListNode curr = head;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = pre;            // 这已不是核心，倒挂数据
            pre = curr;
            curr = temp;
        }
        System.out.println("ListNode："+ JSON.toJSONString(pre));
    }

    /**
     * 合并两个有序链表
     * 思路：
     *      新建一个1节点的链表pd，双指针对比node1和node2，小的放进去，
     *      如果一个node走到头了，把另一个剩下的都放进去
     */
    @Test
    void test_17() {
        ListNode node1 = this.createListNode(5,2);
        ListNode node2 = this.createListNode(1,3);

        ListNode node = new ListNode(0);
        ListNode pre = node;
        while(node1 != null && node2 != null){
            if ((int)node1.val < (int)node2.val) {
                pre.next = node1;
                node1 = node1.next;
            } else {
                pre.next = node2;
                node2 = node2.next;
            }
            pre = pre.next;
        }
        pre.next = (node1 == null ? node2 : node1);
        System.out.println("ListNode："+ JSON.toJSONString(node.next));
    }

    /**
     * 定义一个最小元素栈
     * 思路：
     *      stack2存放stack1中最小值，每次stack1 push，pop操作，stack2都对比一下
     */
    @Test
    void test_21() {

    }
    Stack<Integer> stack11 = new Stack<>();
    Stack<Integer> stack22 = new Stack<>();

    public void push1(int n){
        stack11.push(n);
        if (stack22.empty()){
            stack22.push(n);
        } else if (stack22.peek() > n) {
            stack22.pop();
            stack22.push(n);
        }
    }

    public void pop1(){
        if (!stack22.empty() && stack22.peek() == stack11.pop()){
            stack22.pop();
        }
    }

    public void peek1(){
        stack11.peek();
    }

    /**
     * 判断一个栈是否是另一个栈的弹出序列
     *
     * 题目不难，就是没太懂为什么不用for循环对比解决，所以不写了
     *
     * 答案是利用stack出栈原理，对比相等就pop，最后stack=null就是true
     */
    @Test
    void test_22() {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {5,4,3,2,1};
        Boolean flag = this.IsPopOrder(arr1, arr2);
        System.out.println("flag："+ JSON.toJSONString(flag));
    }

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null || popA == null) {
            return false;
        }
        return true;
    }

    /**
     * 层序遍历二叉树
     *
     * 思路：
     *      利用queue队列思想，一层层遍历，先左后右
     */
    @Test
    void test_23() {
        TreeNode<Integer> root = new TreeNode<>(0);
        List list = new ArrayList();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue != null){
            TreeNode tempNode = queue.poll();
            list.add(tempNode.val);
            if (tempNode.left != null){
                queue.offer(tempNode.left);
            }
            if (tempNode.right != null){
                queue.offer(tempNode.right);
            }
        }
        System.out.println("list："+ JSON.toJSONString(list));
    }

    /**
     * 打印字符串中所有字符的排列（没认真看）
     *
     * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
     * 例如输 入字符串 abc,则打印出由字符 a,b,c 所能排列出来的所有字符串 abc,acb,bac,bca,cab 和 cba。
     */
    @Test
    void test_28() {
        String str = "abc";
        List<String> res = new ArrayList<>();

        if (str == null || str.length() == 0) {
            System.out.println("list："+ JSON.toJSONString(res));
            return;
        }
        // 递归思想
        this.helper(res, 0, str.toCharArray());
        Collections.sort(res);
        System.out.println("list："+ JSON.toJSONString(res));
    }

    private void helper(List<String> res, int index, char[] s) {
        if (index == s.length - 1) {
            res.add(String.valueOf(s));
            return;
        }
        for (int i = index; i < s.length; i++) {
            if (i == index || s[index] != s[i]) {
                this.swap(s, index, i);
                this.helper(res, index + 1, s);
                this.swap(s, index, i);
            }
        }
    }

    public void swap(char[] c, int a,int b) {
        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;
    }

    /**
     * 数组中出现次数超过一半的数字
     *
     * 数组中有【一个数字】出现的次数超过数组长度的一半，请找出这个数字，如果不存在则输出 0。
     */
    @Test
    void test_29() {
        int[] nums = {1,2,2,2,4};
        Map<Integer, Integer> map = new HashMap();
        for (int index: nums) {
            if(map.containsKey(index)){
                int temp = map.get(index);
                if (temp >= (nums.length/2 - 1)) {
                    System.out.println("data："+ JSON.toJSONString(index));
                    return;
                }
                map.put(index,temp+1);
            } else {
                map.put(index, 1);
            }
        }
        System.out.println("data："+ JSON.toJSONString(0));
    }

    /**
     * 找出最小的 K 个数
     *
     * 输入 n 个整数，找出其中最小的 K 个数
     */
    @Test
    void test_30() {
        int[] input = {1,3,4,5,6,7,8,2};
        int num = 3;

        Arrays.sort(input);
        List list = new ArrayList();
        for (int i = 0; i < num; i++) {
            list.add(input[i]);
        }
        System.out.println("data："+ JSON.toJSONString(list));
    }

    /**
     * 连续子数组的最大和
     *
     * 输入一个整型数组，数组中有正数也有负数，数组中一个或连续的多 个整数组成一个子数组，求连续子数组的最大和
     *
     * 思路：若和小于 0，则将最大和置为当前值，否则计算最大和。
     */
    @Test
    void test_31() {
        int[] nums = {-1,2,-3,1,5};
        int sum = 0;
        int ret = nums[0];
        for (int temp : nums) {
            // 核心代码：sum + temp
            sum = Math.max(sum + temp, temp);
            ret = Math.max(sum, ret);
        }
        System.out.println("data："+ JSON.toJSONString(ret));
    }
    // 求：和最大时候的子序列
    // 思路：把每次最大值变化时候的下标保存下来
    @Test
    void test_31_1() {
        int[] nums = {-1,2,2,2,2,-3,1,5};

        // 默认升序，我们需要改成降序，所以需要重写compare方法
        TreeMap<Integer, String> treeMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 返回正数，是升序；返回负数，是降序
                return o2 - o1;
            }
        });

        int sum = 0;
        int ret = nums[0];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            // 核心代码：sum + temp
            sum = Math.max(sum + temp, temp);
            if (sum == temp){
                index = i-1;
            }
            // 每次ret变化，说明最大值发生了变化，都要记录下来
            if (sum > ret) {
                ret = sum;
                treeMap.put(ret, index+","+i);
            }
        }
        // 有下标了，再遍历数组取下值就好了，后面不写了
        // treeMap：{6:"3,4",2:"0,1"}
        System.out.println("treeMap："+ JSON.toJSONString(treeMap));
        // ret：6
        System.out.println("ret："+ JSON.toJSONString(ret));
    }

    /**
     * 把数组中的数排成一个最小（最大）的数
     * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印 能拼接出的所有数字中最小的一个
     *
     * 思路：
     *      升序排列，然后拼接成一个最小的值
     */
    @Test
    void test_33() {
        Integer[] nums = {5,3,4,2,0,1};

        Arrays.sort(nums, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println("nums："+ JSON.toJSONString(nums));
        StringBuilder sb = new StringBuilder();
        for (Integer index : nums) {
            sb.append(index);
        }
        System.out.println("最小字符串数："+ JSON.toJSONString(Integer.valueOf(sb.toString())));
    }

    /**
     * 求第 N 个丑数
     *
     * 求从小到大的第 N 个丑数。丑数是只包含因子 2、3 和 5 的数，习惯 上我们把 1 当做是第一个丑数。
     */

    /**
     * 第一个出现一次的字符
     *
     * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一 个只出现一次的字符,并返回它的位置
     *
     * 思路：利用 LinkedHashMap 保存字符和出现次数
     */
    @Test
    void test_34() {
        String str = "22222223333333144444445556789";
        if (StringUtils.isBlank(str)){
            System.out.println("结果："+ JSON.toJSONString("无"));
            return;
        }
        LinkedHashMap<Object, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            String temp = str.charAt(i)+"";
            if (map.containsKey(temp)){

            }
        }

        String hex = Integer.toHexString(13);
        System.out.println("结果4："+ JSON.toJSONString(hex));

        int numb = Integer.valueOf("d", 16);
        System.out.println("结果5："+ JSON.toJSONString(numb));
    }

    /**
     * 第一个出现一次的字符
     * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一 个只出现一次的字符,并返回它的位置
     */
    @Test
    void test_35() {
        String str1 = "1231245678";
        // 利用 LinkedHashMap 保存字符和出现次数,然后取第一个value==1的key
        // string.replaceAll()方法
        String str = new String(str1);
        while (str.length() > 0) {
            String temp = str.charAt(0)+"";
            int len = str.length();
            str = str.replaceAll(temp,"");
            if (len - str.length() == 1) {
                System.out.println("第一个出现的值是："+ JSON.toJSONString(temp));
                // 上面已经找到了，然后再获取位置
                int index = str1.indexOf(temp);
                System.out.println("它的位置是："+ JSON.toJSONString(index));
                return;
            }
        }
        System.out.println("第一个出现的值是："+ JSON.toJSONString("无"));
    }

    /**
     * 两个链表的第一个公共节点：输入两个链表，找出它们的第一个公共结点
     *
     * 思路：
     *      两个指针一起走，到头了就对调，继续走，直到相等
     */
    @Test
    void test_37() {
        ListNode pHead1 = ListNode.createListNode(5);
        ListNode pHead2 = ListNode.createListNode(5);
        ListNode retNode = this.FindFirstCommonNode(pHead1, pHead2);
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2){
            p1 = (p1 == null ? p2 : p1.next);
            p2 = (p2 == null ? p1 : p2.next);
        }
        return p1;
    }

    /**
     * 求某个数在数组中出现次数
     *
     * 思路：
     *      stream().count()
     * 注意：
     *      数组不能转成List<Integer>的集合！！！！！
     */
    @Test
    void test_38() {
        int[] nums = {1,2,3,4,5,6,6,6,6};
        List<Integer> list = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }

        Long num =  list.stream().filter(Integer -> Integer == 6).count();
        System.out.println("num："+ JSON.toJSONString(num));
    }

    /**
     * 利用二分查找+递归思想，进行寻找。当目标值与中间值相等时进行判断
     */
    @Test
    void test_38_2() {
        int[] arraySorted = {1,1,1,1,2};
        int num = this.getNumberOfK(arraySorted, 1);
        System.out.println("num："+ JSON.toJSONString(num));
    }

    public static int getNumberOfK(int[] arraySorted, int k) {
        if (arraySorted == null || arraySorted.length == 0) {
            return 0;
        }
        if (arraySorted.length == 1) {
            return arraySorted[0] == k ? 1 : 0;
        }
        int result = 0;
        int mid = arraySorted.length / 2;
        if (k < arraySorted[mid]) {
            result += getNumberOfK(Arrays.copyOfRange(arraySorted, 0, mid), k);
        } else if (k > arraySorted[mid]) {
            result += getNumberOfK(Arrays.copyOfRange(arraySorted, mid, arraySorted.length), k);
        } else {
            result += getCount(arraySorted, mid);
        }
        return result;
    }

    private static int getCount(int[] arraySorted, int mid) {
        int k = arraySorted[mid];
        int result = 0;
        for (int i = mid; i < arraySorted.length; i++) {
            if (arraySorted[i] == k) { result++;
            } else {
                break;
            }
        }
        for (int i = mid - 1; i >= 0; i--) {
            if (arraySorted[i] == k) {
                result++;
            } else {
                break;
            }
        }
        return result;
    }

    /**
     * 二叉树的深度
     * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点 （含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
     *
     * 思路：利用递归遍历分别返回左右子树深度
     */
    @Test
    void test_39() {
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = this.maxDepth(root.left);
        int right = this.maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    /**
     * 判断某二叉树是否是平衡二叉树
     *
     * 思路：平衡二叉树的条件：左子树是平衡二叉树，右子树是平衡二叉树，左右子 树高度不超过 1
     */
    @Test
    void test_39_2() {
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        boolean condition = Math.abs(this.maxDepth(root.left) - this.maxDepth(root.right)) <= 1;
        return condition && this.isBalanced(root.left) && this.isBalanced(root.right);
    }

    /**
     * 找出只出现一次的数字
     * 一个整型数组里除了【2】个数字之外，其他的数字都出现了两次。请写 程序找出这两个只出现一次的数字。
     *
     * 思路：两个相同的数异或后为 0，一个数和 0 异或还是它本身，将所有数异或后即得到 A、B 异或的结果，
     * 然后求得 1 在该数最右边出现的 index，然后判断每个数 右移 index 后是不是 1。
     */
    @Test
    void test_40() {
//        int[] array = {1,2,3,4,5,6,7,8,9,64,1,2,3,4,5,6,7,8,9,192};
        int[] array = {2,4,6,8,12,1,1,2,4,12};
//        this.FindNumsAppearOnce_1(array, new int[1], new int[1]);
        this.FindNumsAppearOnce(array, new int[1], new int[1]);

//        System.out.println("7^9："+ JSON.toJSONString(7^9));
    }

    public void FindNumsAppearOnce(int [] array, int num1[] , int num2[]) {
        if (array == null | array.length == 0){
            return;
        }
        num1[0] = 0;
        num2[0] = 0;
        int number = array[0];
        // 因为有2个不同的数字，所以最终异或的结果，就是那两个数的异或结果
        for (int i = 1; i < array.length; i++) {
            number ^= array[i];
            System.out.println("number："+ JSON.toJSONString(number));
        }
        // 异或后的数 1 出现在第几位,因为前面相同，所以异或后都是0，就没必要考虑了
        // 必须获得第一次出现1的位置，因为这个位置是目标数首次不同的地方，才能区分出不同的组
        int index = 0;
        while ((number & 1) == 0) {
            number = number >> 1;
            index++;
        }
        for (int i = 0; i < array.length; i++) {
            // 目的是把2个目标数分在不同的组内，分别异或，最后留下唯一的数一定是不重复的那个
            // 原理：和只有一个数字出现一次的方法一样
            boolean isBit = ((array[i] >> index) & 1) == 0;
            if (isBit) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
        System.out.println("num1[0]："+ JSON.toJSONString(num1[0]));
        System.out.println("num2[0]："+ JSON.toJSONString(num2[0]));
    }

    public void FindNumsAppearOnce_1(int [] array, int num1[] , int num2[]) {
        if (array == null | array.length == 0){
            return;
        }
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])){
                map.remove(array[i]);
            }else {
                map.put(array[i], true);
            }
        }
        for (Integer temp : map.keySet()){
            if ( num1[0] == 0){
                num1[0] = temp;
            } else {
                num2[0] = temp;
            }
        }
        System.out.println("num1[0]："+ JSON.toJSONString(num1[0]));
        System.out.println("num2[0]："+ JSON.toJSONString(num2[0]));
    }

    /**
     * 如果改成：一个整型数组里除了【1】个数字之外......呢？？
     * 思路：如果是一个，那总重异或的结果就是它本身
     */
    @Test
    void test_40_1() {
        int[] array = {1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,8,9};
        this.FindNumsAppearOnce_2(array , new int[1]);
    }
    public void FindNumsAppearOnce_2(int [] array, int num1[]) {
        if (array == null | array.length == 0){
            return;
        }
        num1[0] = 0;
        int number = array[0];
        for (int i = 1; i < array.length; i++) {
            number ^= array[i];
        }
        num1[0] = number;
        System.out.println("num1[0]："+ JSON.toJSONString(num1[0]));
    }

    /**
     * 整数序列的查找
     * 1、输出和为 S 的连续整数序列
     * 输出所有和为 S 的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
     *
     * 思路：定义两个指针，分别递增，寻找和为 s 的序列。
     */
    @Test
    void test_41_1() {
        ArrayList<ArrayList<Integer>> list = this.FindContinuousSequence(8);
        for (ArrayList<Integer> tempList : list) {
            System.out.println("list："+ JSON.toJSONString(tempList));
        }
    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (sum < 3) {
            return arrayList;
        }
        int small = 1;
        int big = 2;
        // 不存在2个大于sum一半的数相加等于sum，所以small必须小于(sum + 1) / 2
        while (small < (sum + 1) / 2) {
            int s = 0;
            for (int i = small; i <= big; i++) {
                s += i;
            }
            // small 到 big 的和 s，如果等于sum，就打印输出之间的元素
            // 如果不相等，就网上继续进位，在进行一次循环
            if (s == sum) {
                for (int i = small; i <= big; i++) {
                    list.add(i);
                }
                arrayList.add(new ArrayList<>(list));
                list.clear();
                small++;
            } else {
                if (s > sum) {
                    small++;
                } else {
                    big++;
                }
            }
        }
        return arrayList;
    }

    /**
     * 求两个乘积最小的数
     * 输入一个递增排序的数组和一个数字 S，在数组中查找两个数，使得他们的和正好是 S，如果有多对数字的和等于 S，输出两个数的乘积最小的。
     *
     * 思路：定义两个指针，分别从前面和后面进行遍历。间隔越远乘积越小，所以是 最先出现的两个数乘积最小
     */
    @Test
    void test_41_2() {
    }
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if (array == null )
            return list;
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int s = array[left] + array[right];
            if (s == sum) {
                list.add(array[left]);
                list.add(array[right]);
                return list;
            }else {
                if (s > sum) {
                    right--;
                }else {
                    left++;
                }
            }
        }return list;
    }

    /**
     * 字符串中字符的移动
     * 反转字符串：输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变
     *
     * 思路：先将整个字符串翻转，然后将每个单词反转。
     */
    @Test
    void test_42_1() {

    }

    /**
     * 字符串中字符的移动
     * 将字符串循环左移 K 位：对于一个给定的字符序列 S，请你把其循环左移 K 位后的序列输出
     *
     * 思路：拼接或反转三次字符串
     */
    @Test
    void test_42_2() {
    }
    public String LeftRotateString(String str, int n) {
        if (str == null || str.length() == 0)
            return str;
        String s1 = reverse(str.substring(0,n));
        String s2 = reverse(str.substring(n, str.length()));
        return reverse(s2)+reverse(s1);
    }
    public String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0 ; i--) {
            sb.append(str.charAt(i));
        }
        return String.valueOf(sb);
    }

    /**
     * 求 1 到 n 的和
     * 求 1+2+3+…+n，要求不能使用乘除法、for、while、if、else、 switch、case 等关键字及条件判断语句（A?B:C）。
     */
    @Test
    void test_46() {
    }
    public int Sum_Solution(int n) {
        int sum = n;
        boolean result = (n > 0) && ((sum += Sum_Solution(n-1)) > 0);
        return sum;
    }

    /**
     * 不用加减乘除做加法
     * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四 则运算符号。
     * 思路：利用位运算
     */
    @Test
    void test_47() {
        this.Add(1000,2000);
    }
    public int Add(int num1,int num2) {
        while (num2 != 0) {
            // 计算个位
            int temp = num1 ^ num2;
            // 计算进位（1+1）,num1 & num2 的结果，就是num1 ^ num2需要进位的点
            num2 = (num1 & num2) << 1;
            num1 = temp;
        }
        return num1;
    }

    /**
     * 找出重复的数
     *
     * 题目描述：在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内，找出数 组中任意一个重复的数字
     */
    @Test
    void test_51() {
       int[] array = {1,2,3,4,5,6,7,8,5};
        int ret = this.findDuplicate(array);
        System.out.println("ret："+ JSON.toJSONString(ret));
    }

    public int findDuplicate(int[] numbers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer temp : numbers) {
            if (!map.containsKey(temp)) {
                return temp;
            } else {
                map.put(temp, temp);
            }
        }
        return -1;
    }

    /**
     * 字符流中第一个不重复的字符
     * 题目描述：请实现一个函数用来找出字符流中第一个只出现一次的字符。
     *
     * 思路：借助辅助空间进行判断，如字符数组。
     */
    @Test
    void test_55() {
    }


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
    private ListNode createListNode(int num){
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

    private ListNode createListNode(int temp, int num){
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
