package com.alan.pay.controller;

import com.alan.pay.alipay.strategy.AlipayConfigModel;
import com.alan.pay.alipay.strategy.impl.AlipaymentSandboxStrategy;
import com.alipay.api.AlipayApiException;
import com.alipay.api.domain.AlipayTradeRefundModel;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.alipay.api.response.AlipayTradeWapPayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Alan Wang
 * @date 2018/11/5.
 */
@RestController
@RequestMapping("/version1/pay/wechat")
public class WechatController {

    private AlipaymentSandboxStrategy alipaymentHzStrategy;

    @Autowired
    public WechatController(AlipayConfigModel model) {
        alipaymentHzStrategy = new AlipaymentSandboxStrategy(model);
    }

    /**
     * 获取支付页面的二维码
     * @return map
     */
    @RequestMapping("qrCode")
    public Object qrCode() {
        Map<String, Object> map = new HashMap<>(3);
        map.put("success", true);
        map.put("url", "http://captain.natappvip.cc/version1/pay/web/wechat/info?invoiceId=AI20181105123645685");

        return map;
    }

    /**
     * 页面点击“立即支付”向支付宝发起支付请求，请求成功后向支付信息 返回到前台
     * @return 支付信息
     */
    @RequestMapping("createOrder")
    public Object createOrder(@RequestParam String invoiceId) {

        Map<String, Object> map = new HashMap<>(3);
        map.put("success", true);

        AlipayTradeWapPayRequest request = new AlipayTradeWapPayRequest();
        AlipayTradeWapPayModel payModel = new AlipayTradeWapPayModel();

        invoiceId = "AI"+String.valueOf(System.currentTimeMillis());

        payModel.setOutTradeNo(invoiceId);
        payModel.setTotalAmount("100000");
        payModel.setTimeoutExpress("2m");
        payModel.setProductCode(invoiceId);
        try {
            payModel.setBody(URLEncoder.encode("支付宝H5支付BODY", "UTF-8"));
            payModel.setSubject(URLEncoder.encode("支付宝H5支付Subject", "UTF-8"));
            request.setBizModel(payModel);
            AlipayTradeWapPayResponse payResponse = alipaymentHzStrategy.pageExecute(request);

            String form = payResponse.getBody();
            map.put("content", form);
        } catch (UnsupportedEncodingException | AlipayApiException e) {
            e.printStackTrace();
        }

        return map;
    }

    /**
     * 申请退款
     * @param invoiceId 收款单id
     * @return obj
     */
    @RequestMapping("refund")
    public Object refund(@RequestParam String invoiceId) {

        Map<String, Object> map = new HashMap<>(3);
        map.put("success", true);

        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        AlipayTradeRefundModel refundModel = new AlipayTradeRefundModel();

        refundModel.setOutTradeNo(invoiceId);
        refundModel.setRefundAmount("10000");
        refundModel.setRefundReason("正常退款");
        refundModel.setOutRequestNo("REFUND0000001");
        try {
            request.setBizModel(refundModel);
            AlipayTradeRefundResponse refundResponse = alipaymentHzStrategy.executeRefund(request);
            String form = refundResponse.getBody();
            System.out.println(refundResponse);
            map.put("content", form);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        return map;
    }

    /**
     * 支付宝回调接口（付款，退款）
     * @param request 请求
     */
    @RequestMapping(value = "notify")
    public void notifyUrl(HttpServletRequest request) {
        Map<String, String> params = getParams(request);
        System.out.println("notify............................................................");
        System.out.println("params = " + params);
    }

    private Map<String, String> getParams(HttpServletRequest request) {
        Map<String, String> params = new HashMap<>(3);
        Map requestParams = request.getParameterMap();
        for (Object o : requestParams.keySet()) {
            String name = (String) o;
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }
        return params;
    }
}
