package com.druid.test.beans;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 角色实体
 * @author likaixuan email:likaixuan(a)innodev.com.cn
 * @Date: 2019/5/31 14:21
 * @Version 1.0
 */
@Data
@Entity
public class Role {

    private Long rid;       // 角色id
    private String rname;   // 角色名，用于显示
    private String rdesc;   // 角色描述
    private String rval;    // 角色值，用于权限判断
    private Date created;   // 创建时间
    private Date updated;   // 修改时间


}