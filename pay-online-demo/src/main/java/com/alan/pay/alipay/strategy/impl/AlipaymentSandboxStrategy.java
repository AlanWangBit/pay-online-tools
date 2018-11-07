package com.alan.pay.alipay.strategy.impl;

import com.alan.pay.strategy.AlipayConfig;
import com.alan.pay.strategy.AlipayStrategy;
import com.alan.pay.alipay.strategy.AlipayConfigModel;
import com.alipay.api.AlipayApiException;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.alipay.api.response.AlipayTradeWapPayResponse;

/**
 * @author Alan Wang
 * @Date 2018/11/5.
 */
public class AlipaymentSandboxStrategy extends AlipayConfig implements AlipayStrategy {

    public AlipaymentSandboxStrategy(AlipayConfigModel model) {
        super(model);
    }

    @Override
    public AlipayTradeWapPayResponse pageExecute(AlipayTradeWapPayRequest request) throws AlipayApiException {
        // 此处必须设置，否则支付完成页面无法跳转，而且不会调用回调方法。
        request.setNotifyUrl(this.notifyUrl);
        request.setReturnUrl(this.returnUrl);
        return this.alipayClient.pageExecute(request);
    }

    @Override
    public AlipayTradeRefundResponse executeRefund(AlipayTradeRefundRequest request) throws AlipayApiException {
        // 此处必须设置，否则支付完成页面无法跳转，而且不会调用回调方法。
        request.setNotifyUrl(this.notifyUrl);
        request.setReturnUrl(this.returnUrl);
        return this.alipayClient.execute(request);
    }

}
