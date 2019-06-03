package com.druid.test.beans;

import com.druid.test.abstracts.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;



/**
 * @author innodev java team
 * @version 1.0
 * @date 2019/02/26 16:02
 * @since 1.8
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RepSpeech extends AbstractDO {
	private Long bankId;
	private Long userId;
	private String speechType;
	private String content;
	private String remarks;

}
