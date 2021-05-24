package com.jiming.daily;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Java 8 Stream
 *
 * @author Mr.tjm
 * @date 2021-5-13 09:25
 */

/**
 * Java 8 API添加了一个新的抽象称为流Stream，可以让你以一种声明的方式处理数据。
 *
 * Stream 使用一种类似用 SQL 语句从数据库查询数据的直观方式来提供一种对 Java 集合运算和表达的高阶抽象。
 *
 * Stream API可以极大提高Java程序员的生产力，让程序员写出高效率、干净、简洁的代码。
 *
 * 这种风格将要处理的元素集合看作一种流， 流在管道中传输， 并且可以在管道的节点上进行处理， 比如筛选， 排序，聚合等。
 *
 * 元素流在管道中经过中间操作（intermediate operation）的处理，最后由最终操作(terminal operation)得到前面处理的结果。
 *
 * stream of elements +-----> |filter+-> |sorted+-> |map+-> |collect|
 */
public class Daily_20210513_Stream_Tests {

    /**
     * filter
     *
     * filter 方法用于通过设置的条件过滤出元素。以下代码片段使用 filter 方法过滤出空字符串：
     */
    @Test
    void test_1() {
        List<String> strs = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");

        // 获取空字符串的数量
        Long num = strs.stream().filter(String -> StringUtils.isBlank(String)).count();
        System.out.println("num：" + JSON.toJSONString(num));

        // 获取所有包含“bc”的字符串
        // 注意： Stream<String> list = strs.stream().filter(String -> String.contains("bc"); Stream实体无法打印输出
        // 所以，加上.collect(Collectors.toList())，转成list
        List<String> list = strs.stream().filter(String -> String.contains("bc")).collect(Collectors.toList());
        System.out.println("list：" + JSON.toJSONString(list));

        List<String> filtered = strs.stream().filter(String -> StringUtils.isNotBlank(String)).collect(Collectors.toList());
        System.out.println("filtered：" + JSON.toJSONString(filtered));

        String mergedString = strs.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);
    }

    /**
     * map
     *
     * map 方法用于映射每个元素到对应的结果，以下代码片段使用 map 输出了元素对应的平方数
     */
    @Test
    void test_2() {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        System.out.println("numbers：" + JSON.toJSONString(numbers));

        // 获取对应的平方数
        List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        System.out.println("stream：" + JSON.toJSONString(squaresList));
    }

    /**
     * limit
     *
     * limit 方法用于获取指定数量的流。 以下代码片段使用 limit 方法打印出 10 条数据：
     */
    @Test
    void test_3() {
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
    }

    /**
     * sorted
     *
     * sorted 方法用于对流进行排序。以下代码片段使用 sorted 方法对输出的 10 个随机数进行排序：
     */
    @Test
    void test_4() {
        Random random = new Random();
        random.ints().limit(10).sorted().forEach(System.out::println);
    }

    /**
     * 并行处理：parallelStream
     *
     * stream() − 为集合创建串行流。
     * parallelStream() − 为集合创建并行流。
     */
    @Test
    void test_5() {
        List<String> strs = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        Long num = strs.parallelStream().filter(String -> StringUtils.isBlank(String)).count();
        System.out.println("num：" + JSON.toJSONString(num));
    }

    /**
     * Collectors
     *
     * 转List - toList：.collect(Collectors.toList()
     * 转map - toMap：.collect(Collectors.toMap(UserBo::getUserId, v -> v, (v1, v2) -> v1));
     * 转String - joining：Collectors.joining("")
     */
    @Test
    void test_7() {
        List<String> list = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");

        // toList
        List<String> list1 = list.stream().filter(String -> StringUtils.isNotBlank(String)).collect(Collectors.toList());
        System.out.println("list1：" + JSON.toJSONString(list1));
        List<String> list2 = list.stream().filter(String -> StringUtils.isNotBlank(String)).sorted().collect(Collectors.toList());
        System.out.println("list2：" + JSON.toJSONString(list2));
        List<String> list3 = list.stream().filter(String -> String.contains("bc")).collect(Collectors.toList());
        System.out.println("list3：" + JSON.toJSONString(list3));

        // toString
        String str1 = list.stream().collect(Collectors.joining());
        String str2 = list.stream().collect(Collectors.joining(","));
        String str3 = list.stream().filter(String -> String.contains("bc")).sorted().collect(Collectors.joining(","));
        System.out.println("str1：" + str1);
        System.out.println("str2：" + str2);
        System.out.println("str3：" + str3);

        // toMap：要求list存储的是对象
        // collect(Collectors.toMap(UserBo::getUserId, v -> v, (v1, v2) -> v1));
        // 第一个参数UserBo::getUserId：  表示选择UserBo的getUserId作为map的key值；
        // 第二个参数v -> v：             表示选择将原来的对象作为map的value值；
        // 第三个参数(v1, v2) -> v1中：   如果v1与v2的key值相同，选择v1作为那个key所对应的value值
        User user1 = new User("123","张灵武","111");
        User user2 = new User("456","王久期","222");
        User user3 = new User("789","李二三","333");

        List<User> usrList = new ArrayList<>();
        usrList.add(user1);
        usrList.add(user2);
        usrList.add(user3);

        // getUserId作为key，user作为value
        Map<String, User> map1 = usrList.stream().collect(Collectors.toMap(User :: getUserId, v -> v));
        System.out.println("map1：" + JSON.toJSONString(map1));
        Map<String, String> map11 = usrList.stream().collect(Collectors.toMap(User :: getUserId, v -> v.getUserName()));
        System.out.println("map11：" + JSON.toJSONString(map11));
        // getUserId作为key，user作为value，如果两个对象相同v1=v2，只取前一个v1（或者后一个v2）
        Map<String, User> map2 = usrList.stream().collect(Collectors.toMap(User :: getUserId, v -> v, (v1,v2) -> v1));
        System.out.println("map2：" + JSON.toJSONString(map2));
        Map<String, User> map22 = usrList.stream().collect(Collectors.toMap(User :: getUserId, v -> v, (v1,v2) -> v2));
        System.out.println("map22：" + JSON.toJSONString(map22));
    }

    public class User{
        private String userId;
        private String userName;
        private String phone;

        public User(String userId, String userName, String phone) {
            this.userId = userId;
            this.userName = userName;
            this.phone = phone;
        }

        public String getUserId() {
            return userId;
        }
        public void setUserId(String userId) {
            this.userId = userId;
        }
        public String getUserName() {
            return userName;
        }
        public void setUserName(String userName) {
            this.userName = userName;
        }
        public String getPhone() {
            return phone;
        }
        public void setPhone(String phone) {
            this.phone = phone;
        }
    }



}
