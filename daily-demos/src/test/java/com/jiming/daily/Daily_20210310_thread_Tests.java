package com.jiming.daily;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

/**
 * Java基础 —— 并发
 *
 * @author Mr.tjm
 * @date 2021-3-10 17:25
 */
public class Daily_20210310_thread_Tests {

//    private static final CountDownLatch cdl = new CountDownLatch(3);

    // 线程池原理：是LinkedBlockQueue队列
    /**
     * 计时器（闭锁）：CountDownLatch
     */
    @Test
    void thread_test_1() throws InterruptedException {
        // 闭锁 初始化 3
        CountDownLatch latch = new CountDownLatch(2);

        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("线程 " + Thread.currentThread().getName() + "到达 await 【上】部分 ");
                        latch.await();
                        System.out.println("线程 " + Thread.currentThread().getName() + "到达 await 【下】部分 ");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            System.out.println("循环次数：" + i + "，latch.getCount() = " + latch.getCount());
            latch.countDown();
        }
        Thread.sleep(1000L);
        System.out.println("CountDownLatch 开启，一起执行【下】部分——————");
        latch.countDown();
    }

    /**
     * 循环栅栏：CyclicBarrier
     *
     * 线程调用 await() 表示自己已经到达栅栏
     * BrokenBarrierException 表示栅栏已经被破坏，破坏的原因可能是其中一个线程 await() 时被中断或者超时
     */
    @Test
    void thread_test_2() throws InterruptedException {
        // 栅栏锁 初始化 3
        CyclicBarrier cys = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("完成最后的任务！！");
            }
        });

        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("线程 " + Thread.currentThread().getName() + "到达 await 【上】部分 ");
                        cys.await();
                        System.out.println("线程 " + Thread.currentThread().getName() + "到达 await 【下】部分 ");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            System.out.println("循环次数：" + i);
        }
        Thread.sleep(5000L);
        System.out.println("CyclicBarrier 执行完成 ——————");
    }

    /**
     * 信号量：Semaphore
     *
     * new Semaphore(n)：同一时间，只允许 n 个线程访问 acquire 和 release 之间的数据
     *
     * void acquire()：从此信号量【获取】一个许可，在提供一个许可前一直将线程阻塞，否则线程被中断。
     * void release()：【释放】一个许可，将其返回给信号量。
     */
    @Test
    void thread_test_3() throws InterruptedException  {
        Semaphore sh = new Semaphore(2);
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("线程 " + Thread.currentThread().getName() + "到达 await 【上】部分 ");
                        sh.acquire();
                        Thread.sleep(100L);
                        System.out.println("线程 " + Thread.currentThread().getName() + "到达 await 【下】部分 ");
                        sh.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            System.out.println("循环次数：" + i + "");
        }
        Thread.sleep(1000L);
        System.out.println("Semaphore 执行完成！！");
    }


    // ———————————————————— create thread ————————————————————


    @Test
    void thread_test_4() throws InterruptedException  {
        new TaskThread().start();
        new TaskThread().start();
        new TaskThread().start();

        TaskRunnable run1 = new TaskRunnable();
        Thread th1 = new Thread(run1, "Run线程1");
        Thread th2 = new Thread(run1, "Run线程2");
        Thread th3 = new Thread(run1, "Run线程3");
        th1.start();
        th2.start();
        th3.start();

        TaskCallable ctt1 = new TaskCallable();
        FutureTask<Integer> ft1 = new FutureTask<>(ctt1);
        Thread th11 = new Thread(ft1, "Call线程1");
        th11.start();

        try {
            int i = ft1.get();
            System.out.println("i = " + i);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Callable 执行完成！！");
    }
    /**
     *
     */
    class TaskThread extends Thread {
        public void run() {
            for (int i = 0; i <10 ; i++) {
                System.out.println("Thread = " + getName() + "  " + i);
            }
        }
    }

    /**
     * Runnable
     */
    class TaskRunnable implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i <10 ; i++) {
                System.out.println("Runnable = " + Thread.currentThread().getName() + "  " + i);
            }
        }
    }

    /**
     * Callable
     */
    class TaskCallable implements Callable {
        @Override
        public Object call() throws Exception {
            int i = 0;
            do {
                i++;
                System.out.println("Callable = " + Thread.currentThread().getName() + "  " + i);
            } while (i < 5);
            return i;
        }
    }





























}
