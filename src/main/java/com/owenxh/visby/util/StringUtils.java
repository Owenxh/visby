package com.owenxh.visby.util;

/**
 * {@link String} 工具类
 *
 * @author <a href="mailto:sowen1023@gmail.com">Owen.Yuan</a>
 * @since 2018/5/8
 */
public abstract class StringUtils {

    public static boolean hasLength(String str) {
        return (str != null && !str.isEmpty());
    }
}
