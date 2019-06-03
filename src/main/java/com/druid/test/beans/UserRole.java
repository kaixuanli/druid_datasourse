package com.druid.test.beans;

import lombok.Data;

import java.io.Serializable;

/**
 * @author likaixuan email:likaixuan(a)innodev.com.cn
 * @Date: 2019/5/31 16:11
 * @Version 1.0
 */
@Data
public class UserRole implements Serializable {

    private Long userId;
    private Long roleId;
}
