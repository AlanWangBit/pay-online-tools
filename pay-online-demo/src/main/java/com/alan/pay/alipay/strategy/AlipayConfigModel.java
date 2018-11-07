package com.alan.pay.alipay.strategy;

import com.alan.alipay.strategy.AlipayConfigBaseModel;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author Alan Wang
 * @Date 2018/11/6.
 */
@Data
@Component
@PropertySource({"classpath:alipay.properties"})
public class AlipayConfigModel extends AlipayConfigBaseModel {

    @Value("${alipay.sandbox.notify_url}")
    private String notifyUrl;
    @Value("${alipay.sandbox.return_url}")
    private String returnUrl;
    @Value("${alipay.sandbox.public_key}")
    private String publicKey;
    @Value("${alipay.sandbox.url}")
    private String url;
    @Value("${alipay.sandbox.appid}")
    private String appid;
    @Value("${alipay.sandbox.rsa_private_key}")
    private String privateKey;
    @Value("${alipay.sandbox.format}")
    private String format;
    @Value("${alipay.sandbox.charset}")
    private String charset;
    @Value("${alipay.sandbox.signtype}")
    private String signtype;
}
