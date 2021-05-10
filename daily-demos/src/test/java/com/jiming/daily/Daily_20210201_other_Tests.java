package com.jiming.daily;

import com.alibaba.fastjson.JSON;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 日常测试类
 *
 * @author Mr.tjm
 * @date 2021-1-6 17:25
 */
@SpringBootTest
public class Daily_20210201_other_Tests {
    private static final Logger logger = LoggerFactory.getLogger(Daily_20210201_other_Tests.class);

    // 时间格式
    private static final SimpleDateFormat simple_1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private  static   final AtomicInteger cas = new AtomicInteger(1);

    @Test
    void simple_test() {
        logger.info("〓 〓 〓 〓 〓 〓 〓 〓 〓 〓 BEGIN 〓 〓 〓 〓 〓 〓 〓 〓 〓 〓 ");

        String str = new String();

        logger.info("〓 〓 〓 〓 〓 〓 〓 〓 〓 〓  END  〓 〓 〓 〓 〓 〓 〓 〓 〓 〓 ");
    }

    @Test
    void time_test() {
        logger.info("〓 〓 〓 〓 〓 〓 〓 〓 〓 〓 BEGIN 〓 〓 〓 〓 〓 〓 〓 〓 〓 〓 ");

        String timestamp ="1580313600000";
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(Long.valueOf(timestamp));
        String now = simple_1.format(calendar.getTimeInMillis());
        logger.info("now = " + now);

        logger.info("〓 〓 〓 〓 〓 〓 〓 〓 〓 〓  END  〓 〓 〓 〓 〓 〓 〓 〓 〓 〓 ");
    }

    @Test
    void jdbc_test() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            // 1.注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 2.打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db","root","root");

            // 3.执行查询
            stmt = conn.createStatement();
            String sql = "SELECT id, name, url FROM websites";
            rs = stmt.executeQuery(sql);
            // 4.输出结果
            System.out.print("查询结果：" + rs);
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            // 关闭资源
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    void list_test() {
        List list = new LinkedList();
        list.add("我是");
        list.add("IT");
        list.add("无知君");

        Object o1 = ((LinkedList) list).getFirst();
        Object o2 = ((LinkedList) list).getLast();
//        list.sort(new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                return 0;
//            }
//        });
        System.out.print("list：" + JSON.toJSONString(list));
    }

    @Test
    void stack_test() {

        Stack s = new Stack();
        s.push("我是");
        s.push("IT");
        s.push("无知君");

        System.out.println("top：" + JSON.toJSONString( s.peek()));

        System.out.println("search：" + JSON.toJSONString( s.search("无知君")));
        System.out.println("search：" + JSON.toJSONString( s.search("IT")));
        System.out.println("search：" + JSON.toJSONString( s.search("我是")));

//        s.pop();
//        System.out.println("peek-top：" + JSON.toJSONString( s.peek()));

        String [] str = new String[3];
        int i = 0;
        try {
            while(s.peek() != null){
                String temp = (String) s.peek();
                str[i] = temp;
                s.pop();
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("str：" + JSON.toJSONString(str));

    }

    @Test
    void queue_test() throws InterruptedException {
        Queue<String> queue = new ArrayBlockingQueue<>(5);
        queue.add("A");
        queue.add("B");
        queue.add("C");
        queue.add("D");
        queue.add("E");
        try {
            queue.add("F");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("queue-1：" + JSON.toJSONString(queue));
        queue.offer("F2");
        System.out.println("queue-1：" + JSON.toJSONString(queue));
        ((ArrayBlockingQueue<String>) queue).put("G");
        queue.poll();
        System.out.println("queue-2：" + JSON.toJSONString(queue));
//        System.out.println("queue2：" + JSON.toJSONString(queue));
//        queue.poll();
//        System.out.println("queue3：" + JSON.toJSONString(queue));

    }

}
