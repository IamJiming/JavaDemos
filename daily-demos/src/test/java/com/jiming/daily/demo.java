package com.jiming.daily;

import com.mysql.cj.protocol.a.NativeConstants;
import javafx.scene.CacheHint;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.CompareTo;

import java.util.*;

public class demo {
    @Test
//      1. 100以内的素数
    void test1() {
        int i, j;
        for (i = 1; i < 100; i++) {
            for (j = 2; j < 100; j++) {
                if (i % j == 0) {
                    break;
                }
            }
            if (i == j) {
                System.out.println(i + "是素数");
            }
        }
    }

    @Test
//      2. 冒泡排序，从大到小
    void test2() {
        int[] a = {6, 1, 2, 44, 9, 3};
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = a.length - 1; j > a.length - i - 1; j--) {
                if (a[j] > a[j - 1]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }

    @Test
//      3. 去除相邻字符串重复字符
    void test3() {
        String a = "abaabcdeed";
        StringBuffer str = new StringBuffer();
        char[] b = a.toCharArray();
        int top = -1;
        for (int i = 0; i < b.length; i++) {
            if (top >= 0 && str.charAt(top) == b[i]) {
                str.deleteCharAt(top);
                --top;
            } else {
                str.append(b[i]);
                ++top;
            }

        }
        System.out.println(str);
    }

    @Test
//      4. 字符串去重
    void test4() {
        String a = "abacdba";
        char[] b = a.toCharArray();
        StringBuffer str = new StringBuffer();
        List list = new ArrayList<>();
        for (int i = 0; i < a.length(); i++) {
            if (!list.contains(b[i])) {
                list.add(b[i]);
                str.append(b[i]);
            }
        }
        System.out.println(str);
    }

    @Test
//      5. 一个整形数组，给定一个目标值，求和为目标值的任意组合
    void test5() {
        int[] a = {1, 3, 4, 7, 9, 6};
        int target = 7;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(target - a[i])) {
                int[] d = new int[]{a[i], target - a[i]};
                System.out.println(Arrays.toString(d));
            }
            map.put(a[i], a[i]);
        }

    }

    @Test
//      6. 求最大不重复的字符串长度
    void test6() {
        String a = "abacendjbdefsn";
        char[] b = a.toCharArray();
        int max = 0;
        int start = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < b.length; i++) {
            if (map.containsKey(b[i])) {
                start = Math.max(start, map.get(b[i]) + 1);
            }
            map.put(b[i], i);
            max = Math.max(max, i - start + 1);
        }
        System.out.println(max);
    }

    @Test
//      7. 整数反转
    void test7() {
        int a = 124556;
        int rev = 0;
        while (a != 0) {
            int temp = a % 10;
            rev = rev * 10 + temp;
            a /= 10;
        }
        System.out.println(rev);
    }

    @Test
//  8. 字符串反转
    void test8() {
        String a = "sdffedsop";
        StringBuffer str = new StringBuffer();
        for (int i = a.length() - 1; i >= 0; i--) {
            str.append(a.charAt(i));
        }
        System.out.println(str);
    }

    @Test
//      9. 回文数
    void test9() {
        int a = 12120;
        if (a <= 0 || a % 10 == 0 && a != 0) {
            System.out.println(false);
        }
        int res = 0;
        while (a > res) {
            int temp = a % 10;
            res = res * 10 + temp;
            a /= 10;
        }
        if (a == res || a == res / 10) {
            System.out.println(true);
        }
        System.out.println(false);
    }

    @Test
    void test99(){
        int a = 12121;
        StringBuffer sb = new StringBuffer(a+"");
        String b= sb.reverse().toString();
        System.out.println(b);
        int c = Integer.valueOf(b);
        System.out.println(c);
        int aa = Integer.parseInt(b);
        System.out.println(aa);

        if(a==aa){
            System.out.println(true);
        }else {
            System.out.println(false);
        }

    }

    @Test
//    10. 两个字符串，最大匹配子串  字符串 String a =“abcdsee”
    void test10() {
        String a = "1AB2345CD";
        String b = "12345EF";
        String max = (a.length() > b.length()) ? a : b;
        String min = max.matches(a) ? b : a;
        for (int i = 0; i < min.length(); i++) {
            for (int m = 0, n = min.length() - i; n != min.length() + 1; m++, n++) {
                String sub = min.substring(m, n);
                if (max.contains(sub)) {
                    System.out.println(sub);
                    return;
                }
            }
        }
    }

    @Test
//      11. 提取两个字符串中的相同元素 String a="a,22,4,ii"
    void test11() {
        String a = "王小，订单，你好，来了，堵的";
        String b = "订单，你好，dd，还款";
        String[] a1 = a.split("，");
        String[] b1 = b.split("，");
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < b1.length; j++) {
                if (a1[i].equals(b1[j])) {
                    str.append(b1[j] + ",");
                }
            }
        }
        System.out.println(str);
    }

    @Test
//      12. 不改变数组顺序，求最大和
    void test12() {
        int[] a = {1, -2, -1, 3, -4, 2, -1, 8};
//        int i=0;
        int max = 0;
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (sum < 0) {
                sum = a[i];
            }
            if (sum > max) {
                max = sum;
            }
        }
        System.out.println(max);
    }

    @Test
//      13. 输入一个 字符串，统计字符串数
    void test13() {
        Scanner sca = new Scanner(System.in);
        String a = sca.nextLine();
        System.out.println(a);
        char[] d = a.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < d.length; i++) {
            if (map.containsKey(d[i])) {
                int value = map.get(d[i]);
                value++;
                map.put(d[i], value);
            } else {
                map.put(d[i], 1);
            }
        }
        for (Character key : map.keySet()) {
            int num = map.get(key);
            System.out.println(key + "=" + num);
        }
    }

    @Test
//      14. n块钱能买几瓶水，2块钱一瓶水，3个瓶盖换一瓶水
    void test14() {
        int n = 11;
        int m = n / 2;
        int sum = m;
        do {
            int a = m / 3;
            sum += a;
            int temp = m % 3;
            m = a + temp;
            temp = 0;
        } while (m >= 3);
        System.out.println(sum);
    }

    @Test
//  15. 删除有序数组中的重复项,，返回移除后数组的新长度。
    void test15() {
        int[] a = {1, 2, 2, 4, 5, 5};
        int i = 0;
        for (int j = 0; j < a.length; j++) {
            if (a[i] != a[j]) {
                i++;
                a[i] = a[j];
            }
        }
        System.out.println(i + 1);

    }

    @Test
//      16. 删除数组中的重复项，返回新的数组
    void test16() {
        int[] a = {1, 3, 3, 4, 5, 6};
        List lit = new ArrayList();
        int i = 0;
        lit.add(a[i]);
        for (int j = 0; j < a.length; j++) {
            if (a[i] != a[j]) {
                i++;
                a[i] = a[j];
                lit.add(a[i]);
            }
        }
        int[] d = new int[lit.size()];
        for (int m = 0; m < lit.size(); m++) {
            d[m] = (int) lit.get(m);
        }
        System.out.println(Arrays.toString(d));
    }

    @Test
//   17. 数组找出第一个重复的数的位置
    void test17() {
        int[] a = {1, 5, 2, 2, 3, 1, 4, 4};
        int index = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = a.length - 1; i >= 0; i--) {
            if (map.containsKey(a[i])) {
                map.put(a[i], map.get(a[i]) + 1);
                index = i;
            } else {
                map.put(a[i], 1);

            }
        }
        System.out.println(index);
    }

    @Test
//      18. 找出数组中第一个未重复的数
    void test18() {
        int[] a = {3, 2, 2, 3, 1, 4, 4};
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(a[i])) {
                int value = map.get(a[i]);
                value++;
                map.put(a[i], value);
            } else {
                map.put(a[i], 1);
            }
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                System.out.println(key);
                return;
            }
        }
    }

    @Test
//      19. 字符串排序
    void test19() {
        String a = "adbea";
        char[] d = a.toCharArray();
        Arrays.sort(d);
        String b = new String(d);
        System.out.println(b);
    }

    @Test
//  20. Java之字符串数组排序
    void test20() {
        String[] a = new String[]{"as", "aw", "ad", "am"};
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j].compareTo(a[j + 1]) > 0) {
                    String temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }

    @Test
//      21. 101个数字，[1，100]中有一个是重复的，找出这个重复的数字
    void test21() {
        int[] a = {1, 2, 2, 3, 4};
        int x = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length - 1; i++) {
            if (map.containsKey(a[i])) {
                x = map.get(a[i]);
            } else {
                map.put(a[i], a[i]);
            }
        }
        System.out.println(x);
    }

    //    数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0
    @Test
    void test22() {
        int[] array = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int d = MoreThanHalfNum_Solution(array);
        System.out.println(d);
    }


    public int MoreThanHalfNum_Solution(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                int value = map.get(array[i]);
                value++;
                map.put(array[i], value);
            } else {
                map.put(array[i], i);
            }
        }
        for (Integer key : map.keySet()) {
            int value = map.get(key);
            if (value > array.length / 2) {
                return key;
            }
        }
        return 0;
    }

    @Test
    void test23() {
        String a = "1.22.4";
        String b = "1.22.5";

        int result=compareVersion(a,b);
        System.out.println(result);

    }
//比较版本号大小
    public int compareVersion(String version1, String version2) {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");
        int n1 = nums1.length, n2 = nums2.length;

        // compare versions
        int i1, i2;
        for (int i = 0; i < Math.max(n1, n2); ++i) {
            i1 = i < n1 ? Integer.parseInt(nums1[i]) : 0;
            i2 = i < n2 ? Integer.parseInt(nums2[i]) : 0;
            if (i1 != i2) {
                return i1 > i2 ? 1 : -1;
            }
        }
        // the versions are equal
        return 0;
    }
    @Test
    void test233(){
//        左边大输出-1.右边大输出1.相等为0
        String a="1.2.1";
        String b="1.3";
        String[] a1=a.split("\\.");
        String[] b1=b.split("\\.");
        int na=a1.length;
        int nb=b1.length;
        for(int i=0;i<Math.max(na,nb);i++){
            int rea=(i<na)?Integer.parseInt(a1[i]):0;
            int reb=(i<nb)?Integer.parseInt(b1[i]):0;
            if(rea!=reb){
//                return rea>reb?1:-1;
                if(rea<reb){
                    System.out.println(1);
                    return;
                }else{
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(0);
        return;
    }

    @Test
    void test24(){
        int[] nums={-1,0,3,5,7,9};
        int target=9;
        int result=search1(nums,target);
        System.out.println(result);

    }

//    查找目标值
    public int search(int[] nums, int target) {
        HashMap<Integer,Integer> map =new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        if(map.containsKey(target)){
            return map.get(target);
        }
        return -1;
    }
//有序数组，二分查找,查找目标值
    public int search1(int[] nums, int target) {
        int pro,left=0,right=nums.length-1;
        while(left<=right){
            pro=left+(right-left)/2;
            if(nums[pro]==target){
                return pro;
            }
            if(nums[pro]<target){
                left=pro+1;
            }else{
               right=pro-1;
            }

        }
        return -1;
    }

    @Test
    void test25(){
      String s="()";
      boolean t = isValid(s);
      System.out.println(t);
    }
    public boolean isValid(String s) {

        Stack<Character> stack=new Stack<>();
        for(int i=0; i<s.length(); ++i){
            char c = s.charAt(i);
            if(!stack.empty()){
                char t = stack.peek();
                if(t=='(' && c==')'
                        || t=='[' && c==']'
                        || t=='{' && c=='}'){
                    stack.pop();
                    continue;
                }
            }
            stack.push(c);
        }
        return stack.empty();
    }

    public boolean isValid1(String s) {
       String s1 = new StringBuffer(s).reverse().toString();
       if(s.length()%2>0){
           return false;
       }
       if(s.length()%2==0){
        for (int i = 0; i < s.length()/2; i++) {
            char c = s.charAt(i);
            char t = s1.charAt(i);
            if(c=='(' && t==')' || c=='[' && t==']' || c=='{' && t=='}'){
                continue;
            }else {
                return false;
            }
        }

    }
        return true;
    }

    @Test
//    找出字符串中出现频率最高的字符 并将它输出
    void test26(){
        String a="ddssffdass";
        char[] a1=a.toCharArray();
        HashMap<Character,Integer> map =new HashMap<>();
        for(int i=0;i<a.length();i++){
            if(map.containsKey(a1[i])){
                int value=map.get(a1[i]);
                value++;
                map.put(a1[i],value);
            }else{
                map.put(a1[i],1);
            }
        }
        int n=0;
        char re = 0;
        for(Character key: map.keySet()){
            if(n<map.get(key)){
                n=map.get(key);
                re=key;
            }
        }
        System.out.println(re);
    }
    @Test
    void test28(){
        int n=3;
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        System.out.println(r);
    }

    @Test
    void test27(){
        int n=5;
        if (n <= 2) {
            System.out.println(n);
            return;
        }
        int[] f = new int[n + 1];
        f[1] = 1;
        f[2] = 2;
        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        System.out.println(f[n]);

    }

}
