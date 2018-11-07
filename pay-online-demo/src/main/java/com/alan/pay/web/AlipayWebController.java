package com.alan.pay.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Alan Wang
 * @Date 2018/11/5.
 */
@RestController
@RequestMapping("/version1/pay/web/alipay")
public class AlipayWebController {

    @RequestMapping({"/", "/index"})
    public ModelAndView index() {
        return new ModelAndView("index.html");
    }


    @RequestMapping("/info")
    public ModelAndView info(@RequestParam String invoiceId) {
        System.out.println(invoiceId);
        return new ModelAndView("payment_info.html").addObject("invoiceId", invoiceId);
    }

    @RequestMapping(value = "return")
    public ModelAndView returnUrl(HttpServletRequest request, Model model) {
        System.out.println("return");
        return new ModelAndView("successful.html");
    }
}
