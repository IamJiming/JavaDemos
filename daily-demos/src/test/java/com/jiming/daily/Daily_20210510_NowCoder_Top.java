package com.jiming.daily;

import com.alibaba.fastjson.JSON;
import com.jiming.daily.commons.ListNode;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 牛客网TOP算法练习
 *
 * @author Mr.tjm
 * @date 2021-5-10 09:25
 */
public class Daily_20210510_NowCoder_Top {
    /**
     * NC78：反转链表：
     *
     * 输入一个链表，反转链表后，输出新链表的表头。
     */
    @Test
    void test_NC78() {
        ListNode node = this.createListNode(5);
        System.out.println("node："+ JSON.toJSONString(node));

        // 反转链表
        ListNode reverseNode = this.ReverseList(node);
        System.out.println("reverseNode："+ JSON.toJSONString(reverseNode));

    }

    /**
     * 反转 - 单向链表（遍历法）
     *
     * 思路：
     *      遍历法就是在链表遍历的过程中，将指针顺序置换
     */
    public ListNode ReverseList(ListNode head) {
        // 准备两个空结点：pre用来保存先前结点，next用来做临时变量
        ListNode pre = null;
        ListNode next = null;

        while (head != null){
            next = head.next;   // 2节点赋值给next临时变量
            head.next = pre;    // 1节点的nex头指针赋值null
            pre = head;         // 1节点（单独的）赋值给pre
            head = next;        // 临时变量赋值给head
            next = null;        // 这一步可有可无，主要是方便理解
        }
        return pre;
    }

    /**
     * NC119：最小的K个数：
     *
     * 给定一个数组，找出其中最小的K个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
     * 如果K>数组的长度，那么返回一个空的数组
     */
    @Test
    void test_NC119_1() {
        int[] arry = {4,5,1,6,2,7,3,8};
        int k = 4;

        int len = arry.length;
        if (k >= len){
            System.out.println("arry："+ JSON.toJSONString(arry));
            return;
        }
        int[] retArry = new int[k];
        Arrays.sort(arry);
        for (int i = 0; i < k; i++) {
            retArry[i] = arry[i];
        }
        System.out.println("arry："+ JSON.toJSONString(arry));
    }

    /**
     * 插入排序，只排前K个数，输出
     */
    void test_NC119_2() {

    }

    /**
     * NC61：两数之和
     *
     * 给出一个整数数组，请在数组中找出两个加起来等于目标值的数
     * 注意：输出的是下标，下标从1开始
     */
    @Test
    void test_NC61() {
        int[] array = {20, 70, 110, 150};
        int sum = 90;
        int[] retArray = this.twoSum(array,sum);
        System.out.println("retArray："+ JSON.toJSONString(retArray));
    }

    public int[] twoSum (int[] numbers, int target) {
        int[] ret = new int[2];
        Map<Integer, Integer> tempMap = new HashMap();
        for (int i = 0; i < numbers.length; i++) {
            int tempKey = target - numbers[i];
            if (tempMap.containsKey(tempKey)) {
                ret[0] = tempMap.get(tempKey) + 1;
                ret[1] = i + 1;
                break;
            } else {
                tempMap.put(numbers[i],i);
            }
        }
        return ret;
    }

    /**
     * NC41：最长不重复子串
     *
     * 给定一个数组arr，返回arr的最长无的重复子串的长度(无重复指的是所有数字都不相同)。
     */
    @Test
    void test_NC41() {
        int[] array = {2,2,3,4,3};

        int max = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (list.contains(array[i])) {
                int num = list.indexOf(array[i]);
                while(num-- >= 0){
                    list.remove(0);
                }
            }
            list.add(array[i]);
            max = Math.max(max, list.size());
        }
        System.out.println("max："+ JSON.toJSONString(max));
    }

    /**
     * NC52：括号序列
     *
     * 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列，
     * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法
     */
    @Test
    void test_NC52() {
        /**
         * 如果是第一种，直接把()，[]和{}替换成""，最后字符串为"",则为true
         * 如果是第二种， StringBuilder.reverse()，然后对比就好
         * 如果同时满足三种情况，最好使用栈桢的方式，每次入栈都和栈顶元素匹配一下，最后栈为空，即true
         */
        String str1 = "()[]{}";
        String str2 = "{[()]}";
        String str3 = "{([]())}";
        Boolean flag = this.isValid(str3);
        System.out.println("flag："+ JSON.toJSONString(flag));
    }

    public boolean isValid (String str) {
        if (str.length() == 0 || str.length()%2 != 0) {
            return false;
        }
        // 栈桢
        Stack<Character> stack = new Stack();
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            if(ch == '{') {
                stack.push('}');
            } else if (ch == '['){
                stack.push(']');
            } else if (ch == '('){
                stack.push(')');
            } else if (ch == stack.peek()){
                stack.pop();
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * NC65：斐波那切数列
     *
     * 1,1,2,3,5,8,13,21...
     */
    @Test
    void test_NC65() {
        Vector ver = new Vector();
        ver.add(1);
        ver.add(1);
        for (int i = 2; i < 10; i++) {
            int num = (int) ver.get(i-1) + (int) ver.get(i-2);
            ver.add(num);
        }
        System.out.println("ver："+ JSON.toJSONString(ver));
    }

    /**
     * NC17：最长回文子串
     *
     * 对于一个字符串，请设计一个高效算法，计算其中最长回文子串的长度。
     */
    @Test
    void test_NC17_1() {
        String str = "abc1234321ab";
        int len = str.length();
        if (len < 2) {
            System.out.println("max："+ 1);
            return;
        }
        int max = 0;
        for (int i = 0; i < len; i++) {
            int temp = 0;
            int j = 1;
            while(i-j >= 0 && i+j < len && str.charAt(i-j) == str.charAt(i+j)){
                temp++;
                j ++;
            }
            max = Math.max(max, temp);
        }
        if (max != 0) {
            max = 2*max + 1;
        }
        System.out.println("max："+ JSON.toJSONString(max));
    }

    /**
     * 暴力解法：冒泡一下，遍历整个字符串，找出最长回文字符串
     */
    @Test
    void test_NC17_2() {
        String str = "abc1234321ab";
        int len = str.length();
        int max = 0;
        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j < len; j++) {
                String tempStr = str.substring(i,j);
                if (this.isPalindrome(tempStr)){
                    max = Math.max(max, tempStr.length());
                }
            }
        }
        System.out.println("max："+ JSON.toJSONString(max));
    }

    //判断子串是不是回文子串
    public boolean isPalindrome(String s){
        String revStr = new StringBuilder(s).reverse().toString();
        if (!s.equals(revStr)){
            return false;
        }
        return true;
    }

    /**
     * 数组中出现超过一半的数字
     *
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     */
    @Test
    void test_NC73_1() {
        int[] arr = {1,2,3,2,2,2,5,4,2};
        int len = arr.length;
        Map<Integer,Integer> map = new HashMap(6);
        for (int i = 0; i < len; i++) {
            if (map.containsKey(arr[i]) && map.get(arr[i]) > (len/2-1)) {
                System.out.println("max："+ JSON.toJSONString(arr[i]));
                return ;
            }else if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i]) + 1);
            }else {
                map.put(arr[i],1);
            }
        }
    }

    /**
     * 链表中环的入口节点
     *
     * 对于一个给定的链表，返回环的入口节点，如果没有环，返回null
     *
     * 思路：快慢指针法
     */
    @Test
    void test_NC3() {
        ListNode node = this.createListNode(10);

        ListNode fast = node;
        ListNode slow = node;

        while(slow != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            // 找到相遇点,也是有环的证据
            if(fast == slow){
                // 重新定义一个slow指针，当二者相遇，就是环的起点
                ListNode slow2 = node;
                while(slow != slow2){
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                System.out.println("环节点："+ JSON.toJSONString(slow));
                return;
            }
        }
        System.out.println("环节点："+ JSON.toJSONString("无"));
        return;
    }

    /**
     * 矩阵的最小路径和
     *
     * 给定一个 n * m 的矩阵 a，从左上角开始每次只能向右或者向下走，
     * 最后到达右下角的位置，路径上所有的数字累加起来就是路径和，
     * 输出所有的路径中最小的路径和
     *
     * 思路：
     */
    @Test
    void test_NC59() {
        int[][] matrix = {{1,3,5,9},{8,1,3,4},{5,0,6,1},{8,8,4,0}};

        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = matrix[0][0];
        System.out.println("dp_0："+ JSON.toJSONString(dp));

        //第一列只能从上面走下来
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }
        System.out.println("dp_1："+ JSON.toJSONString(dp));

        //第一行只能从左边走过来
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + matrix[0][i];
        }
        System.out.println("dp_2："+ JSON.toJSONString(dp));

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //递推公式，取从上面走下来和从左边走过来的最小值+当前坐标的值
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j];
            }
        }
        System.out.println("dp_3："+ JSON.toJSONString(dp));

        // dp_1：[[1,0,0,0],[9,0,0,0],[14,0,0,0],[22,0,0,0]]
        // dp_2：[[1,4,9,18],[9,0,0,0],[14,0,0,0],[22,0,0,0]]
        // dp_3：[[1,4,9,18],[9,5,8,12],[14,5,11,12],[22,13,15,12]]
        // 最后的dp，可以求走到任意位置的最小值
        System.out.println("max："+ JSON.toJSONString(dp[m - 1][n - 1]));
    }

    /**
     * 链表中倒数第K个节点
     *
     * 思路：双指针，一个先走K步，然后同时走，先指针为null时，返回后指针data
     */
    @Test
    void test_NC69() {
        ListNode pHead = this.createListNode(10);
        int k = 2;
        ListNode first = pHead;
        ListNode second = pHead;

        //第一个指针先走k步
        while(k-- > 0){
            if (first == null){
                System.out.println("data："+ JSON.toJSONString(null));
                return;
            }
            first = first.next;
        }

        //然后两个指针在同时前进
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        System.out.println("data："+ JSON.toJSONString(second));
        return;
    }

    /**
     * 合并有序链表
     *
     * 思路：
     */
    @Test
    void test_NC33() {
        ListNode list1 = this.createListNode(5,3);
        ListNode list2 = this.createListNode(0,3);
        ListNode list = this.mergeTwoLists(list1, list2);
        System.out.println("data："+ JSON.toJSONString(list));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //下面4行是空判断
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        //创建一个新链表，l1和l2对比，小的放进来
        ListNode dummy  = new ListNode(0);
        //这是一个临时变量
        ListNode curr = dummy ;
        while(l1 != null && l2 != null){
            if ((int)l1.val <= (int)l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            // 指针后移
            curr = curr.next;
        }
        //然后把那个不为空的链表挂到新的链表中
        curr.next = (l1 == null ? l2 : l1);
        return  dummy.next;
    }


    /** —————————— private method —————————— */

    /**
     * 创建 - 测试用的 - 单向链表
     * temp - 初始值，num - 长度
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
        String.format("","");
        return relNode;
    }
}
