package com.druid.test.abstracts;

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
public class SpeechConditionVO extends BaseConditionVO {
    private Long bankId;
    private String correct;
    private String speechType;
}

