package com.jiming.daily;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 日常测试类
 *
 * @author Mr.tjm
 * @date 2021-1-6 17:25
 */
@SpringBootTest
public class Daily_Tests {
    private static final Logger logger = LoggerFactory.getLogger(Daily_Tests.class);

    // 时间格式
    private static final SimpleDateFormat simple_1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Test
    void simple_test() {
        logger.info("〓 〓 〓 〓 〓 〓 〓 〓 〓 〓 BEGIN 〓 〓 〓 〓 〓 〓 〓 〓 〓 〓 ");

        String str = new String();

        logger.info("〓 〓 〓 〓 〓 〓 〓 〓 〓 〓  END  〓 〓 〓 〓 〓 〓 〓 〓 〓 〓 ");
    }

    /**
     * 给傻媳妇写的：时间戳转时间Demo
     * @date 2021-1-13 15:12
     */
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

    /**
     * GitHub Desktop 上使用“版本回滚”功能
     * 解释：
     *      Github 网页界面上没有 git revert 功能（如果你找到了，欢迎指正）;
     *      相比使用命令行，我更喜欢桌面化的操作，简洁方便不用记代码，还能推动科技进步。
     */
    @Test
    void Revert_test() {
        // 测试代码：测试 Git 版本回滚
    }
}
