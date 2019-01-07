package com.wangxhu.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SynchronizedExample1 {

    // 修饰一个代码块，作用于当前对象，不同对象调用该代码块是不相互影响的
    //该方法等同于test2方法
    public void test1(int j) {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.println("test1 {" + j+"}" +i);
            }
        }
    }

    // 修饰一个方法
    public synchronized void test2(int j) {
        for (int i = 0; i < 10; i++) {
            System.out.println("test1 {" + j+"}" +i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample1 example1 = new SynchronizedExample1();
        SynchronizedExample1 example2 = new SynchronizedExample1();
        /**
         * 创建一个线程池，保证下面按顺序执行
         */
        ExecutorService executorService = Executors.newCachedThreadPool();
        /**
         * 顺序执行
         */
        executorService.execute(() -> {
            example1.test1(1);
        });
        executorService.execute(() -> {
            example1.test1(1);
        });

        executorService.execute(() -> {
            example1.test2(2);
        });
        executorService.execute(() -> {
            example1.test2(2);
        });


        /**
         * example1和example2交叉执行
         */
        executorService.execute(() -> {
            example1.test1(2);
        });
        executorService.execute(() -> {
            example2.test1(2);
        });
    }
}
