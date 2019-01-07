package com.wangxhu.concurrency.example.atomic;

import com.wangxhu.concurrency.annoations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;


/**
 * 这个类的作用就是原子性的对某个类的实例的一个字段进行更新
 */
@Slf4j
@ThreadSafe
public class AtomicExample5 {

    private static AtomicIntegerFieldUpdater<AtomicExample5> updater =
            AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class, "count");//指出对哪个字段进行更新

    public volatile int count = 100;//必须使用volitile关键字进行标记

    public int getCount() {
        return count;
    }


    public static void main(String[] args) {

        AtomicExample5 example5 = new AtomicExample5();

        if (updater.compareAndSet(example5, 100, 120)) {
            System.out.println("update success 1:"+example5.getCount());
        }

        if (updater.compareAndSet(example5, 100, 120)) {
            System.out.println("update success 2:"+example5.getCount());
        } else {
            System.out.println("update fail:"+example5.getCount());
        }
    }
}
