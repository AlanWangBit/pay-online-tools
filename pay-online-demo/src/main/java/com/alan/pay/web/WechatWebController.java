package com.alan.pay.web;

import com.alan.pay.dto.WechatDto;
import com.alan.pay.utils.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.alipay.api.internal.util.StringUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLEncoder;

/**
 * @author Alan Wang
 * @Date 2018/11/5.
 */
@RestController
@RequestMapping("/version1/pay/web/wechat")
public class WechatWebController {

    @RequestMapping({"/", "/index"})
    public ModelAndView index() {
        return new ModelAndView("wechat/index.html");
    }


    @RequestMapping("/info")
    public ModelAndView info(@RequestParam String invoiceId) {
        System.out.println(invoiceId);
        return new ModelAndView("wechat/payment_info.html").addObject("invoiceId", invoiceId);
    }

    @RequestMapping("/comfirm")
    public ModelAndView comfirm(@RequestParam String invoiceId) {
        System.out.println(invoiceId);
        return new ModelAndView("wechat/payment_info_comfirm.html").addObject("invoiceId", invoiceId);
    }

    @RequestMapping(value = "return")
    public ModelAndView returnUrl(HttpServletRequest request, Model model) {
        System.out.println("return");
        return new ModelAndView("wechat/successful.html");
    }

    @RequestMapping(value = "wx_redirect")
    public void redirectCallback(HttpServletRequest request, HttpServletResponse response) {
        String code = request.getParameter("code");
        String invoicedoc = request.getParameter("invoicedoc");
        String custName;
        String mobile;

        if(StringUtils.isEmpty(invoicedoc)) {
            new Exception("invoicedoc 不能为空");
        }

//        Tinvoice tinvoice = tinvoiceService.selectByInvoiceDoc(invoicedoc);
//        custName = tinvoice.getUsername();
//        mobile = tinvoice.getMobile();
//        if(null == tinvoice) {
//            // 订单不存在
//            return;
//        }

        String redirectUrl = "http://captain.natappvip.cc/version1/pay/web/wechat/comfirm";

//        String wxSecret = wxPayScanCodeStrategy.wxConfigScanCodeStrategy.wxSecret;
//        String wxAppid = wxPayScanCodeStrategy.wxConfigScanCodeStrategy.wxAppid;
//        String s = HttpRequest.sendGet("https://api.weixin.qq.com/sns/oauth2/access_token", "appid="+wxAppid+"&secret="+wxSecret+"&code="+code+"&grant_type=authorization_code");

//        WechatDto dto = JSON.parseObject(s, WechatDto.class);
//        String accessToken = dto.getAccess_token();
//        String openId = dto.getOpenid();
//
//        System.out.println("OpenId::::::" + dto.getOpenid());

//        BigDecimal money = tinvoice.getPaymentamount().setScale(2, BigDecimal.ROUND_HALF_UP);
//        try {
//            if(StringUtils.isNotEmpty(custName)) {
//                custName = URLEncoder.encode(custName, "UTF-8");
//            }
//            String url = redirectUrl+"?invoicedoc="+invoicedoc+"&custName="+custName +"&mobile="+mobile+"&money="+money.doubleValue()+"&openId="+openId;
//            response.sendRedirect(url);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
