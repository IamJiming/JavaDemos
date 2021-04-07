package com.jiming.daily;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Http 测试类
 *
 * @author Mr.tjm
 * @date 2020-04-06 11:25
 */
public class Day_20210402_Regex_Tests {

    @Test
    void test_1 () {
        String str = "AkleBiCeilD";
        str = str.replaceAll("[A-Z]", "") + str.replaceAll("[a-z]", "");
        System.out.println("str = " + str);
    }

    @Test
    void test_2 () {
        String str = "AABBCC";
//        String str1 = str.replaceAll("(.)\\1+","$1$1");
//        System.out.println("str1 = " + str1);
//        String str2 = str.replaceAll("(.)\\1(.)\\2","$1$1$2");
//        System.out.println("str2 = " + str2);
        String str3 = str.replaceAll("(.)\\1(.)\\2(.)\\3","$1$1$2$3$3");
        System.out.println("str3 = " + str3);
    }

    @Test
    void test_3 () {
        String regex = "(\\w)\\1(\\w)\\2";
        String input = "A";
        String input2 = "AA";
        String input3 = "AAA";
        String input4 = "AABB";
        String input5 = "AABBCC";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        Matcher matcher2 = pattern.matcher(input2);
        Matcher matcher3 = pattern.matcher(input3);
        Matcher matcher4 = pattern.matcher(input4);
        Matcher matcher5 = pattern.matcher(input5);
        System.out.println("boolean1 = " + matcher.matches());
        System.out.println("boolean2 = " + matcher2.matches());
        System.out.println("boolean3 = " + matcher3.matches());
        System.out.println("boolean4 = " + matcher4.matches());
        System.out.println("boolean5 = " + matcher5.matches());

        String str = "AABB";
        String str1 = str.replaceAll("(.)\\1+","$1$1");
        System.out.println("str1 = " + str1);
        String str2 = str.replaceAll("(.)\\1(.)\\2","$1$1$1$2");
        System.out.println("str2 = " + str2);


        String str3 = "Is is the cost of of gasoline going up up";
        Pattern pattern3 = Pattern.compile("/\\b([a-z]+) \\1\\b/ig");
        Boolean b3 = str3.matches("/\\b([a-z]+) \\1\\b/ig");
        System.out.println("b3 = " + b3);
    }


}
