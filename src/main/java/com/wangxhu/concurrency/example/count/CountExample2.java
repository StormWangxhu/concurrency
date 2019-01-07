package com.wangxhu.concurrency.example.count;

import com.wangxhu.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>Created on 19-1-7</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 */

@Slf4j
@ThreadSafe
public class CountExample2 {

    //请求总数
    public static int clientTotal = 5000;

    //同时并发执行的线程数
    public static int threadTotal = 200;

//    public static int count = 0;

    public static AtomicInteger count = new AtomicInteger(0);  //


    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        /**
         * Semaphore这个类限制了活动的线程数
         * Semaphore(int permits):构造方法，创建具有给定许可数的计数信号量并设置为非公平信号量
         */
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(()->{
                try {
                    /**
                     * 线程需要通过acquire()方法获取许可，而release()释放许可。如果许可数达到最大活动数，
                     * 那么调用acquire()之后，便进入等待队列，等待已获得许可的线程释放许可，从而使得多线程能够合理的运行。
                     */
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(count.get());
    }

    private static void add() {
//        count++;
        count.getAndIncrement();
    }


}
