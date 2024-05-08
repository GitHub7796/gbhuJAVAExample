package com.gbhu.proxy;

public class ProxyTest {
    public static void main(String[] args) {
        //静态代理
        PayService payService = new StaticPayServiceProxy(new PayServiceImpl());
        payService.callback("hello");

        //jdk动态代理
        JdkProxy jdkProxy = new JdkProxy();
        //获取代理对象
        PayService payServiceProxy = (PayService) jdkProxy.newProxyInsatance(new PayServiceImpl());
        payServiceProxy.callback("hello JdkProxy");

        //CGLIB动态代理
        CglibProxy cglibProxy = new CglibProxy();
        PayService payService1 = (PayService) cglibProxy.newProxyInstacne(new PayServiceImpl());
        payService1.callback("hello cgblib");
    }
}
