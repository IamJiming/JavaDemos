package com.jiming.daily;

import org.junit.jupiter.api.Test;

/**
 * Java基础 —— 代码实现 字符串 十六进制 与 二进制 的转换
 *
 * @author Mr.tjm
 * @date 2021-4-16 17:25
 */
@SuppressWarnings("all")
public class Daily_20210416_byte_Tests {

    /**
     * parseInt(str,int) 的使用：
     *
     * 如：parseInt("1010",2)输出 二进制 1010 在 十进制 下的数
     */
    @Test
    void byte_test_3() {
        String hex = "E4";

        Integer num = Integer.parseInt(hex, 16);
        String hex_16_str = Integer.toHexString(num);
        String hex_2_str = Integer.toBinaryString(num);
        System.out.println("hex_16_str = " + hex_16_str);
        System.out.println("hex_2_str = " + hex_2_str);

        Integer num1 = Integer.parseInt("16");
        System.out.println("num1 = " + num1);

        StringBuilder sdf = new StringBuilder();
        int len = hex_2_str.length();
        for (int i = 0; i < len; i++) {
            sdf.append(hex_2_str.charAt(i));
            if ((i+1) % 4 == 0 && (i+1) < len) {
                sdf.append(" ");
            }
        }
        System.out.println("sdf = " + sdf);
    }


    // ———————————————————— private method ————————————————————

}
