package com.druid.test.utils;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.FatalBeanException;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yadong.zhang email:yadong.zhang0415(a)gmail.com
 * @version 1.0
 * @date 2018/2/7 15:51
 * @since 1.0
 */
public class BeanConvertUtil {

    /**
     * sourceList --> targetList 转换
     *
     * @param sourceArray
     * @param targetArray
     * @param targetClazz
     * @param <T>
     * @return
     */
    public static <T> List<T> doConvert(List<?> sourceArray, List<?> targetArray, Class<T> targetClazz) {
        if (CollectionUtils.isEmpty(sourceArray) || CollectionUtils.isEmpty(targetArray)) {
            return null;
        }
//
//        if (sourceArray.size() != targetArray.size()) {
//            throw new GlobalException("sourceArray's size not equal targetArray's size");
//        }

        List<T> res = new ArrayList<>();
        for (int i = 0; i < sourceArray.size(); i++) {
            res.add(doConvert(sourceArray.get(i), targetArray.get(i), targetClazz));
        }
        return res;
    }

    /**
     * source --> target 的转换
     *
     * @param source 被转换的对象
     * @param target 转换成的对象
     * @param <T>
     * @return
     */
    public static <T> T doConvert(Object source, Object target, Class<T> clazz) {
        if (null == source || null == target) {
            return null;
        }
        BeanUtils.copyProperties(source, target);
        if (clazz.equals(target.getClass())) {
            return (T) target;
        }
        throw new ClassCastException(target.getClass() + " cannot be cast to " + clazz);
    }

    /**
     * sourceList --> targetList 转换
     *
     * @param sourceArray
     * @param target
     * @param <T>
     * @return
     */
//    public static <T> List<T> doConvert(List<?> sourceArray, Class<T> target) {
//        if (CollectionUtils.isEmpty(sourceArray) || null == target) {
//            return null;
//        }
//
//        List<T> res = new ArrayList<>();
//        for (Object aSourceArray : sourceArray) {
//            res.add(doConvert(aSourceArray, target));
//        }
//        return res;
//    }

//    /**
//     * source --> target 的转换
//     *
//     * @param source 被转换的对象
//     * @param target 转换成的对象
//     * @param <T>
//     * @return
//     */
//    public static <T> T doConvert(Object source, Class<T> target) {
//        if (null == source || null == target) {
//            return null;
//        }
//        try {
//            T t = target.newInstance();
//            BeanUtils.copyProperties(source, t);
//            return t;
//        } catch (InstantiationException e) {
//            throw new GlobalException(target + " - 可能为一个抽象类、接口、数组类、基本类型或者该类缺少无参构造方法！", e);
//        } catch (IllegalAccessException e) {
////            throw new GlobalException(target + " - 该类或其构造方法是不可访问的，或该类缺少无参构造方法！", e);
//        } catch (FatalBeanException e) {
////            throw new GlobalException(target + " - 序列化失败！", e);
//        }
//    }

    /**
     * source --> target 的转换
     *
     * @param source 被转换的对象
     * @param target 转换成的对象
     * @param <T>
     * @return
     */
    public static <T> T perfectConvert(Object source, Class<T> target) {
        if (null == source || null == target) {
            return null;
        }
        try {
            return JSON.parseObject(JSON.toJSONString(source), target);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * sourceList --> targetList 转换
     *
     * @param sourceArray
     * @param target
     * @param <T>
     * @return
     */
    public static <T> List<T> perfectConvert(List<?> sourceArray, Class<T> target) {
        if (null == sourceArray || null == target) {
            return null;
        }
        try {
            return JSON.parseArray(JSON.toJSONString(sourceArray), target);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
