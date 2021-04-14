package com.jiming.daily;

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.criteria.CriteriaBuilder;
import java.lang.reflect.Array;
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
        int i = str.hashCode();
        int max=0,sum=0;
        for (int j=0;j<str.length();j++) {
            int index = str.charAt(j) == 'E' ? 1 : -1;
            sum = Math.max(sum + index, index);
            max = Math.max(max, sum);
        }
        List list = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            it.remove();
        }
        System.out.println("max = " + max);
    }

    /**
     * 1 - 改
     */
    @Test
    void algs_test_3() {
        TreeMap map = new TreeMap(new Comparator<String>() {
            // 降序：star > end -> false
            @Override
            public int compare(String o1, String o2) {
                int star = Integer.parseInt(o1);
                int end = Integer.parseInt(o2);
                if (star > end) {
                    return -1;
                } else if (star < end){
                    return 1;
                }
                return 0;
            }
        });
        map.put("1","1");
        map.put("3","3");
        map.put("2","2");
        System.out.println("max = " + JSON.toJSONString(map));
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



}
