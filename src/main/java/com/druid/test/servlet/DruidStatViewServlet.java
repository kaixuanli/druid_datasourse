package com.druid.test.servlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * @author likaixuan email:likaixuan(a)innodev.com.cn
 * @Date: 2019/5/20 18:19
 * @Version 1.0
 */
@WebServlet(urlPatterns = "/druid/*", initParams = {
        @WebInitParam(name = "allow", value = "192.168.16.110,127.0.0.1"), // IP白名单// (没有配置或者为空，则允许所有访问)
        @WebInitParam(name = "deny", value = "192.168.1.111"), // IP黑名单// (存在共同时，deny优先于allow)
        @WebInitParam(name = "loginUsername", value = "root"), // 用户名
        @WebInitParam(name = "loginPassword", value = "root"), // 密码
        @WebInitParam(name = "resetEnable", value = "false")// 禁用HTML页面上的“Reset// All”功能
})
public class DruidStatViewServlet extends com.alibaba.druid.support.http.StatViewServlet{
    private static final long serialVersionUID = -2419291060366082741L;
}
