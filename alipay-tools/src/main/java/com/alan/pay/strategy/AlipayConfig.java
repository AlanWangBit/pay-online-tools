package com.alan.pay.strategy;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Alan Wang
 * @Date 2018/11/6.
 */
public class AlipayConfig {

    protected String notifyUrl;
    protected String returnUrl;
    protected String publicKey;
    protected String url;
    protected String appid;
    protected String privateKey;
    protected String format;
    protected String charset;
    protected String signtype;
    protected AlipayClient alipayClient;

    public AlipayConfig(AlipayConfigBaseModel model) {
        Map<String, String> map = new HashMap<>();
        try {
            map = BeanUtils.describe(model);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        this.notifyUrl = map.get("notifyUrl");
        this.returnUrl = map.get("returnUrl");
        this.publicKey = map.get("publicKey");
        this.url = map.get("url");
        this.appid = map.get("appid");
        this.privateKey = map.get("privateKey");
        this.format = map.get("format");
        this.charset = map.get("charset");
        this.signtype = map.get("signtype");
        this.alipayClient = new DefaultAlipayClient(url, appid, privateKey, format, charset, publicKey, signtype);
    }
}
