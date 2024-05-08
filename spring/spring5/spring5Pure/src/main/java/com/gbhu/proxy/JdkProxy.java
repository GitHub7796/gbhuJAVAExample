package com.gbhu.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy implements InvocationHandler {
    //目标类
    private Object targetObject;

    //获取代理对象
    public Object newProxyInsatance(Object targetObject) {
        this.targetObject = targetObject;
        /**
         * 绑定关系，具体那个类型实现
         * newProxyInstance(ClassLoader loader,目标类加载器
         *                 Class<?>[] interfaces,目标类实现的interface
         *                InvocationHandler h
         *                )
         */
        return Proxy.newProxyInstance(
                targetObject.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(),
                this
        );
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        try {
            System.out.println("通过jdk动态代理调用 start "+method.getName());
            result = method.invoke(targetObject, args);
            System.out.println("通过jdk动态代理调用 End "+method.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
