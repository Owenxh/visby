package com.owenxh.visby;

import com.owenxh.visby.util.Assert;

/**
 * 具备递增功能的序列号生成器
 *
 * @author <a href="mailto:sowen1023@gmail.com">Owen.Yuan</a>
 * @since 2018/5/8
 */
public abstract class IncrementableSequencer<S extends Number> implements Sequencer {

    /**
     * 最小序列号
     */
    protected final S minSequence;

    /**
     * 最大序列号
     */
    protected final S maxSequence;

    /**
     * 递增步长
     */
    protected final S incrementStep;

    /**
     * 是否支持循环
     */
    protected final boolean looped;

    public IncrementableSequencer(S minSequence, S maxSequence, S incrementStep, boolean looped) {
        Assert.nonNegative(minSequence,   "[minSequence]   must not be negative");
        Assert.nonNegative(maxSequence,   "[maxSequence]   must not be negative");
        Assert.nonNegative(incrementStep, "[incrementStep] must not be negative");

        this.minSequence = minSequence;
        this.maxSequence = maxSequence;
        this.incrementStep = incrementStep;
        this.looped = looped;
    }

    /**
     * {@link #looped} getter 方法
     *
     * @return <code>true</code> 表示序列号增长到最大值后从 0 开始重新循环
     *         <code>false</code> 表示不支持循环，当序列号增长到最大值后，再次调用 {@link #next()}
     *         方法将抛出 {@link SequenceExhaustedException}
     */
    protected boolean isLooped() {
        return looped;
    }

    /**
     * {@link #minSequence} getter 方法
     */
    protected S getMinSequence() {
        return minSequence;
    }

    /**
     * {@link #maxSequence} getter 方法
     */
    protected S maxSequence() {
        return maxSequence;
    }

    /**
     * {@link #incrementStep} getter 方法
     */
    protected S getIncrementStep() {
        return incrementStep;
    }

    @Override
    public synchronized S next() {
        try {
            return next0();
        } catch (SequenceExhaustedException e) {
            return nextSequenceIfExhausted(e);
        }
    }

    /**
     * 序列号用尽时，将触发该方法
     * @param e 序列号用尽异常
     * @return 一下个序列号
     * @throws SequenceExhaustedException 当无法处理时，将重新抛出
     */
    protected S nextSequenceIfExhausted(SequenceExhaustedException e) {
        if (!looped) {
            throw e;
        }

        reset();

        return next0();
    }

    /**
     * 获取下一个流水号
     * @return 下一个流水号
     * @throws SequenceExhaustedException 当序列号用尽时抛出
     */
    protected abstract S next0() throws SequenceExhaustedException;

    /**
     * 重置序列号，从 {@link #minSequence} 重新开始计算
     */
    protected abstract void reset();
}
