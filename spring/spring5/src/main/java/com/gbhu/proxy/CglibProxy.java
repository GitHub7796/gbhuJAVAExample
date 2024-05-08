package com.gbhu.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {
    //目标对象
    private Object targetObj;

    //绑定关系
    public Object newProxyInstacne(Object tartgetObject) {
        this.targetObj = tartgetObject;
        Enhancer enhancer = new Enhancer();
        //设置代理类为targetObj子类，重写方法，实现加强
        enhancer.setSuperclass(this.targetObj.getClass());
        //回调函数
        enhancer.setCallback(this);

        return enhancer.create();

    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        Object result = null;
        try {
            System.out.println("通过CGLIB动态代理调用 start "+method.getName());
            result= methodProxy.invokeSuper(o, args);
            System.out.println("通过CGLIB动态代理调用 end "+method.getName());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
