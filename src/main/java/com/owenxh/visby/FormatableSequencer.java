package com.owenxh.visby;

import com.owenxh.visby.support.SequenceDecorateStrategy;
import com.owenxh.visby.util.Assert;

import java.io.Serializable;

/**
 * 序列号装饰器
 *
 * @author <a href="mailto:sowen1023@gmail.com">Owen.Yuan</a>
 * @since 2018/5/8
 */
public class FormatableSequencer implements Sequencer {

    /**
     * 委托的序列号生成器
     */
    private Sequencer delegate;

    private SequenceDecorateStrategy strategy;

    public FormatableSequencer(Sequencer sequencer, SequenceDecorateStrategy strategy) {
        Assert.notNull(sequencer, "[sequencer] must not be null");
        Assert.notNull(strategy,  "[strategy]  must not be null");

        this.delegate = sequencer;
        this.strategy = strategy;
    }

    @Override
    public Serializable next() {
        return strategy.decorate(delegate.next());
    }

}
