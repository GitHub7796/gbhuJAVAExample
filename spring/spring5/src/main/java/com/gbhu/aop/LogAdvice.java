package com.gbhu.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect//声明，这是一个切面
public class LogAdvice {

    @Pointcut("execution(* com.gbhu.service.impl.VideoServiceImpl.*(..))")
    public void aspect() {
    }

    //前置通知
    @Before("aspect()")
//    @Before("execution(* com.gbhu.service.impl.VideoServiceImpl.*(..))")
    public void beforeLog() {
        System.out.println("注解配置aop 打印日志 start");
    }

    //后置通知
    @After("aspect()")
   public void afterLog() {
        System.out.println("注解配置aop 打印日志 End");
    }


    //环绕通知，打印接口耗时
    @Around("aspect()")
    public Object around(JoinPoint joinPoint) {
        //通过joinPoint获取信息
        Object target = joinPoint.getTarget().getClass().getName();
        System.out.println("调用者"+target);
        System.out.println("调用方法" + joinPoint.getSignature());
//        Object[] args = joinPoint.getArgs();
//        System.out.println("参数"+args);

        long start = System.currentTimeMillis();
        System.out.println("环绕通知前=====" +start);

        int res;
        //执行连接点的方法
        try {
            res= (int) ((ProceedingJoinPoint) joinPoint).proceed();
        } catch (Throwable e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        System.out.println("环绕通知前====="+end);
        System.out.println("调用方法总耗时 time= "+(end-start)+"ms");
        return res;
    }
}
