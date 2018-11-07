package com.alan.alipay.strategy;

import com.alipay.api.AlipayClient;

/**
 * @author Alan Wang
 * @Date 2018/9/17.
 */
public interface AlipayConfigStrategy {

    AlipayClient getClient();

}
