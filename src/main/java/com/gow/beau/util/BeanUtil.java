package com.gow.beau.util;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName BeanUtil
 * @Author lzn
 * @DATE 2019/7/10 16:56
 */
public class BeanUtil {

    /**
     * 返回空的属性数组
     * @param source 源
     * @return String[]
     */
    private static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet();
        for(java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    /**
     * 复制
     * @param src 源
     * @param target DB
     */
    public static <T> T copyProperties(Object src, T target){
        if (src != null) {
            BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
        }
        return target;
    }
}
