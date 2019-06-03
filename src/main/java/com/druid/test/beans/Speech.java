package com.druid.test.beans;

import com.druid.test.abstracts.AbstractBO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author innodev java team
 * @version 1.0
 * @date 2019/04/02 09:55
 * @since 1.8
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Speech extends AbstractBO {
	private Long bankId;
	private Long userId;
	private String speechType;
	private String content;
}