package com.jiming.daily.business;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

public class hn {

    @Test
    void test_Calendar() {
        Date time = new Date();
        int num = 1;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        calendar.add(Calendar.SECOND, -num * 24 * 3600);
        // 两种把Calendar转化成Long类型的方法（毫秒）
        Date dateBefore = calendar.getTime();
        // 把时间换算成毫秒
        System.out.println("data = " + dateBefore.getTime());

        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(time);
        calendar1.add(Calendar.DAY_OF_YEAR, -num);
        // 两种把Calendar转化成Long类型的方法（毫秒）
        Date dateBefore1 = calendar1.getTime();
        // 把时间换算成毫秒
        System.out.println("data1 = " + dateBefore1.getTime());
    }

    @Test
    void test_1() {
        String itemCode = "002004";
        // catalogCode 就是 itemCode 截取前三位
        String catalogCode = itemCode.substring(0,3);
        System.out.println("itemCode = " + itemCode);
        System.out.println("catalogCode = " + catalogCode);
    }


}
