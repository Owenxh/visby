package com.owenxh.visby.util;

/**
 * {@link Number} 工具类
 *
 * @author <a href="mailto:sowen1023@gmail.com">Owen.Yuan</a>
 * @since 2018/5/8
 */
public abstract class NumberUtils {

    /**
     * 判断 <code>number</code> 是否小于 0
     * @param number 待判断的数字
     * @return 判断结果
     */
    public static boolean isNegative(Number number) {
        Assert.notNull(number, "[number] must not be null");

        return number.intValue() < 0;
    }

    /**
     * 判断 <code>number</code> 是否为正数
     * @param number 待判断的数字
     * @return 判断结果
     */
    public static boolean isPositive(Number number) {
        Assert.notNull(number, "[number] must not be null");

        return number.intValue() > 0;
    }
}
