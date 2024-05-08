package com.gbhu.proxy;

public class PayServiceImpl implements PayService{
    @Override
    public String callback(String outTradeNo) {
        System.out.println("目标对象 callback");
        return outTradeNo;
    }

    @Override
    public String save(int userId, int productId) {
        System.out.println("目标对象 save");
        return null;
    }
}
