package com.jiming.daily;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 *
 */
public class Daily_20210518_Map_Tests {

    @Test
    void test_1() {
        Map map = new HashMap();
        map.put("","");

        int a = 10;
        int b = 5;
        a = b - a;//a 现在为 b 和 a 之间的差
        b = b - a;//b 减去 a（此时a 为 b 和 a 的差） 此时 b 的值等于 a了
        a  = b + a;//b（此时b 的 值 为a） 加上 a（此时a 为 b 和 a 的差） 的值等于 b
        System.out.println("a：" + JSON.toJSONString(a));
        System.out.println("b：" + JSON.toJSONString(b));
    }

    @Test
    void test_2() {
        System.out.println("time：" + JSON.toJSONString(new Date().getTime()));
    }

}
