package com.jiming.daily;

import org.hibernate.annotations.Synchronize;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.ReentrantLock;

/**
 * AQS 练习
 *
 * @author Mr.tjm
 * @date 2021-4-21 17:25
 */
public class Daily_20210421_JUC_AQS_Tests {
    private static final Logger logger = LoggerFactory.getLogger(Daily_20210421_JUC_AQS_Tests.class);

     private static final ReentrantLock lock = new ReentrantLock();

    /**
     * ReentrantLock
     */
    @Test
    void juc_test_1() {
        lock.lock();
        try {
            // 区
        } finally {
            lock.unlock();
        }
    }

    /**
     * Synchronized
     */
    @Test
    void juc_test_2() {

        synchronized(this){
            // 互斥区
        }
    }

    /**
     * 锁重入
     */
    public static void Reent_a(){
        lock.lock();
        try {
            // 调用了另一个加相同锁的方法b，就是锁重入
            Reent_b();
        } finally {
            lock.unlock();
        }
    }

    public static void Reent_b(){
        lock.lock();
        try {
            // 区
        } finally {
            lock.unlock();
        }
    }

    /** —————————— 代码跟踪 —————————— */



}
