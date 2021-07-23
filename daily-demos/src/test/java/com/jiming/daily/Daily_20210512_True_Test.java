package com.jiming.daily;

import com.alibaba.fastjson.JSON;
import com.jiming.daily.commons.ListNode;
import com.jiming.daily.commons.TreeNode;
import org.hibernate.secure.spi.IntegrationException;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 实战练习，别人的面试算法题
 *
 * @author Mr.tjm
 * @date 2021-5-12 09:25
 */
public class Daily_20210512_True_Test {

    /**
     * 给定一个有序数组和一个整数，返回这个整数出现的次数
     */
    @Test
    void test_0() {
        int[] arr = {1,2,3,4,5,5,5,6,7,8};
        int k = 5;
        // 字符串替换
        String str = JSON.toJSONString(arr);
        String temp = str.replaceAll(k+"", "");
        int num = str.length() - temp.length();
        System.out.println("num："+ JSON.toJSONString(num));

        // 如果是List，可以秀一下Stream().count()
        List<String> list = new ArrayList<>(Arrays.asList("abc", "a", "bc", "efg", "abcd","a", "jkl"));
        Long num1 = list.stream().filter(String -> String.equals("a")).count();
        System.out.println("num1："+ JSON.toJSONString(num1));

        // 面试官最喜欢的：二分查找，先找到位置，然后双指针前后遍历
        int[] nums = {1,1,2,2,3,4,4,5,5,6,7,7,7,8};
        int target = 7;
        int left = 0, right = nums.length - 1;
        int mid = 0;
        while(left <= right) {
            mid = (right + left) / 2;
            if (nums[mid] == target) {
                // 返回下标mid
                int up = mid + 1;
                int down = mid - 1;
                int retNum = 1;
                while (up < nums.length && nums[up] == target) {
                    retNum ++;
                    up++;
                }
                while (down >= 0 && nums[down] == target) {
                    retNum ++;
                    down--;
                }
                System.out.println("retNum："+ JSON.toJSONString(retNum));
                return;
            } else if (nums[mid] < target) {
                left = mid + 1;             // 注意，要 + 1
            } else if (nums[mid] > target) {
                right = mid - 1;            // 注意，要 - 1
            }
        }
        System.out.println("结果："+ JSON.toJSONString("没找到"));

    }

    // 二分查找的框架
/*
    int binarySearch(int[] nums, int target) {
        int left = 0, right = ...;

        while(...) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
            ...
            } else if (nums[mid] < target) {
                left = ...
            } else if (nums[mid] > target) {
                right = ...
            }
        }
        return ...;
    }
*/

    /**
     * 10进制的线程ID转换成16进制
     *
     * 10进制，16进制互转
     */
    @Test
    void test_1() {
        // 10 转 16
        String hex = Integer.toHexString(13);
        System.out.println("结果4："+ JSON.toJSONString(hex));

        // 16 转 10
        int numb = Integer.valueOf("d", 16);
        System.out.println("结果5："+ JSON.toJSONString(numb));
    }

    /**
     * Map的首字母转小写/大写
     */
    @Test
    void test_2() {
        // 参数： {"FirstKey":1,"SecondKey":2,"ThirdKey":{"FirstSubKey":3}}  
        Map<String, Object> map1 = new HashMap();
        map1.put("FirstSubKey",3);

        Map<String, Object> map = new HashMap();
        map.put("FirstKey",1);
        map.put("SecondKey",1);
        map.put("ThirdKey",map1);

        // 嵌套map的遍历
//        for (Map.Entry entry: map.entrySet()){
//            System.out.println("entry："+ JSON.toJSONString(entry));
//        }
//        Iterator key = map.keySet().iterator();
//        while (key.hasNext()){
//
//        }
        Map<String, Object> newMap = new HashMap();
        for (String str: map.keySet()){
            newMap.put(this.headToLowerCase(str), map.get(str));
        }
        System.out.println("newMap："+ JSON.toJSONString(newMap));

        // 我的JSON思路，利用String和正则，直接替换（推荐）
        String str = JSON.toJSONString(map);
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < sb.length(); i++) {
            String temp = sb.charAt(i)+"";
            if ("\"".equals(temp)) {
                String temp1 = sb.charAt(i+1)+"";
                if (temp1.matches("[A-Z]")) {
                    sb.replace(i+1,i+2,temp1.toLowerCase());
                }
            }
        }
        System.out.println("newSb："+ sb);

        Map<String,Object> retMap = JSON.parseObject(sb.toString());
        System.out.println("retMap："+ JSON.toJSONString(retMap));
    }

    // 首字母转小写
    public String headToLowerCase(String str){
        return Character.toLowerCase(str.charAt(0)) + str.substring(1);
    }

    /**
     * k个有序链表合并
     */
    @Test
    void test_3() {
        ListNode<Integer> node1 = ListNode.createListNode(5,2);
        ListNode<Integer> node2 = ListNode.createListNode(1,2);
        System.out.println("node1："+ JSON.toJSONString(node1));
        System.out.println("node2："+ JSON.toJSONString(node2));

        // 如果是2个【有序】链表合并，结果有序
        ListNode list1 = this.mergeTwoLists(node1, node2);
        System.out.println("list1："+ JSON.toJSONString(list1));

        // 如果是多个（K个）【有序】链表合并，结果有序
        ListNode list2 = this.mergeKLists(null);
    }

    public ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        ListNode<Integer> node = new ListNode(0);
        ListNode<Integer> list = node;
        int o1 = 0;
        int o2 = 0;
        while (node1 != null && node2 != null){
            if ((int)node1.val <= (int)node2.val) {
                list.next = node1;
                node1 = node1.next;
            } else {
                list.next = node2;
                node2 = node2.next;
            }
            list = list.next;
        }

        list.next = (node1 == null ? node2 : node1);

        return node.next;
    }

    // 把node节点存入list，排序，然后创建新ListNode
    public ListNode mergeKLists(ListNode[] lists) {
        // 这个方法要先循环K次，遍历K个链表，然后排序，然后再遍历，耗时间，PASS！！
        return null;
    }

    // 把node头节点存入有序Queue，然后创建新ListNode（★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆）
    public ListNode mergeKListsByQueue(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>();
        for (ListNode tempNode : lists) {
            queue.offer(tempNode);
        }
        // retList == tempList
        // 但是循环结束以后，tempList的指针在最后，但是retList的指针没有动过，还在最开头
        // 此时，才能使用retList.next获取最终结果（因为首位的0是没用的）
        ListNode<Integer> retList = new ListNode<>(0);
        ListNode<Integer> tempList = retList;
        while (!queue.isEmpty()) {
            tempList.next =  queue.poll();
            tempList = tempList.next;
            if (tempList.next != null) {
                // 把剩下的部分再放回队列，放进去以后，优先级队列自动排序
                queue.offer(tempList.next);
            }
        }
        return retList.next;
    }

    /**
     * 合并两个有序的数组num1和num2，
     *
     * 要求：将num2合并到num1，假设num1有足够的空间
     */
    @Test
    void test_4() {
        int[] A = {1,2,3,0,0,0};
        int[] B = {2,5,6};
        int m = 3,n = 3;        // 记录num1，num2大的长度

        // 思路：从后往前遍历2个数组，最大的数加到num1数组最后
        int len = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0){
            if (A[i] > B[j]) {
                A[len] = A[i];
                i--;
            } else {
                A[len] = B[j];
                j--;
            }
            len--;
        }
        // 如果B走完，A没走完，不需要管，正好等于结果

        // 如果A走完，B没走完，B剩下的元素排到A前面就行了（★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆）
        while(j >= 0){
            A[len] = B[j];
            j--;
            len--;
        }
        System.out.println("ret："+ JSON.toJSONString(A));
    }

    /**
     * 找出数组中超过一半的数
     */
    @Test
    void test_5() {
        // 1. map法
        // 2. 排序，然后取中间值，再遍历数组，看这个中间值num是不是过一半
        // 3. String法，中间字符进行替换，判断长度>len/2
        // 4. 假设法，取第一个元素，下一个元素相同就++ ，不同就--，等于0，就换个元素，最后的数字就是最长的，然后再判断他是不是超过一半
    }

    /**
     * 数组找出现频率最高的前k个元素（★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆）
     */
    @Test
    void test_6() {
        // 1. map法
        Integer[] arr = {1,2,3,4,6,7,1,4,2,4,5,7,5,6,9,2,4,5,7,4,1};
        int k = 2;
        Arrays.sort(arr);

        TreeMap<Integer, String> map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        String index = arr[0] + "";
        int num = 1;
        for (int i = 1; i < arr.length; i++) {
            if (index.equals(arr[i]+"")) {
                num ++;
            }else {
                if (map.containsKey(num)) {
                    String value = map.get(num);
                    index = value + "," + index;
                }
                map.put(num, index);
                num = 1;
                index = arr[i] + "";
            }
        }
        System.out.println("map："+ JSON.toJSONString(map));

        StringBuilder sb = new StringBuilder("");
        for(Map.Entry entry : map.entrySet()){
            sb.append(entry.getValue()).append(",");
        }
        System.out.println("sb："+ JSON.toJSONString(sb));
    }

    /**
     * 数组反转+去重
     */
    @Test
    void test_7() {
        Integer[] arr = {5,4,4,4,3,2,2,1};
        List<Integer> list = new ArrayList<>(arr.length);
        Collections.addAll(list, arr);
        Collections.sort(list);
        System.out.println("list："+ JSON.toJSONString(list));

        List<Integer> ret = list.stream().distinct().collect(Collectors.toList());
        System.out.println("ret："+ JSON.toJSONString(ret));
    }

    /**
     * 链表环的判断，是否相交
     */
    @Test
    void test_8() {
        ListNode node = ListNode.createListNode(5);
        ListNode fast = node;
        ListNode slow = node;
        while(fast.next != null && slow != null){
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                System.out.println("ret："+ JSON.toJSONString("有环"));
                return;
            }
        }
    }

    // 接上题：如果要返回链表中环的入口节点（相交点）
    @Test
    void test_8_1() {
        ListNode node = ListNode.createListNode(5);
        ListNode fast = node;
        ListNode slow = node;
        while(fast.next != null && slow != null){
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                // 重新定义一个slow指针，当二者相遇，就是环的起点
                ListNode slow2 = node;
                while(node != slow){
                    slow2 = slow2.next;
                    slow = slow.next;
                }
                System.out.println("ret："+ JSON.toJSONString(slow));
                return;
            }
        }
    }

    /**
     * leetcode-129：求根到叶子节点数字之和（这道题的背下来了）
     *
     * 二叉树的每条从根节点到叶子节点的路径都代表一个数字。
     * 其实，每个节点都对应一个数字，等于其父节点对应的数字乘以 1010 再加上该节点的值（这里假设根节点的父节点对应的数字是 00）。
     * 只要计算出每个叶子节点对应的数字，然后计算所有叶子节点对应的数字之和，即可得到结果。
     * 可以通过深度优先搜索和广度优先搜索实现。
     *
     */
    @Test
    void test_leetcode_129() {
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

    /**
     * leetcode-3：无重复字符的最长子串
     *
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     */
    @Test
    void test_leetcode_3() {
        String str = "abcabcbb";
//        String str = "bbbbbbbbb";
        int sum = 0;
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            Character temp = str.charAt(i);
            if (list.contains(temp)) {
                while (list.get(0) != temp){
                    list.remove(0);
                }
            }else {
                list.add(str.charAt(i));
                sum = Math.max(sum, list.size());
            }
        }
        System.out.println("sum："+ JSON.toJSONString(sum));
    }

    /**
     * leetcode-33：搜索旋转排序数组
     *
     * 整数数组 nums 按升序排列，数组中的值 互不相同 。
     */
    @Test
    void test_leetcode_33() {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        // 1. 字符串判断法
        // 2. 面试官想听的 - 二分查找
        // 先判断下是否有target，没有就直接返回失败
        List list = Arrays.asList(nums);
        if (!list.contains(target)){
            return;
        }
        // 在判断下是否满足回旋数组的条件，不满足这个条件，也没必要找了
        if(nums[nums.length - 1] > nums[0]){
            return;
        }
        // 二分查找 + 判断是否合理
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left + right)/2;
            if (nums[mid] == target){
                System.out.println("mid："+ JSON.toJSONString(mid));
                return;
            } else if (nums[mid] > target){
                right = mid - 1;
            } else if (nums[mid] < target){
                left = mid + 1;
            }
        }
    }

    /**
     * leetcode-56：合并区间（★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆）
     *
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
     * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
     *
     * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
     * 输出：[[1,6],[8,10],[15,18]]
     * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     *
     */
    @Test
    void test_leetcode_56() {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        // 1.如果没排序，先排个序,升序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        // 2.核心代码
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int up = intervals[i][0];
            int down = intervals[i][1];
            if (list.size() == 0){
                list.add(new int[]{up, down});
            } else if (list.get(list.size()-1)[1] > up){
                // 存在{1,6},{2,3}的情况，所以取最大值
                list.get(list.size()-1)[1] = Math.max(down, list.get(list.size()-1)[1]);
            } else {
                list.add(new int[]{up, down});
            }
        }
        int[][] ret = list.toArray(new int[list.size()][]);
        System.out.println("ret："+ JSON.toJSONString(ret));
    }

    /**
     * leetcode-64：最小路径和 / 最大路径和（★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆）
     *
     * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     */
    @Test
    void test_leetcode_4() {
        int[][] matrix = {{1,3,1},{1,5,1},{4,2,1}};

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] newArr = new int[m][n];
        newArr[0][0] = matrix[0][0];
        // 横向走
        for (int i = 1; i < m; i++) {
            newArr[0][i] = newArr[0][i-1] + matrix[0][i];
        }
        // 竖向走
        for (int i = 1; i < n; i++) {
            newArr[i][0] = newArr[i-1][0] + matrix[i][0];
        }
        // 两个for
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // Math.min 改成 Math.max 就是求最大和（★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆）
                newArr[i][j] = Math.min(newArr[i-1][j] + matrix[i][j], newArr[i][j-1] + matrix[i][j]);
            }
        }

        System.out.println("newArr："+ JSON.toJSONString(newArr));
        // 最小值
        System.out.println("min："+ JSON.toJSONString(newArr[m-1][n-1]));

    }

    /**
     * 杨辉三角
     */
    @Test
    void test_9() {
        //定义了一个长度为10，高度为10的二维数组，数组中的值都为0；
        int[][] arr = new int[10][10];
        for(int i = 0;i < arr.length;i++) {
            //由于只是给杨辉三角内的位置赋值，所以是j<=i
            for(int j=0;j<=i;j++) {
                //根据规律，使用if else 赋值
                if(j==0||j==i) {
                    arr[i][j]=1;
                }else {
                    arr[i][j]=arr[i-1][j-1]+arr[i-1][j];
                }
				// 由于只是输出杨辉三角范围内的值，所以在内层循环就输出，这种方法不能全部赋值完之后再输出
				//	"\t"的原因是10和小于10的数组的宽度不同，所以使用\t制表符能使数与数之间距离相等
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
    }

}