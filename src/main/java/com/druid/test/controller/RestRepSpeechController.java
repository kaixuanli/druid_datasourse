package com.druid.test.controller;

import com.druid.test.abstracts.SpeechConditionVO;
import com.druid.test.beans.Speech;
import com.druid.test.beans.User;
import com.druid.test.service.RepSpeechService;
import com.druid.test.service.UserService;
import com.druid.test.utils.PageResult;
import com.druid.test.utils.PageUtil;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author likaixuan email:likaixuan(a)innodev.com.cn
 * @Date: 2019/5/20 18:52
 * @Version 1.0
 */
@RestController
@RequestMapping("/repSpeech")
public class RestRepSpeechController {
    @Autowired
    private RepSpeechService repSpeechService;

    @Autowired
    private UserService userService;

    @RequiresPermissions("mvn:install")
    @PostMapping("/list")
    public PageResult getAll() {
        PageInfo<Speech> pageInfo = repSpeechService.findPageBreakByCondition();
        return PageUtil.tablePage(pageInfo);
    }
    //若登录的账号没有这个权限，会报UnauthorizedException
    //一般情况下，权限名和请求路径名一致
    @RequiresPermissions("getUserInfo")
    @PostMapping("/getUserInfo")
    public User getUserInfo(String name) {
        User userInfo = userService.findUserByName(name);
        return userInfo;
    }
}
