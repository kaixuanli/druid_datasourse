package com.druid.test.mapper;

import com.druid.test.abstracts.SpeechConditionVO;
import com.druid.test.beans.RepSpeech;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author innodev java team
 * @version 1.0
 * @date 2019/02/26 16:02
 * @since 1.8
 */
@Repository
@Mapper
@CacheConfig(cacheNames = "speech")
public interface RepSpeechMapper {
    //将更新的结果同步到redis中,一般用在更新语句中
    //@CachePut(key = "#p0")
    //@CacheEvict，删除缓存数据，一般用在删除语句中。allEntries=true,方法调用后将立即清除缓存
    //@CacheEvict(key ="#p0",allEntries=true)
    //将查询结果缓存到redis中,要存结果集很稳定那种，不然没意义
    @Cacheable(key ="'getAll'")
    List<RepSpeech> findPageBreakByCondition();
}
