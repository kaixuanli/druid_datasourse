package com.druid.test.controller;

import com.druid.test.utils.CodeUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 将用户输入的验证码和后台进行比对
 * @author likaixuan email:likaixuan(a)innodev.com.cn
 * @Date: 2019/5/24 15:45
 * @Version 1.0
 */
@RestController
public class CodeCheckController {
    @RequestMapping("/hello")
    public String hello(HttpServletRequest request) {
        if (!CodeUtil.checkVerifyCode(request)) {
            return "验证码有误！";
        } else {
            return "验证通过";
        }
    }
}
