package com.wangxhu.concurrency.example.singleton;

import com.wangxhu.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>Created on 19-1-7</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 */

 /**
 * 懒汉模式
 * 单例实例在第一次使用时进行创建
 */
@Slf4j
@NotThreadSafe
public class SingletonExample1 {

    private SingletonExample1(){

    }

    private static SingletonExample1 instance = null;

    /**
     * 单线程下是ok的，但是在多线程环境下，线程不安全
     * 线程A，B同时判断到33行
     * @return
     */
    public static SingletonExample1 getInstance(){
        if (instance==null){
            instance = new SingletonExample1();
        }
        return instance;
    }
}
