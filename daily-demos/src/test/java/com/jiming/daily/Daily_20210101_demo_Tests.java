package com.jiming.daily;

import javafx.scene.CacheHint;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.CompareTo;

import java.lang.reflect.Array;
import java.util.*;

public class Daily_20210101_demo_Tests {
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
//    10. 两个字符串，最大匹配子串  字符串 String a =“abcdsee”
    void test10() {
        String a = "adfgsdfff";
        String b = "dffgsdq";
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
        Scanner scan = new Scanner(System.in);
//        String a=scan.nextLine();
//        System.out.println(a+"a");
//        String b=scan.nextLine();
//        System.out.println(b+"b");
        String a = "3";
        String b = "1";
        if (a.contains(".") || b.contains(".")) {
            String a1 = a.replace(".", "");
            String b1 = b.replace(".", "");
            String max = (a1.length() > b1.length()) ? a1 : b1;
            String min = max.matches(a1) ? b1 : a1;
            StringBuffer str = new StringBuffer();
            str.append(min);
            for (int i = 0; i < max.length() - min.length(); i++) {
                str.append(0);
            }
            int num1 = Integer.parseInt(max);
            int num2 = Integer.parseInt(String.valueOf(str));
            if (num1 > num2) {
                System.out.println(max + "是大版本");
                return;
            }
            if (num1 == num2) {
                System.out.println("版本相等");
                return;
            }
            if (num1 < num2) {
                System.out.println(min + "是大版本");
                return;
            }
        }
    }

    @Test
    void test24() {
        String version1 = "0.1";
        String version2 = "1.1";

        int n = compareVersion(version1, version2);
        System.out.println(n);
    }


    public int compareVersion(String version1, String version2) {
        String[] a = version1.split("\\.");
        String[] b = version2.split("\\.");
        int num1 = a.length;
        int num2 = b.length;
        for (int i = 0; i < Math.max(num1, num2); i++) {
            int sp1 = (i < num1) ? Integer.parseInt(a[i]) : 0;
            int sp2 = (i < num2) ? Integer.parseInt(b[i]) : 0;
            if (sp1 != sp2) {
                return (sp1 > sp2) ? -1 : 1;
            }
        }
        return 0;
    }

    @Test
    void test25() {
        int[] num = {-1, 0, 1, 2, -1, -4};
        Arrays.sort(num);
        List<List<Integer>> lists = new ArrayList<>();
        List list = new ArrayList<>();
        int len = num.length;
        if (len < 3) {
            System.out.println("");
        }
        for (int i = 0; i < len; i++) {
            if (num[i] > 0) {
                System.out.println("");
                break;
            }
            if (i > 0 &&num[i]==num[i-1]){
                continue;
            }
            int curr=num[i];
            int L=i+1;
            int R=len-1;
            while(L<R){
                int temp=curr+num[L]+num[R];
                if(temp==0){
                    list.add(curr);
                    list.add(num[L]);
                    list.add(num[R]);
                    lists.add(list);
                    while(L<R&&num[L]==num[L+1]){
                        ++L;}
                    while(L>R&&num[R]==num[R-1]){
                        --R;}
                    ++L;
                    --R;
                }else if(temp<0){
                    ++L;
                    }else{
                       -- R;
                    }
                }
            }
        System.out.println(lists);
        }

}
