package com.gbhu.proxy;

public class StaticPayServiceProxy implements PayService{
    private PayService payService;

    public StaticPayServiceProxy(PayService payService) {
        this.payService = payService;
    }
    @Override
    public String callback(String outTradeNo) {
        System.out.println("通过静态代理调用 callback start");
        payService.callback(outTradeNo);
        System.out.println("通过静态代理调用 callback end");
        return outTradeNo;
    }

    @Override
    public String save(int userId, int productId) {
        System.out.println("代理对象 save");
        payService.save(userId, productId);
        return null;
    }
}
