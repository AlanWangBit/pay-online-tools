package com.alan.alipay.strategy;

import com.alipay.api.AlipayApiException;
import com.alipay.api.request.AlipayTradeFastpayRefundQueryRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.alipay.api.response.AlipayTradeWapPayResponse;

/**
 * 支付策略接口
 * @author Alan Wang
 * @Date 2018/11/5.
 */
public interface AlipayStrategy {
    /**
     * 网站发起支付请求
     * @param request
     * @return
     */
    AlipayTradeWapPayResponse pageExecute(AlipayTradeWapPayRequest request) throws AlipayApiException;

    /**
     * 发起退款处理
     * @throws AlipayApiException
     * @return
     */
    AlipayTradeRefundResponse executeRefund(AlipayTradeRefundRequest request) throws AlipayApiException;

}
