package com.alan.alipay.strategy;

import com.alipay.api.AlipayClient;
import lombok.Getter;

/**
 * @author Alan Wang
 * @Date 2018/9/18.
 */
public class AlipayConfigContext {

    @Getter
    private AlipayConfigStrategy strategy;

    public AlipayConfigContext(AlipayConfigStrategy strategy) {
        this.strategy = strategy;
    }

    public AlipayClient getClient() {
        return strategy.getClient();
    }
}
