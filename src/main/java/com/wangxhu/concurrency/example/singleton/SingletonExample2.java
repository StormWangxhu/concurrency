package com.wangxhu.concurrency.example.singleton;

import com.wangxhu.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>Created on 19-1-7</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 */


/**
 * 饿汉模式
 * 单例实例在类装载时进行创建
 */
@Slf4j
@ThreadSafe
public class SingletonExample2 {


    //私有构造函数
   private SingletonExample2(){

   }

   //单例对象
   private static SingletonExample2 instance = new SingletonExample2();


   //静态工厂方法
   public static SingletonExample2 getInstance(){
       return instance;
   }
}
