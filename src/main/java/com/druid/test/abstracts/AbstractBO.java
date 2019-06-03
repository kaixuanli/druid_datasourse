package com.druid.test.abstracts;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0
 * @date 2018/4/16 16:26
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public abstract class AbstractBO implements Serializable {
    private static final long serialVersionUID = -7771130534675819166L;
    private Long id;

    private Date insertTime;
    private Date updateTime;
}
