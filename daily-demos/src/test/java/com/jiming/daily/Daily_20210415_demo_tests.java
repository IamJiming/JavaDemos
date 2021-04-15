package com.jiming.daily;

import org.junit.jupiter.api.Test;

/**
 * Java基础测试Demo
 *
 * @author Mr.tjm
 * @date 2021-4-15 17:25
 */
public class Daily_20210415_demo_tests {

    /**
     * Integer比较的问题
     */
    @Test
    void demo_test_1() {
        Integer a = new Integer(200);
        int b = 200;
        Integer c = 200;
        Integer d = 200;

        System.out.println(a.equals(b));      // true
        System.out.println(a == b);           // true
        System.out.println(a == c);           // false
        System.out.println(c == d);           // false
        System.out.println(a == c);           // false
        System.out.println(b == c);           // true

        Integer a1 = new Integer(3);
        Integer b1 = 3;                   //   java在编译的时候,被翻译成-> Integer b = Integer.valueOf(3);
        int c1 = 3;
        System.out.println(a1 == b1);           // false
        System.out.println(a1 == c1);           // true

        // Integer 是对象， Integer a = 200 <=> Integer a = new Integer(200)
        // int 与 Integer 比较的时候发生自动拆箱，将a自动变为int,不管值为多少始终是相等的

        Integer a2 = 127;
        Integer b2 = 127;
        Integer c2 = 128;
        Integer d2 = 128;
        System.out.println(a2 == b2);            // true
        System.out.println(c2 == d2);            // false

        // Intger a =127 相当于 Integer a = Integer.valueOf(127);
        // 对于-128到127之间的数，会进行缓存，
        // Integer a= 127时，会将127进行缓存，下次再写Integer b= 127时，就会直接从缓存中取
    }

}
