package com.owenxh.visby.support;

import java.io.Serializable;

/**
 * 装饰序列号策略类
 *
 * @author <a href="mailto:sowen1023@gmail.com">Owen.Yuan</a>
 * @since 2018/5/8
 */
public interface SequenceDecorateStrategy {

    /**
     * 装饰序列号
     * @param sequence 被装饰的序列号
     * @return 装饰后的序列号
     */
    Serializable decorate(Serializable sequence);
}
