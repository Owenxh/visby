package com.owenxh.visby;

import com.owenxh.visby.support.NonSequenceDecorator;
import com.owenxh.visby.support.SequenceDecorateStrategy;
import com.owenxh.visby.util.Assert;

import java.io.Serializable;

/**
 * 具备格式化功能的序列号
 *
 * @author <a href="mailto:sowen1023@gmail.com">Owen.Yuan</a>
 * @since 2018/5/8
 */
public class FormattableSequencer implements Sequencer {

    private static SequenceDecorateStrategy NON_DECORATOR = new NonSequenceDecorator();

    private SequenceDecorateStrategy strategy;

    private Sequencer delegated;

    public FormattableSequencer(Sequencer delegated) {
        this(delegated, NON_DECORATOR);
    }

    public FormattableSequencer(Sequencer delegated, SequenceDecorateStrategy strategy) {
        Assert.notNull(delegated, "[delegated] must not be null");
        Assert.notNull(strategy,  "[strategy]  must not be null");

        this.delegated = delegated;
        this.strategy = strategy;
    }

    @Override
    public Serializable next() {
        return strategy.decorate(delegated.next());
    }

    /**
     * {@link #strategy} setter 方法
     * @param strategy
     */
    public void setStrategy(SequenceDecorateStrategy strategy) {
        Assert.notNull(strategy, "[strategy] must be null");

        this.strategy = strategy;
    }
}
