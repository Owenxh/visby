package com.owenxh.visby;

import com.owenxh.visby.support.NonSequenceDecorator;
import com.owenxh.visby.support.SequenceDecorateStrategy;
import com.owenxh.visby.util.Assert;

import java.io.Serializable;

/**
 * 具备格式化功能的序列号基类
 *
 * @author <a href="mailto:sowen1023@gmail.com">Owen.Yuan</a>
 * @since 2018/5/8
 */
public abstract class FormatSequencerSupport implements Sequencer {

    private SequenceDecorateStrategy strategy = new NonSequenceDecorator();

    public FormatSequencerSupport() {}

//    public FormatSequencerSupport(int seqLength) {
//        Assert.isPositive(seqLength, "[seqLength] must be positive");
//
//        this.strategy = new FixedLengthDecorator(seqLength);
//    }

    public FormatSequencerSupport(SequenceDecorateStrategy strategy) {
        Assert.notNull(strategy, "[strategy] must be null");

        this.strategy = strategy;
    }

    @Override
    public Serializable next() {
        return strategy.decorate(next0());
    }

    /**
     * 获取下一个流水号
     * @return 下一个流水号
     * @throws SequenceExhaustedException 当序列号用尽时抛出
     */
    protected abstract Serializable next0() throws SequenceExhaustedException;

    /**
     * {@link #strategy} setter 方法
     * @param strategy
     */
    protected void setStrategy(SequenceDecorateStrategy strategy) {
        Assert.notNull(strategy, "[strategy] must be null");

        this.strategy = strategy;
    }
}
