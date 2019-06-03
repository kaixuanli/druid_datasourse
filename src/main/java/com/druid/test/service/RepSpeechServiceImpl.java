package com.druid.test.service;

import com.druid.test.abstracts.SpeechConditionVO;
import com.druid.test.beans.RepSpeech;
import com.druid.test.beans.Speech;
import com.druid.test.mapper.RepSpeechMapper;
import com.druid.test.utils.BeanConvertUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;


/**
 * @author innodev java team
 * @version 1.0
 * @date 2019/02/26 16:02
 * @since 1.8
 */
@Service
public class RepSpeechServiceImpl implements RepSpeechService {

    @Autowired
    private RepSpeechMapper repSpeechMapper;

    @Override
    public PageInfo<Speech> findPageBreakByCondition() {

        List<RepSpeech> list = repSpeechMapper.findPageBreakByCondition();
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        PageInfo bean = new PageInfo<RepSpeech>(list);
        bean.setList(BeanConvertUtil.perfectConvert(list, Speech.class));
        return bean;
    }

}
