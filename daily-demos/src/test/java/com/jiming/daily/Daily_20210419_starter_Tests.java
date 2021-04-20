package com.jiming.daily;

import com.jiming.IHelloStarter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Spring Boot 核心 -- 自动以starter 启动
 *
 * @author Mr.tjm
 * @date 2021-4-16 17:25
 */
@SuppressWarnings("all")
public class Daily_20210419_starter_Tests {

    @Autowired
    private IHelloStarter helloStarter;

    /**
     * 测试是否被自动装配
     */
    @Test
    void starter_test_1() {

        System.out.println("验证开始...");

        helloStarter.welcome();

//        System.out.println("调用到了自定义的 Starter 类：" + );

        System.out.println("验证完成！");
    }
}
