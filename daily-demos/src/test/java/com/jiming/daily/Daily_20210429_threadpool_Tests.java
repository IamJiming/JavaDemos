package com.jiming.daily;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程池
 *
 * @author Mr.tjm
 * @date 2021-1-6 17:25
 */
@SpringBootTest
public class Daily_20210429_threadpool_Tests {
    private static final Logger logger = LoggerFactory.getLogger(Daily_20210429_threadpool_Tests.class);
    // 时间格式
    private static final SimpleDateFormat simple_1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final AtomicInteger cas = new AtomicInteger(1);

    private static final Integer in = Integer.MAX_VALUE;

    private static ExecutorService pool;
    @Test
    void pool_test() {
        logger.info("〓 〓 〓 〓 〓 〓 〓 〓 〓 〓 BEGIN 〓 〓 〓 〓 〓 〓 〓 〓 〓 〓 ");
        logger.info("〓 〓 〓 〓 〓 〓 〓 〓 〓 〓  END  〓 〓 〓 〓 〓 〓 〓 〓 〓 〓 ");
    }

    @Test
    void pool_test1() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        ExecutorService fixedThreadPool1 = Executors.newCachedThreadPool();
        ExecutorService fixedThreadPool2 = Executors.newSingleThreadExecutor(Executors.defaultThreadFactory());
        for (int i = 0; i < 10; i++) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    @Test
    void pool_test2() {
        //maximumPoolSize设置为2 ，拒绝策略为AbortPolic策略，直接抛出异常
        pool = new ThreadPoolExecutor(
                1,
                2,
                1000,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        for(int i=0;i<3;i++) {
            pool.execute(new ThreadTask());
        }

        //1.打印ClassLoaderTest的类加载器
        Class mainClass = ClassLoader.class;

    }

    public class ThreadTask implements Runnable{

        public ThreadTask() {

        }

        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }



}
