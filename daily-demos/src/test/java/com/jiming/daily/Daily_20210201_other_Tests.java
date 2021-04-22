package com.jiming.daily;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
    void lock_test() {
    }

}
