package com.wangxhu.concurrency.example.singleton;

import com.wangxhu.concurrency.annoations.NotRecommand;
import com.wangxhu.concurrency.annoations.ThreadSafe;
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
@ThreadSafe
@NotRecommand  //性能上损耗
public class SingletonExample3 {

    // 私有构造函数
    private SingletonExample3() {

    }

    // 单例对象
    private static SingletonExample3 instance = null;

    // 静态的工厂方法
    //添加了synchronized进行保证原子性
    public static synchronized SingletonExample3 getInstance() {
        if (instance == null) {
            instance = new SingletonExample3();
        }
        return instance;
    }
}
