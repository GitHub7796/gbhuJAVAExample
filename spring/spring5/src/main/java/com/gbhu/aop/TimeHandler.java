package com.gbhu.aop;

import java.time.LocalDateTime;

//横切关注点
public class TimeHandler {
    public void printBefore() {
        System.out.println("printBefore日志 time=" + LocalDateTime.now().toString());
    }

    public void printAfter() {
        System.out.println("printAfter日志 time=" + LocalDateTime.now().toString());
    }
}
