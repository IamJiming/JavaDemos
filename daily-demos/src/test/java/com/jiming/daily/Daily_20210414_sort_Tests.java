package com.jiming.daily;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

/**
 * 排序算法
 *
 * Collections.sort()底层用的就是Arrays.sort方法，Arrays.sort的底层使用快速排序和归并排序实现的；
 * 冒泡排序，简单插入，都需要不停的互换值；但是简单选择排序，每次交换的是指针，最后交换一次数据；
 *
 * @author Mr.tjm
 * @date 2021-4-14 17:25
 */
public class Daily_20210414_sort_Tests {
    /**
     * 【冒泡排序】：
     *
     * 每次把最大的数冒到最后
     */
    @Test
    void algs_test_8() {
        int[] arr = {1,2,3,5,8,11,10,6,9,7,54,23,27,17,22,13};
        int length = arr.length;
        if (length <= 1) {
            return;
        }
        // 外层定义循环次数，内层定义每次循环位置
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            System.out.println(i + ", arr = " + JSON.toJSONString(arr));
        }
        System.out.println("冒泡排序 arr = " + JSON.toJSONString(arr));
    }

    /**
     * 【简单选择排序】：
     *
     * 每次选择最小的数字，与第i个位置交换
     */
    @Test
    void algs_test_9() {
        int[] arr = {1, 2, 3, 5, 8, 11, 10, 6, 9, 7, 54, 23, 27, 17, 22, 13};
        int length = arr.length;
        if (length <= 1) {
            return;
        }
        // 外层定义循环次数，内层定义每次循环位置
        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;
            for (int j = i; j < length - 1; j++) {
                if (arr[minIndex] > arr[j+1]) {
                    minIndex = j+1;
                }
            }
            if (i != minIndex) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
            System.out.println(i + ", arr = " + JSON.toJSONString(arr));
        }
        System.out.println("选择排序 arr = " + JSON.toJSONString(arr));
    }

    /**
     * 【简单插入排序】：
     *
     * 操作n-1轮，每轮将一个未排序树插入排好序列。
     */
    @Test
    void algs_test_10() {
        int[] arr = {1,2,3,5,8,11,10,6,9,7,54,23,27,17,22,13};
        int length = arr.length;
        if (length <= 1) {
            return;
        }
        // 外层定义循环次数，内层定义每次循环位置
        for (int i = 1; i < length; i++) {
            // 认为第一个元素是有序的，从第二个元素开始
            int index = i;
            int temp = arr[i];
            while(index > 0 && (temp < arr[index-1])) {
                arr[index] = arr[index-1];
                index --;
            }
            arr[index] = temp;
            System.out.println(i + ", arr = " + JSON.toJSONString(arr));
        }
        System.out.println("简单插入排序 arr = " + JSON.toJSONString(arr));
    }

    /**
     * 【快速排序】：
     *
     * 快速排序基于选择划分，是简单选择排序的优化。
     * 每次划分将数据选到基准值两边，循环对两边的数据进行划分，类似于二分法。
     * 算法的整体性能取决于划分的平均程度，即基准值的选择，此处衍生出快速排序的许多优化方案，甚至可以划分为多块。
     */
    @Test
    void algs_test_11() {
        int[] arr = {1,2,3,5,8,11,10,6,9,7,54,23,27,17,22,13};
        System.out.println("快速排序 arr = " + JSON.toJSONString(arr));
    }
/*
    private int partition(int[] arr,int left,int right){
        // 划分参考数索引，默认为第一个数，可优化
        int key = left;
        while left<right:
        while left<right and arr[right]>=arr[key]:
        right-=1
        while left<right and arr[left]<=arr[key]:
        left+=1
        (arr[left],arr[right])=(arr[right],arr[left])
        (arr[left],arr[key])=(arr[key],arr[left])
        return left
    }

    private void quicksort(int[] arr,int left,int right){
        if (left>=right) {
            return;
        }
        int mid = partition(arr,left,right);
        this.quicksort(arr,left,mid-1);
        this.quicksort(arr,mid+1,right);
    }
*/

    // 一直对比，一直交换
    @Test
    void algs_test_1() {
        int[] arr = {1, 2, 3, 5, 8, 11, 10, 6, 9, 7, 54, 23, 27, 17, 22, 13};
        int len = arr.length;
        for (int i = 0; i < len-1; i++) {
            for (int j = i; j < len-1; j++) {
                if (arr[j] >  arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println("冒泡排序 arr = " + JSON.toJSONString(arr));
    }

    // "选择排序：每次选择一个最小的值
    @Test
    void algs_test_2() {
        int[] arr = {1, 2, 3, 5, 8, 11, 10, 6, 9, 7, 54, 23, 27, 17, 22, 13};
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            int min = arr[i];
            int index = i;
            for (int j = i+1; j < len; j++) {
                if (arr[j] < min) {
                    index = j;
                    min = arr[j];
                }
            }
            if (i != index) {
                arr[index] = arr[i];
                arr[i] = min;
            }
        }
        System.out.println("选择排序 arr = " + JSON.toJSONString(arr));
    }
}
