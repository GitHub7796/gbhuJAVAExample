package main.gbhu.dateLearn;

import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;

public class SystemCurrentTimeMillis {
    /**
     * System.currentTimeMillis return long
     * 常用来 init java.util.Date、java.sql.Timestamp、java.sql.Date
     */
    @Test
    public void test() {
        long timeNow  = System.currentTimeMillis();
        Date utilDate = new Date(timeNow);
        java.sql.Date sqlDate = new java.sql.Date(timeNow);
        Timestamp timestamp = new Timestamp(timeNow);
        System.out.println(utilDate);
        //Fri May 24 09:41:39 CST 2024
        System.out.println(sqlDate);
        //2024-05-24
        System.out.println(timestamp);
        //2024-05-24 09:41:39.643
    }

    /**
     * 计时器
     * @throws InterruptedException
     */
    @Test
    public void test2() throws InterruptedException {
        long startTime = System.currentTimeMillis();

        //处理逻辑
        Thread.sleep(100);

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);
        //114 结果一直在变化
    }

    /**
     * 计时器 使用自定义封装类
     * @throws InterruptedException
     */
    @Test
    public void test3() throws InterruptedException {
        //使用封装的Timer
        Timer timer = new Timer();
        timer.start();

        //处理逻辑
        Thread.sleep(100);

        timer.end();
        long totalTime1 = timer.getTotalTime();
        System.out.println(totalTime1);
        //109 结果一直在变化
    }
}
