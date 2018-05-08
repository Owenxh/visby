package com.owenxh.visby;

import java.io.Serializable;

/**
 * 序列号生成器
 *
 * @author <a href="mailto:sowen1023@gmail.com">Owen.Yuan</a>
 * @since 2018/5/7
 */
public interface Sequencer {

    /**
     * 生成下一个流水号
     * @return 流水号
     * @throws SequenceExhaustedException 当序列号用尽时将抛出该异常
     */
    Serializable next();
}
