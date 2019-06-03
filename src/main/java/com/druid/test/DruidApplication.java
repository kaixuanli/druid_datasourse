package com.druid.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author likaixuan email:likaixuan(a)innodev.com.cn
 * @Date: 2019/5/20 18:16
 * @Version 1.0
 */

@SpringBootApplication
@ServletComponentScan
public class DruidApplication {
    public static void main(String[] args) {
        SpringApplication.run(DruidApplication.class, args);
    }
}
