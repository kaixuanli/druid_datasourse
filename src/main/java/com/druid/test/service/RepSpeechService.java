package com.druid.test.service;


import com.druid.test.abstracts.SpeechConditionVO;
import com.druid.test.beans.Speech;
import com.github.pagehelper.PageInfo;

/**
 * @author innodev java team
 * @version 1.0
 * @date 2019/02/26 16:02
 * @since 1.8
 */
public interface RepSpeechService  {

    PageInfo<Speech> findPageBreakByCondition();

}
