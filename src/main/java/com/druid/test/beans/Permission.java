package com.druid.test.beans;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 权限实体
 * @author likaixuan email:likaixuan(a)innodev.com.cn
 * @Date: 2019/5/31 14:24
 * @Version 1.0
 */
@Data
@Entity
public class Permission {

    /**
     * 权限类型：菜单
     */
    public static int PTYPE_MENU = 1;
    /**
     * 权限类型：按钮
     */
    public static int PTYPE_BUTTON = 2;

    private Long pid;       // 权限id
    private String pname;   // 权限名称
    private Integer ptype;  // 权限类型：1.菜单；2.按钮
    private String pval;    // 权限值，shiro的权限控制表达式
    private Date created;   // 创建时间
    private Date updated;   // 修改时间
}
