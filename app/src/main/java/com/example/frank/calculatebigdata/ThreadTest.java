package com.example.frank.calculatebigdata;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: Frank
 * @email 1320259466@qq.com
 * @date: 2019/6/8
 * @time: 10:20
 * @fuction: about the role of class.
 */
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
//        Executor pool= Executors.newFixedThreadPool(1);
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 2, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        for (int i=0;i<10;i++){
            System.out.println("线程开始执行了。。。"+i);
            pool.execute(new Runnable() {
                @Override
                public void run() {

                    try {
                        System.out.println("开始沉睡。。。");
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            long completedTaskCount = pool.getCompletedTaskCount();
            int activeCount = pool.getActiveCount();
            long taskCount = pool.getTaskCount();
            System.out.println("活动："+activeCount+"  任务："+taskCount);
            System.out.println(completedTaskCount);
            if (completedTaskCount==2){
                System.out.println("子线程全部完成");
            }
        }


        int k=1;
        while (k>0){
            int activeCount = pool.getActiveCount();
            long taskCount = pool.getTaskCount();
            k=activeCount;
            System.out.println("监视活动："+activeCount+"  监视任务："+taskCount);
            Thread.sleep(2000);
        }

    }
}
