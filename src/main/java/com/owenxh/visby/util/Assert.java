package com.owenxh.visby.util;

/**
 * 断言工具类
 *
 * @author <a href="mailto:sowen1023@gmail.com">Owen.Yuan</a>
 * @since 2018/5/7
 */
public abstract class Assert {

    /**
     * 断言非空
     * @param object 要断言是否非空的对象
     * @param message 断言失败异常使用的消息
     * @throws IllegalArgumentException 断言失败时抛出
     */
    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 断言表达式为真
     * @param expression 要断言的表达式
     * @param message 断言失败异常使用的消息
     * @throws IllegalArgumentException 断言失败时抛出
     */
    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 断言非负数
     * @param number 要断言的数字
     * @param message 断言失败异常使用的消息
     * @throws IllegalArgumentException 断言失败时抛出
     */
    public static void nonNegative(Number number, String message) {

        isTrue(!NumberUtils.isNegative(number), message);
    }

    /**
     * 断言正数
     * @param number 要断言的数字
     * @param message 断言失败异常使用的消息
     * @throws IllegalArgumentException 断言失败时抛出
     */
    public static void isPositive(Number number, String message) {
        isTrue(NumberUtils.isPositive(number), message);
    }

    public static void hasLength(String text, String message) {
        if (!StringUtils.hasLength(text)) {
            throw new IllegalArgumentException(message);
        }
    }

}
