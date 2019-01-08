package com.wangxhu.concurrency.example.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>Created on 19-1-8</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 */

/**
 * 线程池的Executors.newCachedThreadPool()
 */
@Slf4j
public class ThreadPoolExample1 {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i <10 ; i++) {
            final int index = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("task: "+index);
                }
            });
        }

        /**
         * 记得关闭资源，如若没有这行代码，则一直在线
         */
        executorService.shutdown();
    }
}
