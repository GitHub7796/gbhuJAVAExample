package com.gbhu.proxy;

public interface PayService {
    String callback(String outTradeNo);

    String save(int userId, int productId);
}
