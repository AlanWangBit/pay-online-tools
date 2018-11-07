package com.alan.pay.dto;

import lombok.Data;

/**
 * @author Alan Wang
 * @Date 2018/6/16.
 */
@Data
public class WechatDto {

    private String access_token;

    private String expires_in;

    private String refresh_token;

    private String openid;

    private String scope;
}
