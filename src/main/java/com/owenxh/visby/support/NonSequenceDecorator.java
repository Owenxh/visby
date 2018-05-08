package com.owenxh.visby.support;

import java.io.Serializable;

/**
 * 默认序列号装饰器
 * <p>
 *     不做任何装饰
 * </p>
 *
 * @author <a href="mailto:sowen1023@gmail.com">Owen.Yuan</a>
 * @since 2018/5/8
 */
public class NonSequenceDecorator implements SequenceDecorateStrategy {

    @Override
    public Serializable decorate(Serializable sequence) {
        return sequence;
    }
}
