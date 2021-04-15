package com.jiming.daily;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 算法测试
 *
 * @author Mr.tjm
 * @date 2021-4-1 17:25
 */
@SpringBootTest
@SuppressWarnings("all")
public class Daily_20210401_Algs_Tests {
    private static final Logger logger = LoggerFactory.getLogger(Daily_20210401_Algs_Tests.class);

    // 时间格式
    private static final SimpleDateFormat simple_1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private  static   final AtomicInteger cas = new AtomicInteger(1);

    @Test
    void simple_test() {
        logger.info("〓 〓 〓 〓 〓 〓 〓 〓 〓 〓 BEGIN 〓 〓 〓 〓 〓 〓 〓 〓 〓 〓 ");
        logger.info("〓 〓 〓 〓 〓 〓 〓 〓 〓 〓  END  〓 〓 〓 〓 〓 〓 〓 〓 〓 〓 ");
    }

    /**
     * 小美喜欢字母E，讨厌字母F。
     * 在小美生日时，小团送了小美一个仅包含字母E和F的字符串，
     * 小美想从中选出一个包含字母E数量与字母F数量之差最大的子串。
     */
    @Test
    void algs_test_1() {
        // E = 1;F = -1。求最大值
        String str = "EFEEF";
        char[] charArry = str.toCharArray();
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<charArry.length;i++) {
            if ('E' == charArry[i]) {
                list.add(1);
            } else {
                list.add(-1);
            }
        }
        int max=0,sum=0;
        for (int j=0;j<list.size();j++) {
            sum = Math.max(sum + list.get(j), list.get(j));
            max = Math.max(max, sum);
        }
        System.out.println("max = " + max);
    }

    /**
     * 1 - 改
     */
    @Test
    void algs_test_2() {
        // E = 1;F = -1。求最大值
        String str = "EFEEF";
        int max=0,sum=0;
        for (int j=0;j<str.length();j++) {
            int index = str.charAt(j) == 'E' ? 1 : -1;
            sum = Math.max(sum + index, index);
            max = Math.max(max, sum);
        }
        System.out.println("max = " + max);
    }

    /**
     * 两个数组，合并 + 排序 —— 方法1，使用Collections方法
     */
    @Test
    void algs_test_4() {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        List<Integer> list = new ArrayList();
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] > 0) {
                list.add(nums1[i]);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            list.add(nums2[i]);
        }
        // 默认从小到大，如果从大到小，可以使用反转方法
        Collections.sort(list);
//        Collections.reverse(list);
        for (int i = 0; i < list.size(); i++) {
            nums1[i] = list.get(i);
        }
        System.out.println("方法1 nums1 = " + JSON.toJSONString(nums1));
    }

    /**
     * 两个数组，合并 + 排序 —— 方法2，使用list.sort()方法
     */
    @Test
    void algs_test_5() {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        List list = new ArrayList();
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] > 0) {
                list.add(nums1[i]);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            list.add(nums2[i]);
        }
        list.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Integer indx1 = Integer.valueOf(o1.toString());
                Integer indx2 = Integer.valueOf(o2.toString());
                // indx1 > indx2 返回 1（降序）；indx1 = indx2 返回 0；indx1 < indx2 返回 -1 （升序）
                return indx1.compareTo(indx2);
//                return indx1 > indx2 ? -1 : 1;
            }
        });
        for (int i = 0; i < list.size(); i++) {
            nums1[i] = (int)list.get(i);
        }
        System.out.println("方法2 nums1 = " + JSON.toJSONString(nums1));
    }

    /**
     * 两个数组，合并 + 排序 —— 方法3，使用Arrays.sort()方法
     * 利用数组的排序方法
     */
    @Test
    void algs_test_6() {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        List list = new ArrayList();
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] > 0) {
                list.add(nums1[i]);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            list.add(nums2[i]);
        }
        Object[] num3 = list.toArray();
        Arrays.sort(num3);
        System.out.println("方法3 num3 = " + JSON.toJSONString(num3));
    }

    /**
     * 不改变数组顺序，求连续数组元素的最大和，数组元素有负数有正数 # # # # # # # # # # ! ! ! ! ! ! ! ! ! !
     *
     * 动态规划的思想
     */
    @Test
    void algs_test_7() {
        int[] arr = {1,-2,-1,3,-4,2,-1,8};
        // 保存每组的和，保存最大和
        int sum = arr[0],max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum = Math.max(arr[i], sum + arr[i]);
            max =  Math.max(sum, max);
        }
        System.out.println("max = " + JSON.toJSONString(max));
    }

    /**
     * 两个数组找出相同的元素
     *
     * 用map，和两层for循环暴力对比，我在写一种【归并思想】
     */
    @Test
    void algs_test_8() {
        int[] arr1 = {1,2,3,4,5,6};
        int[] arr2 = {2,5,8};
        List list = new ArrayList();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int i = 0,j = 0;
        while(i < arr1.length && j < arr2.length){
            if (arr1[i] == arr2[j]) {
                list.add(arr1[i]);
                i++;
                j++;
            } else if (arr1[i] > arr2[j]){
                j++;
            } else {
                i++;
            }
        }
        System.out.println("list = " + JSON.toJSONString(list));
    }

    /**
     * 聪明的编辑：微信公众号收录
     *
     * 使用 正则表达式 里的【反向引用】
     */
    @Test
    void algs_test_9() {
        String str = "helloo";
        str = str.replaceAll("(.)\\1(.)\\2(.)\\3", "$1$1$2$3$3");
        str = str.replaceAll("(.)\\1(.)\\2", "$1$1$2");
        System.out.println("str = " + JSON.toJSONString(str));
    }

    /**
     * 大小写字母差值
     * 小美希望文章中的大小写字母数量相同，
     * 所以她想让小团帮她把某些小写字母改成对应的大写字母，或者把某些大写字母改成对应的小写字母，使得文章变得优雅。
     * 小美给出的文章一定是由偶数长度组成的，她想知道最少修改多少个字母，才能让文章优雅。
     */
    @Test
    void algs_test_10() {
        String str = "AAACCb";
        int index_a = Integer.valueOf('a');
        int len = str.length();
        int lower = 0;
        for (int i = 0; i < len; i++) {
            if (Integer.valueOf(str.charAt(i)) >= index_a) {
                lower ++;
            }else {
                lower --;
            }
        }
        int result = lower/2;
        System.out.println("max = " + JSON.toJSONString(result >= 0 ? result : -result));
    }

    /**
     * 求两个数组的重合部分和不重合部分
     *
     * A国和B国正在打仗，他们的目的是n块土地。现在，A国和B国暂时休战，为了能合理分配这一些土地，AB国开始协商。
     * A国希望得到这n块土地中的p块土地，B国希望得到这n块土地中的q块土地。每个国家都将自己希望得到的土地编号告诉了小团和小美——两位战争调和人。
     * 你需要帮小团和小美计算，有多少块土地是只有A国想要的，有多少块土地是只有B国想要的，有多少块土地是两个国家都想要的。
     */
    @Test
    void algs_test_11() {
        int[] result = new int[3];

        int num = 10;
        int[] country_a = {0,1,2,3,4,5};
        int[] country_b = {4,5,6,7,8,9};

        Arrays.sort(country_a);
        Arrays.sort(country_b);

        int i=0,j=0,index=0;
        while (i < country_a.length && j < country_b.length) {
            if (country_a[i] > country_b[j]) {
                j++;
            } else if (country_a[i] < country_b[j]) {
                i++;
            } else {
                i++;
                j++;
                index++;
            }
        }

        result[0] = country_a.length - index;  // a
        result[1] = country_b.length - index;  // b
        result[2] = index;  // 重合
        System.out.println("result = " + JSON.toJSONString(result));
    }

    /**
     * 小包从36张牌中抽取了13张牌，他想知道在剩下的23张牌中，再取一张牌，取到哪几种数字牌可以和牌。
     *
     * 4张牌中有2张相同数字的牌，称为雀头。
     * 除去上述2张牌，剩下12张牌可以组成4个顺子或刻子(一样的牌)。
     */
    @Test
    void algs_test_12() {
        String str = "1112225556669";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);

            if (map.get(ch) == null) {
                map.put(str.charAt(i), 1);
            } else if (map.get(ch) == 2) {
                map.remove(ch);
            } else {
                map.put(str.charAt(i), map.get(ch) + 1);
            }
        }
        for (Character c : map.keySet()) {
            System.out.println("str = " + JSON.toJSONString(c));
        }
        System.out.println("str = " + JSON.toJSONString("END"));
    }

}
